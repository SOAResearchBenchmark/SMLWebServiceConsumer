/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uom.seagle.wsConsumer.ejb;

import edu.sml.data.xsd.ObjectFactory;
import edu.sml.data.xsd.SimpleKMeansRequest;
import edu.sml.data.xsd.SimpleKMeansResponse;
import edu.sml.service.SMLService;
import gr.uom.seagle.wsConsumer.db.Graph;
import gr.uom.seagle.wsConsumer.db.Project;
import gr.uom.seagle.wsConsumer.db.Version;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Theodore Chaikalis
 */
@Stateless
@LocalBean
public class WebServiceClientBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/ssrg18.cs.ualberta.ca_8080/SMLService/services/SMLService.wsdl")
    private SMLService service;

    @Resource
    private SessionContext context;

    @PersistenceContext(unitName = "SeagleWebServiceConsumerPU")
    private EntityManager entityManager;

    public WebServiceClientBean() {
        System.out.println("Data bean created");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    void printProjects() {
        List<Project> projects = entityManager.createNamedQuery("Project.findAll").getResultList();
        for (Project p : projects) {
            System.out.println(p.getName());
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Project> getProjects() {
        return entityManager.createNamedQuery("Project.findAll").getResultList();
    }

    public void processProjects(Collection<CustomProject> selectedProjects) {
        Collection<Project> projectsForAnalysis = determineProjectsForAnalysis(selectedProjects);
        StringBuilder sb = new StringBuilder();
        SimpleKMeansRequest kmeansRequest = new SimpleKMeansRequest();
        for (Project p : projectsForAnalysis) {
            String projectName = p.getName();
            Version lastVersion = getLastVersion(p);
            Graph lastGraph = (Graph) entityManager.createNamedQuery("Graph.findByVid").setParameter("vid", lastVersion).getResultList().get(0);
            sb.append(projectName).append(",").append(lastGraph.getAlpha()).append(",").append(lastGraph.getCc()).append(",").append(lastGraph.getAverageDegree()).append("\n");
        }
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> kMeansParameter = objectFactory.createSimpleKMeansRequestSourceData(sb.toString());
        kmeansRequest.setSourceData(kMeansParameter);
        SimpleKMeansResponse response = clusterDataWithSimpleKMeans(kmeansRequest);
        System.out.println("Web Service Response :");
        System.out.println(response.getClusterAssignments());
        System.out.println(response.getResponseMessage().getValue());
    }

    private Collection<Project> determineProjectsForAnalysis(Collection<CustomProject> selectedProjects) {
        Collection<Project> projectsForAnalysis = new HashSet<>();
        for (Project p : getProjects()) {
            for (CustomProject cp : selectedProjects) {
                if (p.getName().equals(cp.getName())) {
                    projectsForAnalysis.add(p);
                }
            }
        }
        return projectsForAnalysis;
    }

    private Version getLastVersion(Project p) {
        Collection<Version> versions = p.getVersionCollection();
        if (versions != null && versions.size() > 0) {
            int indexOfLast = versions.size() - 1;
            Version[] v = new Version[1];
            Version lastVersion = versions.toArray(v)[indexOfLast];
            return lastVersion;
        }
        return new Version();
    }

    private SimpleKMeansResponse clusterDataWithSimpleKMeans(edu.sml.data.xsd.SimpleKMeansRequest request) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        edu.sml.service.SMLServicePortType port = service.getSMLServiceHttpSoap11Endpoint();
        return port.clusterDataWithSimpleKMeans(request);
    }

}

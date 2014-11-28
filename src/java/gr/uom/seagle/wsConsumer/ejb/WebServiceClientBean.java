/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uom.seagle.wsConsumer.ejb;

import edu.sml.data.xsd.SimpleKMeansResponse;
import edu.sml.service.SMLService;
import gr.uom.seagle.wsConsumer.db.Project;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    void printProjects(){
         List<Project> projects = entityManager.createNamedQuery("Project.findAll").getResultList();
        for(Project p : projects) {
            System.out.println(p.getName());
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Project> getProjects() {
        return entityManager.createNamedQuery("Project.findAll").getResultList();
    }
    
    public void processProjects(List<Project> selectedProjects) {
        
    }

    private SimpleKMeansResponse clusterDataWithSimpleKMeans(edu.sml.data.xsd.SimpleKMeansRequest request) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        edu.sml.service.SMLServicePortType port = service.getSMLServiceHttpSoap11Endpoint();
        return port.clusterDataWithSimpleKMeans(request);
    }



}

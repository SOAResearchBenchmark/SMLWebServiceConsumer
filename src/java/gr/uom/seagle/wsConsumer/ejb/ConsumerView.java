package gr.uom.seagle.wsConsumer.ejb;

import gr.uom.seagle.wsConsumer.db.Project;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Theodore Chaikalis
 */
@ManagedBean(name = "ConsumerView")
@ViewScoped
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ConsumerView implements Serializable {

    @EJB
    WebServiceClientBean dataBean;

    private int numberOfClusters;

    private List<CustomProject> availableProjects;
    private Set<CustomProject> selectedProjects;

    public ConsumerView() {
        numberOfClusters = 4;
        selectedProjects = new HashSet<>();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<CustomProject> getAvailableProjects() {
        List<Project> available = dataBean.getProjects();
        availableProjects = new ArrayList<>();
        for (Project p : available) {
            availableProjects.add(new CustomProject(p.getPid(), p.getName(), false));
        }
        return availableProjects;
    }

    public void setAvailableProjects(List<CustomProject> availableProjects) {
        this.availableProjects = availableProjects;
    }

    public Collection<CustomProject> getSelectedProjects() {
        for (CustomProject p : availableProjects) {
            if (p.isIncludeInAnalysis()) {
                selectedProjects.add(p);
            }
        }
        return selectedProjects;
    }

    public void setSelectedProjects(Set<CustomProject> selectedProjects) {
        this.selectedProjects = selectedProjects;
    }

    public int getNumberOfClusters() {
        return numberOfClusters;
    }

    public void setNumberOfClusters(int numberOfClusters) {
        this.numberOfClusters = numberOfClusters;
    }

    public void buttonAction() {
        addMessage("Calling Web Service");
        dataBean.processProjects(getSelectedProjects());
        //addMessage(s);
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void sendToWebService() {
        
    }

}

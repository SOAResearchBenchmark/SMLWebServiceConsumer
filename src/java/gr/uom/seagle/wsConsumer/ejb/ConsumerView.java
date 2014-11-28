
package gr.uom.seagle.wsConsumer.ejb;

import gr.uom.seagle.wsConsumer.db.Project;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Theodore Chaikalis
 */
@ManagedBean(name = "ConsumerView")
@ViewScoped
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ConsumerView implements Serializable{

    @EJB
    WebServiceClientBean dataBean;
    
    private List<Project> availableProjects;
    private List<Project> selectedProjects;
    
    public ConsumerView(){
        selectedProjects = new ArrayList<>();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<Project> getAvailableProjects() {
        availableProjects = dataBean.getProjects();
        return availableProjects;
    }

    public void setAvailableProjects(List<Project> availableProjects) {
        this.availableProjects = availableProjects;
    }

    public List<Project> getSelectedProjects() {
        return selectedProjects;
    }

    public void setSelectedProjects(List<Project> selectedProjects) {
        this.selectedProjects = selectedProjects;
    }
    
    public void sendToWebService(){
        
    }
    
    
}

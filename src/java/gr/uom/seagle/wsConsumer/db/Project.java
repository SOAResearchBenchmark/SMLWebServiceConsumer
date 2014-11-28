
package gr.uom.seagle.wsConsumer.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Theodore Chaikalis
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByPid", query = "SELECT p FROM Project p WHERE p.pid = :pid"),
    @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name"),
    @NamedQuery(name = "Project.findByVersions", query = "SELECT p FROM Project p WHERE p.versions = :versions"),
    @NamedQuery(name = "Project.findByGithubpath", query = "SELECT p FROM Project p WHERE p.githubpath = :githubpath"),
    @NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description"),
    @NamedQuery(name = "Project.findByAuthor", query = "SELECT p FROM Project p WHERE p.author = :author"),
    @NamedQuery(name = "Project.findByPimage", query = "SELECT p FROM Project p WHERE p.pimage = :pimage"),
    @NamedQuery(name = "Project.findByContactMail", query = "SELECT p FROM Project p WHERE p.contactMail = :contactMail")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pid")
    private Integer pid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "versions")
    private int versions;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "githubpath")
    private String githubpath;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Size(max = 20)
    @Column(name = "author")
    private String author;
    @Size(max = 100)
    @Column(name = "pimage")
    private String pimage;
    @Lob
    @Size(max = 65535)
    @Column(name = "ageVSnewOutEdges")
    private String ageVSnewOutEdges;
    @Lob
    @Size(max = 65535)
    @Column(name = "ageVSnewIncomingEdges")
    private String ageVSnewIncomingEdges;
    @Size(max = 100)
    @Column(name = "contactMail")
    private String contactMail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pid")
    private Collection<Timeline> timelineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pid")
    private Collection<Version> versionCollection;

    public Project() {
    }

    public Project(Integer pid) {
        this.pid = pid;
    }

    public Project(Integer pid, String name, int versions, String githubpath) {
        this.pid = pid;
        this.name = name;
        this.versions = versions;
        this.githubpath = githubpath;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersions() {
        return versions;
    }

    public void setVersions(int versions) {
        this.versions = versions;
    }

    public String getGithubpath() {
        return githubpath;
    }

    public void setGithubpath(String githubpath) {
        this.githubpath = githubpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getAgeVSnewOutEdges() {
        return ageVSnewOutEdges;
    }

    public void setAgeVSnewOutEdges(String ageVSnewOutEdges) {
        this.ageVSnewOutEdges = ageVSnewOutEdges;
    }

    public String getAgeVSnewIncomingEdges() {
        return ageVSnewIncomingEdges;
    }

    public void setAgeVSnewIncomingEdges(String ageVSnewIncomingEdges) {
        this.ageVSnewIncomingEdges = ageVSnewIncomingEdges;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    @XmlTransient
    public Collection<Timeline> getTimelineCollection() {
        return timelineCollection;
    }

    public void setTimelineCollection(Collection<Timeline> timelineCollection) {
        this.timelineCollection = timelineCollection;
    }

    @XmlTransient
    public Collection<Version> getVersionCollection() {
        return versionCollection;
    }

    public void setVersionCollection(Collection<Version> versionCollection) {
        this.versionCollection = versionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pid != null ? pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}

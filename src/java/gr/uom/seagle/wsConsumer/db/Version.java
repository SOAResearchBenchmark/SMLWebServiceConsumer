
package gr.uom.seagle.wsConsumer.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Theodore Chaikalis
 */
@Entity
@Table(name = "version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Version.findAll", query = "SELECT v FROM Version v"),
    @NamedQuery(name = "Version.findByVid", query = "SELECT v FROM Version v WHERE v.vid = :vid"),
    @NamedQuery(name = "Version.findByPid", query = "SELECT v FROM Version v WHERE v.pid = :pid"),
    @NamedQuery(name = "Version.findByDate", query = "SELECT v FROM Version v WHERE v.date = :date"),
    @NamedQuery(name = "Version.findByName", query = "SELECT v FROM Version v WHERE v.name = :name")})
public class Version implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vid")
    private Integer vid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vid")
    private Graph graph;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vid")
    private Sourcemetric sourcemetric;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vid")
    private Collection<Repometric> repometricCollection;
    @JoinColumn(name = "pid", referencedColumnName = "pid")
    @ManyToOne(optional = false)
    private Project pid;

    public Version() {
    }

    public Version(Integer vid) {
        this.vid = vid;
    }

    public Version(Integer vid, Date date, String name) {
        this.vid = vid;
        this.date = date;
        this.name = name;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Sourcemetric getSourcemetric() {
        return sourcemetric;
    }

    public void setSourcemetric(Sourcemetric sourcemetric) {
        this.sourcemetric = sourcemetric;
    }

    @XmlTransient
    public Collection<Repometric> getRepometricCollection() {
        return repometricCollection;
    }

    public void setRepometricCollection(Collection<Repometric> repometricCollection) {
        this.repometricCollection = repometricCollection;
    }

    public Project getPid() {
        return pid;
    }

    public void setPid(Project pid) {
        this.pid = pid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vid != null ? vid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Version)) {
            return false;
        }
        Version other = (Version) object;
        if ((this.vid == null && other.vid != null) || (this.vid != null && !this.vid.equals(other.vid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gr.uom.seagle.db.Version[ vid=" + vid + " ]";
    }

}

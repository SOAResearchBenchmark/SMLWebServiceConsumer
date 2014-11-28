
package gr.uom.seagle.wsConsumer.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Theodore Chaikalis
 */
@Entity
@Table(name = "repometric")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repometric.findAll", query = "SELECT r FROM Repometric r"),
    @NamedQuery(name = "Repometric.findByRmid", query = "SELECT r FROM Repometric r WHERE r.rmid = :rmid"),
    @NamedQuery(name = "Repometric.findByAuthors", query = "SELECT r FROM Repometric r WHERE r.authors = :authors"),
    @NamedQuery(name = "Repometric.findByCommits", query = "SELECT r FROM Repometric r WHERE r.commits = :commits"),
    @NamedQuery(name = "Repometric.findByFilesAdded", query = "SELECT r FROM Repometric r WHERE r.filesAdded = :filesAdded"),
    @NamedQuery(name = "Repometric.findByFilesDeleted", query = "SELECT r FROM Repometric r WHERE r.filesDeleted = :filesDeleted"),
    @NamedQuery(name = "Repometric.findByFilesModified", query = "SELECT r FROM Repometric r WHERE r.filesModified = :filesModified"),
    @NamedQuery(name = "Repometric.findByLinesAdded", query = "SELECT r FROM Repometric r WHERE r.linesAdded = :linesAdded"),
    @NamedQuery(name = "Repometric.findByLinesDeleted", query = "SELECT r FROM Repometric r WHERE r.linesDeleted = :linesDeleted"),
    @NamedQuery(name = "Repometric.findByTestFilesAdded", query = "SELECT r FROM Repometric r WHERE r.testFilesAdded = :testFilesAdded"),
    @NamedQuery(name = "Repometric.findByTestFilesModified", query = "SELECT r FROM Repometric r WHERE r.testFilesModified = :testFilesModified")})
public class Repometric implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rmid")
    private Integer rmid;
    @Column(name = "authors")
    private Integer authors;
    @Column(name = "commits")
    private Integer commits;
    @Column(name = "filesAdded")
    private Integer filesAdded;
    @Column(name = "filesDeleted")
    private Integer filesDeleted;
    @Column(name = "filesModified")
    private Integer filesModified;
    @Column(name = "linesAdded")
    private Integer linesAdded;
    @Column(name = "linesDeleted")
    private Integer linesDeleted;
    @Column(name = "testFilesAdded")
    private Integer testFilesAdded;
    @Column(name = "testFilesModified")
    private Integer testFilesModified;
    @JoinColumn(name = "vid", referencedColumnName = "vid")
    @ManyToOne(optional = false)
    private Version vid;

    public Repometric() {
    }

    public Repometric(Integer rmid) {
        this.rmid = rmid;
    }

    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public Integer getAuthors() {
        return authors;
    }

    public void setAuthors(Integer authors) {
        this.authors = authors;
    }

    public Integer getCommits() {
        return commits;
    }

    public void setCommits(Integer commits) {
        this.commits = commits;
    }

    public Integer getFilesAdded() {
        return filesAdded;
    }

    public void setFilesAdded(Integer filesAdded) {
        this.filesAdded = filesAdded;
    }

    public Integer getFilesDeleted() {
        return filesDeleted;
    }

    public void setFilesDeleted(Integer filesDeleted) {
        this.filesDeleted = filesDeleted;
    }

    public Integer getFilesModified() {
        return filesModified;
    }

    public void setFilesModified(Integer filesModified) {
        this.filesModified = filesModified;
    }

    public Integer getLinesAdded() {
        return linesAdded;
    }

    public void setLinesAdded(Integer linesAdded) {
        this.linesAdded = linesAdded;
    }

    public Integer getLinesDeleted() {
        return linesDeleted;
    }

    public void setLinesDeleted(Integer linesDeleted) {
        this.linesDeleted = linesDeleted;
    }

    public Integer getTestFilesAdded() {
        return testFilesAdded;
    }

    public void setTestFilesAdded(Integer testFilesAdded) {
        this.testFilesAdded = testFilesAdded;
    }

    public Integer getTestFilesModified() {
        return testFilesModified;
    }

    public void setTestFilesModified(Integer testFilesModified) {
        this.testFilesModified = testFilesModified;
    }

    public Version getVid() {
        return vid;
    }

    public void setVid(Version vid) {
        this.vid = vid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rmid != null ? rmid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repometric)) {
            return false;
        }
        Repometric other = (Repometric) object;
        if ((this.rmid == null && other.rmid != null) || (this.rmid != null && !this.rmid.equals(other.rmid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gr.uom.seagle.db.Repometric[ rmid=" + rmid + " ]";
    }

}

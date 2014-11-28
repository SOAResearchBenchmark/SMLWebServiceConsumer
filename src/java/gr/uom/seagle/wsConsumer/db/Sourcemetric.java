
package gr.uom.seagle.wsConsumer.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Theodore Chaikalis
 */
@Entity
@Table(name = "sourcemetric")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sourcemetric.findAll", query = "SELECT s FROM Sourcemetric s"),
    @NamedQuery(name = "Sourcemetric.findByMid", query = "SELECT s FROM Sourcemetric s WHERE s.mid = :mid"),
    @NamedQuery(name = "Sourcemetric.findByCbo", query = "SELECT s FROM Sourcemetric s WHERE s.cbo = :cbo"),
    @NamedQuery(name = "Sourcemetric.findByLcom", query = "SELECT s FROM Sourcemetric s WHERE s.lcom = :lcom"),
    @NamedQuery(name = "Sourcemetric.findByNom", query = "SELECT s FROM Sourcemetric s WHERE s.nom = :nom"),
    @NamedQuery(name = "Sourcemetric.findByNof", query = "SELECT s FROM Sourcemetric s WHERE s.nof = :nof"),
    @NamedQuery(name = "Sourcemetric.findByWmc", query = "SELECT s FROM Sourcemetric s WHERE s.wmc = :wmc"),
    @NamedQuery(name = "Sourcemetric.findByLoc", query = "SELECT s FROM Sourcemetric s WHERE s.loc = :loc")})
public class Sourcemetric implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mid")
    private Integer mid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cbo")
    private Double cbo;
    @Column(name = "lcom")
    private Double lcom;
    @Column(name = "nom")
    private Double nom;
    @Column(name = "nof")
    private Double nof;
    @Column(name = "wmc")
    private Double wmc;
    @Column(name = "loc")
    private Double loc;
    @JoinColumn(name = "vid", referencedColumnName = "vid")
    @OneToOne(optional = false)
    private Version vid;

    public Sourcemetric() {
    }

    public Sourcemetric(Integer mid) {
        this.mid = mid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Double getCbo() {
        return cbo;
    }

    public void setCbo(Double cbo) {
        this.cbo = cbo;
    }

    public Double getLcom() {
        return lcom;
    }

    public void setLcom(Double lcom) {
        this.lcom = lcom;
    }

    public Double getNom() {
        return nom;
    }

    public void setNom(Double nom) {
        this.nom = nom;
    }

    public Double getNof() {
        return nof;
    }

    public void setNof(Double nof) {
        this.nof = nof;
    }

    public Double getWmc() {
        return wmc;
    }

    public void setWmc(Double wmc) {
        this.wmc = wmc;
    }

    public Double getLoc() {
        return loc;
    }

    public void setLoc(Double loc) {
        this.loc = loc;
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
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sourcemetric)) {
            return false;
        }
        Sourcemetric other = (Sourcemetric) object;
        if ((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gr.uom.seagle.db.Sourcemetric[ mid=" + mid + " ]";
    }

}

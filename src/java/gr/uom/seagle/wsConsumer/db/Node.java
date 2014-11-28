
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Theodore Chaikalis
 */
@Entity
@Table(name = "node")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Node.findAll", query = "SELECT n FROM Node n"),
    @NamedQuery(name = "Node.findByNid", query = "SELECT n FROM Node n WHERE n.nid = :nid"),
    @NamedQuery(name = "Node.findByName", query = "SELECT n FROM Node n WHERE n.name = :name"),
    @NamedQuery(name = "Node.findByCc", query = "SELECT n FROM Node n WHERE n.cc = :cc"),
    @NamedQuery(name = "Node.findByPagerank", query = "SELECT n FROM Node n WHERE n.pagerank = :pagerank"),
    @NamedQuery(name = "Node.findByBtwncentrality", query = "SELECT n FROM Node n WHERE n.btwncentrality = :btwncentrality"),
    @NamedQuery(name = "Node.findByCbo", query = "SELECT n FROM Node n WHERE n.cbo = :cbo"),
    @NamedQuery(name = "Node.findByLcom", query = "SELECT n FROM Node n WHERE n.lcom = :lcom"),
    @NamedQuery(name = "Node.findByNom", query = "SELECT n FROM Node n WHERE n.nom = :nom"),
    @NamedQuery(name = "Node.findByWmc", query = "SELECT n FROM Node n WHERE n.wmc = :wmc"),
    @NamedQuery(name = "Node.findByNof", query = "SELECT n FROM Node n WHERE n.nof = :nof"),
    @NamedQuery(name = "Node.findByLoc", query = "SELECT n FROM Node n WHERE n.loc = :loc")})
public class Node implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nid")
    private Integer nid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cc")
    private Double cc;
    @Column(name = "pagerank")
    private Double pagerank;
    @Column(name = "btwncentrality")
    private Double btwncentrality;
    @Column(name = "cbo")
    private Integer cbo;
    @Column(name = "lcom")
    private Double lcom;
    @Column(name = "nom")
    private Integer nom;
    @Column(name = "wmc")
    private Double wmc;
    @Column(name = "nof")
    private Integer nof;
    @Column(name = "loc")
    private Integer loc;
    @JoinColumn(name = "gid", referencedColumnName = "gid")
    @ManyToOne(optional = false)
    private Graph gid;

    public Node() {
    }

    public Node(Integer nid) {
        this.nid = nid;
    }

    public Node(Integer nid, String name) {
        this.nid = nid;
        this.name = name;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCc() {
        return cc;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public Double getPagerank() {
        return pagerank;
    }

    public void setPagerank(Double pagerank) {
        this.pagerank = pagerank;
    }

    public Double getBtwncentrality() {
        return btwncentrality;
    }

    public void setBtwncentrality(Double btwncentrality) {
        this.btwncentrality = btwncentrality;
    }

    public Integer getCbo() {
        return cbo;
    }

    public void setCbo(Integer cbo) {
        this.cbo = cbo;
    }

    public Double getLcom() {
        return lcom;
    }

    public void setLcom(Double lcom) {
        this.lcom = lcom;
    }

    public Integer getNom() {
        return nom;
    }

    public void setNom(Integer nom) {
        this.nom = nom;
    }

    public Double getWmc() {
        return wmc;
    }

    public void setWmc(Double wmc) {
        this.wmc = wmc;
    }

    public Integer getNof() {
        return nof;
    }

    public void setNof(Integer nof) {
        this.nof = nof;
    }

    public Integer getLoc() {
        return loc;
    }

    public void setLoc(Integer loc) {
        this.loc = loc;
    }

    public Graph getGid() {
        return gid;
    }

    public void setGid(Graph gid) {
        this.gid = gid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nid != null ? nid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Node)) {
            return false;
        }
        Node other = (Node) object;
        if ((this.nid == null && other.nid != null) || (this.nid != null && !this.nid.equals(other.nid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gr.uom.seagle.db.Node[ nid=" + nid + " ]";
    }

}

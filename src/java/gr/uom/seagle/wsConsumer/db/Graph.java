
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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "graph")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Graph.findAll", query = "SELECT g FROM Graph g"),
    @NamedQuery(name = "Graph.findByGid", query = "SELECT g FROM Graph g WHERE g.gid = :gid"),
    @NamedQuery(name = "Graph.findByNodes", query = "SELECT g FROM Graph g WHERE g.nodes = :nodes"),
    @NamedQuery(name = "Graph.findByEdges", query = "SELECT g FROM Graph g WHERE g.edges = :edges"),
    @NamedQuery(name = "Graph.findByCc", query = "SELECT g FROM Graph g WHERE g.cc = :cc"),
    @NamedQuery(name = "Graph.findByDiameter", query = "SELECT g FROM Graph g WHERE g.diameter = :diameter"),
    @NamedQuery(name = "Graph.findByEdgesToNew", query = "SELECT g FROM Graph g WHERE g.edgesToNew = :edgesToNew"),
    @NamedQuery(name = "Graph.findByEdgesBtwnExisting", query = "SELECT g FROM Graph g WHERE g.edgesBtwnExisting = :edgesBtwnExisting"),
    @NamedQuery(name = "Graph.findByEdgesBtwnNew", query = "SELECT g FROM Graph g WHERE g.edgesBtwnNew = :edgesBtwnNew"),
    @NamedQuery(name = "Graph.findByDeletedEdges", query = "SELECT g FROM Graph g WHERE g.deletedEdges = :deletedEdges"),
    @NamedQuery(name = "Graph.findByEdgesToExisting", query = "SELECT g FROM Graph g WHERE g.edgesToExisting = :edgesToExisting"),
    @NamedQuery(name = "Graph.findByAlpha", query = "SELECT g FROM Graph g WHERE g.alpha = :alpha"),
    @NamedQuery(name = "Graph.findByAverageDegree", query = "SELECT g FROM Graph g WHERE g.averageDegree = :averageDegree"),
    @NamedQuery(name = "Graph.findByDensity", query = "SELECT g FROM Graph g WHERE g.density = :density")})
public class Graph implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gid")
    private Integer gid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nodes")
    private int nodes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edges")
    private int edges;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cc")
    private Double cc;
    @Column(name = "diameter")
    private Double diameter;
    @Column(name = "edgesToNew")
    private Integer edgesToNew;
    @Column(name = "edgesBtwnExisting")
    private Integer edgesBtwnExisting;
    @Column(name = "edgesBtwnNew")
    private Integer edgesBtwnNew;
    @Column(name = "deletedEdges")
    private Integer deletedEdges;
    @Column(name = "edgesToExisting")
    private Integer edgesToExisting;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "friendships")
    private String friendships;
    @Lob
    @Size(max = 65535)
    @Column(name = "degreeVScc")
    private String degreeVScc;
    @Lob
    @Size(max = 65535)
    @Column(name = "degreeVScount")
    private String degreeVScount;
    @Lob
    @Size(max = 65535)
    @Column(name = "hopsVScount")
    private String hopsVScount;
    @Lob
    @Column(name = "graph")
    private byte[] graph;
    @Column(name = "alpha")
    private Double alpha;
    @Column(name = "averageDegree")
    private Double averageDegree;
    @Column(name = "density")
    private Double density;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gid")
    private Collection<Node> nodeCollection;
    @JoinColumn(name = "vid", referencedColumnName = "vid")
    @OneToOne(optional = false)
    private Version vid;

    public Graph() {
    }

    public Graph(Integer gid) {
        this.gid = gid;
    }

    public Graph(Integer gid, int nodes, int edges) {
        this.gid = gid;
        this.nodes = nodes;
        this.edges = edges;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public int getEdges() {
        return edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public Double getCc() {
        return cc;
    }

    public void setCc(Double cc) {
        this.cc = cc;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Integer getEdgesToNew() {
        return edgesToNew;
    }

    public void setEdgesToNew(Integer edgesToNew) {
        this.edgesToNew = edgesToNew;
    }

    public Integer getEdgesBtwnExisting() {
        return edgesBtwnExisting;
    }

    public void setEdgesBtwnExisting(Integer edgesBtwnExisting) {
        this.edgesBtwnExisting = edgesBtwnExisting;
    }

    public Integer getEdgesBtwnNew() {
        return edgesBtwnNew;
    }

    public void setEdgesBtwnNew(Integer edgesBtwnNew) {
        this.edgesBtwnNew = edgesBtwnNew;
    }

    public Integer getDeletedEdges() {
        return deletedEdges;
    }

    public void setDeletedEdges(Integer deletedEdges) {
        this.deletedEdges = deletedEdges;
    }

    public Integer getEdgesToExisting() {
        return edgesToExisting;
    }

    public void setEdgesToExisting(Integer edgesToExisting) {
        this.edgesToExisting = edgesToExisting;
    }

    public String getFriendships() {
        return friendships;
    }

    public void setFriendships(String friendships) {
        this.friendships = friendships;
    }

    public String getDegreeVScc() {
        return degreeVScc;
    }

    public void setDegreeVScc(String degreeVScc) {
        this.degreeVScc = degreeVScc;
    }

    public String getDegreeVScount() {
        return degreeVScount;
    }

    public void setDegreeVScount(String degreeVScount) {
        this.degreeVScount = degreeVScount;
    }

    public String getHopsVScount() {
        return hopsVScount;
    }

    public void setHopsVScount(String hopsVScount) {
        this.hopsVScount = hopsVScount;
    }

    public byte[] getGraph() {
        return graph;
    }

    public void setGraph(byte[] graph) {
        this.graph = graph;
    }

    public Double getAlpha() {
        return alpha;
    }

    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    public Double getAverageDegree() {
        return averageDegree;
    }

    public void setAverageDegree(Double averageDegree) {
        this.averageDegree = averageDegree;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    @XmlTransient
    public Collection<Node> getNodeCollection() {
        return nodeCollection;
    }

    public void setNodeCollection(Collection<Node> nodeCollection) {
        this.nodeCollection = nodeCollection;
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
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Graph)) {
            return false;
        }
        Graph other = (Graph) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gr.uom.seagle.db.Graph[ gid=" + gid + " ]";
    }

}

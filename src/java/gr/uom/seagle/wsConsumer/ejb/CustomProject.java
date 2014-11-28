
package gr.uom.seagle.wsConsumer.ejb;

/**
 *
 * @author Theodore Chaikalis
 */
public class CustomProject {
    
    private String name;
    private int id;
    private boolean includeInAnalysis;

    public CustomProject() {
    }

    public CustomProject(int id, String name, boolean includeInAnalysis) {
        this.name = name;
        this.id = id;
        this.includeInAnalysis = includeInAnalysis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIncludeInAnalysis() {
        return includeInAnalysis;
    }

    public void setIncludeInAnalysis(boolean includeInAnalysis) {
        this.includeInAnalysis = includeInAnalysis;
    }

    @Override
    public String toString() {
        return id + " , "+name+" , Include? " + includeInAnalysis;
    }
    
    public int hashCode(){
        String s = ""+id;
        return s.hashCode();
    }
    

}

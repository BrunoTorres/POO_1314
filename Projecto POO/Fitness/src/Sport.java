
import java.util.TreeSet;


public class Sport
{
    private String type;
    private String name;
    private int caloriesPerHour;
    private float avgIntensity;
    private TreeSet<String> recordList;
    
    
    
    public Sport(){
        this.type="";
        this.name="";
        this.caloriesPerHour=0;
        this.avgIntensity=0;
        this.recordList=new TreeSet();
    }
    
    public Sport(String type,String name,int caloriesPerHour,float avgIntensity){
        this.type=type;
        this.name=name;
        this.caloriesPerHour=caloriesPerHour;
        this.avgIntensity=avgIntensity;
        this.recordList=new TreeSet();
    }
    
    public Sport(Sport s){
        
        this.type=s.getType();
        this.name=s.getName();
        this.caloriesPerHour=this.getCaloriesPerHour();
        this.avgIntensity=this.getAvgIntensity();
        this.recordList=s.getRecordList();
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the caloriesPerHour
     */
    public int getCaloriesPerHour() {
        return caloriesPerHour;
    }

    /**
     * @param caloriesPerHour the caloriesPerHour to set
     */
    public void setCaloriesPerHour(int caloriesPerHour) {
        this.caloriesPerHour = caloriesPerHour;
    }

    /**
     * @return the avgIntensity
     */
    public float getAvgIntensity() {
        return avgIntensity;
    }

    /**
     * @param avgIntensity the avgIntensity to set
     */
    public void setAvgIntensity(float avgIntensity) {
        this.avgIntensity = avgIntensity;
    }

    /**
     * @return the recordList
     */
    public TreeSet<String> getRecordList() {
        return recordList;
    }
    
    
    
    
    
    //
    public Sport clone(){
        return new Sport(this);
        
    }
}






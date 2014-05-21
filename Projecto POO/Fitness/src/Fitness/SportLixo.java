package Fitness;

import java.util.ArrayList;


public class SportLixo
{
    private String type;
    private String name;
    private int caloriesPerHour;
    private double avgIntensity;
    private ArrayList<Records> recordList;
    
    
    
    public Sport(){
        this.type = "";
        this.name = "";
        this.caloriesPerHour = 0;
        this.avgIntensity = 0;
        this.recordList = new ArrayList();
    }
    
    public Sport(String type, String name, int caloriesPerHour, double avgIntensity){
        this.type = type;
        this.name = name;
        this.caloriesPerHour = caloriesPerHour;
        this.avgIntensity = avgIntensity;
        this.recordList = new ArrayList();
    }
    
    public Sport(String type, String name, int caloriesPerHour, double avgIntensity, ArrayList<Records> recordList){
        this.type = type;
        this.name = name;
        this.caloriesPerHour = caloriesPerHour;
        this.avgIntensity = avgIntensity;
        for (Records rec : recordList)
            this.recordList.add(rec);
    }
    
    public Sport(Sport s){
        
        this.type = s.getType();
        this.name = s.getName();
        this.caloriesPerHour = this.getCaloriesPerHour();
        this.avgIntensity = this.getAvgIntensity();
        this.recordList = s.getRecordsList();
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the caloriesPerHour
     */
    public int getCaloriesPerHour() {
        return caloriesPerHour;
    }

    /**
     * @return the avgIntensity
     */
    public double getAvgIntensity() {
        return avgIntensity;
    }

    /**
     * @return the recordList
     */
    public ArrayList<Records> getRecordsList() {
        ArrayList<Records> reclist = new ArrayList();
        for (Records rec : this.recordList) 
            reclist.add(rec.clone());
        return reclist;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do desporto: ");sb.append(this.name);
        sb.append("Categoria: "); sb.append(this.type);
        sb.append("Gasta em media "); sb.append(this.caloriesPerHour);
        sb.append(" com intensidade de "); sb.append(this.avgIntensity);
        sb.append("Recordses deste desporto: \n");
        for (Records rec : this.recordList)
            sb.append(rec.toString()).append("\n");
        return sb.toString();
    }
    
    //
    public Sport clone(){
        return new Sport(this);
    }
}







package Fitness;

import java.util.ArrayList;
import java.util.TreeSet;

public class ListRecords {
    
    private final String name;            // nome do tipo (Cycling...)
    private ArrayList<Records> recs;
    
public ListRecords(){
    this.name="";
    this.recs=new ArrayList();
}
public ListRecords(String name){
    this.name=name;
    this.recs=new ArrayList();
}

public ListRecords(String name, TreeSet<Records> recs){
    this.name=name;
    for(Records r:recs)
        this.recs.add(r.clone());
    }
public ListRecords(ListRecords list){
    this.name=list.getName();
    this.recs=list.getList();
}

  public ArrayList<Records> getList() {
        ArrayList<Records> aux=new ArrayList();
        for(Records r:this.recs)
            aux.add(r);
        return aux;
   
    }
    
    

    public String getName() {
        return this.name;        
    }
    
    public void addRecord(Records rec){
        
        this.recs.add(rec);
    }
    
    
       
    
    
      public void setRecords(ListRecords list){
          int i=0;
          for(Records c : this.recs){
              c.update(list.getList().get(i));
              i++;
          }
              
              
      }
      
      
    //toString,equals,clone
    
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Nome: ").append(this.name).append("\n");
        for(Records r:this.recs)
            sb.append((r.toString()));
        
        return sb.toString();
    }
    
    public boolean equals(Object o){
        if(this==o)
            return true;
        if((o==null) ||(o.getClass() != this.getClass()))
            return false;
        ListRecords list=(ListRecords)o;
        return (this.name==list.getName() &&
                this.recs.equals(list.getList()));
    }
    
    public ListRecords clone(){
        return new ListRecords(this);
    }
    
}

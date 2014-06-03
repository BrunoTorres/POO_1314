
package Fitness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Bruno
 */
public class ListRecords implements Serializable {
    
    private final String name;            // nome do tipo (Cycling...)
    private ArrayList<Record> recs;
    
    /**
     *
     */
    public ListRecords(){
    this.name="";
    this.recs=new ArrayList<>();
}

    /**
     *
     * @param name
     */
    public ListRecords(String name){
    this.name=name;
    this.recs=new ArrayList<>();
}

    /**
     *
     * @param name
     * @param recs
     */
    public ListRecords(String name, TreeSet<Record> recs){
    this.name=name;
    for(Record r:recs)
        this.recs.add(r.clone());
    }

    /**
     *
     * @param list
     */
    public ListRecords(ListRecords list){
    this.name=list.getName();
    this.recs=list.getList();
}

    /**
     *
     * @return
     */
    public ArrayList<Record> getList() {
        ArrayList<Record> aux=new ArrayList<>();
        for(Record r:this.recs)
            aux.add(r);
        return aux;
   
    }

    /**
     *
     * @param list
     */
    public void updateList(ListRecords list){
      ArrayList<Record>array=list.getList();
      int i=0;
      for(Record r :this.recs){
          r.update(array.get(i));
          i++;
      }
  }
    
    /**
     *
     * @return
     */
    public String getName() {
        return this.name;        
    }
    
    /**
     *
     * @param rec
     */
    public void addRecord(Record rec){
        
        this.recs.add(rec);
    }
    
    /**
     *
     * @param list
     */
    public void setRecords(ListRecords list){
          int i=0;
          for(Record c : this.recs){
              c.update(list.getList().get(i));
              i++;
          }
              
              
      }
      
      
    //toString,equals,clone
    
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Nome do tipo da actividade: ").append(this.name).append("\n");
        for(Record r:this.recs)
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

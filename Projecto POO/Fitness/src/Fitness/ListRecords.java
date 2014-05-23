
package Fitness;

import java.util.TreeSet;

public class ListRecords {
    
    private final String name;            // nome do tipo (Cycling...)
    private TreeSet<Records> recs;
    
public ListRecords(){
    this.name="";
    this.recs=new TreeSet();
}
public ListRecords(String name){
    this.name=name;
    this.recs=new TreeSet();
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

  public TreeSet<Records> getList() {
        TreeSet<Records> aux=new TreeSet();
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
    
    
       
    
    
      public void setRecords();
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

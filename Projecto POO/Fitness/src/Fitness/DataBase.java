package Fitness;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DataBase
{
   // private TreeSet<Sport> sportsType;
    private TreeSet<Person>userList;  // admin && users
    private TreeSet<Event> eventList;
    
    
    public DataBase(){
       // this.sportsType= new TreeSet<Sport>();
        this.userList= new TreeSet<Person>(new ComparePerson());
        this.eventList= new TreeSet<Event>();
    }
    
    public DataBase(TreeSet<Person> user,TreeSet<Event> eventList){        
       // for(Sport s:sports)
       //     this.sportsType.add(s.clone());
        for(Person p:user)
            this.userList.add(p.clone());
        for(Event e :eventList)
            this.eventList.add(e.clone());         
    }
    
    
    public DataBase(DataBase db){
        //this.sportsType=(TreeSet<Sport>)db.getSportsType();
        this.userList=(TreeSet<Person>)db.getUserList();
        this.eventList=(TreeSet<Event>)db.getEventList();
    }
    
    
    /*
    public Set<Sport> getSportsType(){
        TreeSet<Sport> aux=new TreeSet<Sport>();
        for(Sport s:this.sportsType)
            aux.add(s.clone());
        return aux;
    }
    */
    
    public Set<Person> getUserList(){
        TreeSet<Person> aux = new TreeSet<Person>(new ComparePerson());
        for(Person p : this.userList)
            aux.add(p.clone());
        return aux;
    }
    
    public Set<Event> getEventList(){
        TreeSet<Event> aux = new TreeSet<Event>();
        for(Event e: this.eventList)
            aux.add(e.clone());
    }
    
    public User getUser(String email){           
        boolean found=false;
        User u=new User();
        Iterator<Person> it=this.userList.iterator();                                         
       while(it.hasNext() && !found)
       {    Person p = it.next(); 
           if((p.getEmail().equals(email)) && (p instanceof User))
           {
               u=(User)p;
               found=true;
               
               
           }
       }       
       return u;
       
    }
    
    // to AdminRights
  /*  
    public Set<Sport> getSportsTypeAdmin(){
        return this.sportsType;
    }
    */
   public Set<Person> getUserListAdmin(){
       return this.userList;
   }
   
   public Set<Event> getEventListAdmin(){
       return this.eventList;
   }
    
   public void addPerson(TreeSet<Person> persons){
       for(Person p:persons)
       this.userList.add(p);
   }
   
   
   
   
   
   
   //toString,Equals,clone
   
    @Override
   public boolean equals(Object o){
       if(this==o)
           return true;
       if((o==null) || (this.getClass() != o.getClass()))
           return false;
       else
       {
           DataBase db=(DataBase)o;
           return(this.eventList.equals(db.getEventList())
                   //&& this.sportsType.equals(db.sportsType)
                   && this.userList.equals(db.getUserList()));
                  
       }
   }
   
    @Override
   public DataBase clone(){
       return new DataBase(this);
   }
   
    @Override
   public String toString(){
       StringBuilder sb=new StringBuilder();
       sb.append("Event List: ").append("\n");
       for(Event e: this.eventList)
           sb.append(e.toString());
       sb.append("Sports Type ").append("\n");
       //for(Sport s: this.getSportsType())
           //sb.append(s.toString());
       sb.append("User List ").append("\n");
       for(Person p : this.userList){
           if(p instanceof User){
           User u=(User)p;
           sb.append("User: ");
           sb.append(u.toString());
           }
           else if(p instanceof Admin){
               Admin a=(Admin)p;
               sb.append("Admin: ");
               sb.append(a.toString());
           }
       }
       return sb.toString();
           
       
   }
}

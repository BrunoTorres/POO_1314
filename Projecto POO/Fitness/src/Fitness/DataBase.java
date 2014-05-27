package Fitness;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DataBase
{
   // private TreeSet<Sport> sportsType;
    private TreeSet<Person>userList;  // admin && users
    private ArrayList<Event> events;
    
    public DataBase(){
       // this.sportsType= new TreeSet<Sport>();
        this.userList= new TreeSet<Person>(new ComparePersonByName());
        this.events=new ArrayList();
    }
    
    
    public DataBase(DataBase db){
        //this.sportsType=(TreeSet<Sport>)db.getSportsType();
        this.userList=(TreeSet<Person>)db.getUserList();
        this.events=new ArrayList();
    }
    
  
    public List<Event> getEvents(){
        ArrayList<Event> aux=new ArrayList();
        for(Event e:this.events){
            aux.add(e.clone());
        }
        return aux;        
    }
    public Set<Person> getUserList(){
        TreeSet<Person> aux = new TreeSet<Person>(new ComparePersonByName());
        for(Person p : this.userList)
            aux.add(p.clone());
        return aux;
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
  
   public Set<Person> getUserListAdmin(){
       return this.userList;
   }
   
   public List<Event> getEventListAdmin(){
       return this.events;
   }
   
   public void addPerson(Person person){
       this.userList.add(person);
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
           return(this.events.equals(db.events)
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
       for(Event e: this.events)
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

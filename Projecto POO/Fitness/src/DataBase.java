import java.util.Set;
import java.util.TreeSet;

public class DataBase
{
    private TreeSet<Sport> sportsType;
    private TreeSet<Person> userList;
    private TreeSet<Event> eventList;
    
    
    public DataBase(){
        this.sportsType= new TreeSet<Sport>();
        this.userList= new TreeSet<Person>();
        this.eventList= new TreeSet<Event>();
    }
    public DataBase(TreeSet<Sport> sports,TreeSet<Person> user,TreeSet<Event> eventList){        
        for(Sport s:sports)
            this.sportsType.add(s.clone());
        for(Person p:user)
            this.userList.add((User)p.clone());
        for(Event e :eventList)
            this.eventList.add(e.clone());         
               
            
    }
    
    
    public DataBase(DataBase db){
        this.sportsType=(TreeSet<Sport>)db.getSportsType();
        this.userList=(TreeSet<Person>)db.getUserList();
        this.eventList=(TreeSet<Event>)db.getEventList();
    }
    
    public Set<Sport> getSportsType(){
        TreeSet<Sport> aux=new TreeSet<Sport>();
        for(Sport s:this.sportsType)
            aux.add(s.clone());
        return aux;
    }
    
    public Set<Person> getUserList(){
        TreeSet<Person> aux = new TreeSet<Person>();
        for(Person p : this.userList)
            aux.add((User)p.clone());
        return aux;
    }
    
    public Set<Event> getEventList(){
        TreeSet<Event> aux = new TreeSet<Event>();
        for(Event e: this.eventList)
            aux.add(e.clone());
    }
    
    
    // to AdminRights
    
    public Set<Sport> getSportsTypeAdmin(){
        return this.sportsType;
    }
    
   public Set<Person> getUserListAdmin(){
       return this.getUserList();
   }
   
   public Set<Event> getEventListAdmin(){
       return this.eventList;
   }
    
}

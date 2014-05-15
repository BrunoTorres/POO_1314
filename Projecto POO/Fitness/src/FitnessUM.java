
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;


public class FitnessUM
{
    private DataBase db;
   
    
    //////////////////////////                Gerenciamento da aplicação /////////////////////////////////////////////////
    
    public boolean isAdmin(String email){                               // Procurar por email ou Admin admin?!
        TreeSet<Person> userList = (TreeSet)db.getEventList();
        boolean flag=false;
        boolean found=false;
    
       Iterator<Person> it=userList.iterator();
       Person p = it.next();                                            
       while(it.hasNext() && !found)
       {
           if((p.getEmail().equals(email)) && (p instanceof Admin))
           {
               found=true;
               flag=true;                   
           }
           p = it.next();
       }       
       
       return flag;
     
    }
    
    public boolean addUser(String email,String pass,String name,char gender,GregorianCalendar date,
            int height,float weight,String favoriteActivity)
    {
        boolean flag = false;
        User u=new User(email,pass,name,gender,date,height,weight,favoriteActivity);
        flag=db.getUserListAdmin().add(u);
                
        return flag;
        
    }
    
    
    public boolean addAdmin(String email,String pass,String name,char gender,GregorianCalendar date){
        boolean flag= false;
        Admin admin= new Admin(email,pass,name,gender,date);
        flag=db.getUserListAdmin().add(admin);
        
        return flag;
        
    }
    
    
    
    
    /////////////////////////////////////////////////Propriedade dos Utilizadores//////////////////////////////////////
    
    public boolean addFriendInUserList(User u,String email){
        boolean found=false;
        
        User u2=new User();
        TreeSet<Person> userList=(TreeSet)db.getUserList();
        
        Iterator<Person> it=userList.iterator();
        Person p = it.next();
        while(it.hasNext() && !found)
       {
           if((p.getEmail().equals(email)) && (p instanceof User)){
               u2=(User)p;
               found=true;
           }
           else
           p = it.next();
       }
        if(found){
            
        u.addFriend(u2);
        u2.addFriend(u);
        }
        
        return found;
    }
    public boolean ExistSport(name){
        boolean found=false;
        Iterator<Sport> it=db.getSportsType().iterator();
        while(it.hasNext() && !found)
            if(it.next().getName().equals(name))
                found=true;
        return found;       
            
        
    }
    public boolean addActivityList(String name,User u){
        boolean flag=false;
        if (ExistSport(name)){
            flag=true;
            u.addActivityList(name);                   
    }
        return flag;
    }
    
   
    //////////////////////////////////// Propriedade dos Administradores//////////////////////////////////////////
    
    public boolean removeUser(String email){                               
        TreeSet<Person> userList = (TreeSet)db.getUserListAdmin();
        boolean Flag = false;
        for(Person u:userList){
            if(email.equals(u.getEmail()))
          Flag= userList.remove(u);                
        }
        return Flag;
    }
    
    
    public boolean removeActivity(Activity activity){                       
        boolean flag=false;
        TreeSet<Person> userList=(TreeSet<Person>)db.getUserListAdmin();
        
        for(Person p:userList){
            if(p instanceof User){
            User u= (User)p;
            TreeSet<ActivityList> userActivities= (TreeSet)u.getUserActivitiesAdmin();         
            TreeSet<Activity> activityList=userActivities.getActivityListAdmin();
            
            flag=activityList.remove(activity);         
        }   
        }
        return flag;
        
    }
    public boolean removeActivityList(String name){
        
        for(Person p:db.getUserListAdmin())
            if(p instanceof User)
            {
                User u=(User) p;
                
                u.getUserActivitiesAdmin().remove()
            }
        
    }
    
    public boolean removeSport(String name){
       boolean found=false;
        
       Iterator<Sport>it=db.getSportsType().iterator();
       Sport aux=it.next();
       
       while(it.hasNext() && !found){
          if(aux.getName().equals(name))
              found=true;
          else
              aux=it.next();
       }
       db.getSportsTypeAdmin().remove(aux);
       if(found)
       found=removeActivityList(name);
    
       return found;
       
        
        
    }
    
  
    
    public boolean addSport(String type,String name,int caloriesPerHour,float avgIntensity,TreeSet<String> recordList){
        boolean flag=false;
        Sport aux = new Sport(type,name,caloriesPerHour,avgIntensity,recordList);
        flag=db.getSportsTypeAdmin().add(aux);
        return flag;
        
    }
    
    
}

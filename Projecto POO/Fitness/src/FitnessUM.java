
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

public class FitnessUM
{
    private DataBase db;
   
    public FitnessUM(){
        this.db=new DataBase();
    }
    
    public FitnessUM(DataBase db){
        this.db=db;
    }
   //IMPLEMENTAR METODOS DE PESQUISA
    //pesquisa1 -> -RECEBER UM NOME/EMAIL e retornar um User    Feito em DataBase
    //Pesquisa2 -> REceber Uma string e um user e retornar uma activityList
  
  
    
    
    
    
    //////////////////////////                Gerenciamento da aplicação /////////////////////////////////////////////////
  
    public User getUserByEmail(String email){
        User u;
        u=db.getUser(email);
        return u;
        
    }
      public boolean existPassAndUser(String email,String pass){                               //////////////////////////////////////////////            
        TreeSet<Person> userList = (TreeSet)db.getUserList();
        boolean found =false;
        
        Iterator<Person> it = userList.iterator();
        Person p=it.next();
        while(it.hasNext() && !found){
            if(email.equals(p.getEmail()) && pass.equals(p.getPassword()))
                found= true;
        }
        return found;
    }
   
    
    public boolean isAdmin(String email){                                                           // Procurar por email ou Admin admin?!
        TreeSet<Person> userList = (TreeSet)db.getUserList();
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
    
    public boolean addFriendInUserList(User u,String email){      //CLASSE MENSAGENS? UM 
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
    public boolean ExistSport(String name){
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
    /////// VE TODAS AS ACTIVIDADES DE TODOS OS AMIGOS ///////////////////////////
    public String FriendToString(TreeSet<User> users){
        StringBuilder sb=new StringBuilder();
        
        for(User friend:users){
        sb.append("Name Friend: ");sb.append(friend.getName()).append("\n");
        sb.append("Favorite Activity: ");sb.append(friend.getFavoriteActivity()).append("\n");
        sb.append("Activities").append("\n");
        sb.append(friend.getUserActivities().toString());                                           //toSring() METODO IMPLENTADO NA ACTIVITYLIST!!!!
        
        } 
            return sb.toString();
    }
                                                                                                         
    public String seeAllFriend(User u){
       TreeSet<Person> dbUsers=(TreeSet)db.getUserList();
       TreeSet<String> userActivities = (TreeSet)u.getFriendsList();
       TreeSet<User> users=new TreeSet<User>();
       
       for(String s:u.getFriendsList())
       {
           boolean found=false;
           Iterator<Person> it=dbUsers.iterator();
           Person p = it.next();
        
           while(it.hasNext() && !found)
               if(p.getName().equals(s))
                   users.add((User)p);
           else
                   p=it.next();
               
               
       }
       
       return (FriendToString(users));
        
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

    //Ver Actividade de um dado amigo //
    
    //Lista amigos,escolhe amigo        --
    public String listAllFriends(User u){
        TreeSet<String> s=(TreeSet)u.getFriendsList();
        
       return s.toString();
    }
    //Lista ActivityList do amigo 
    public String allActivitiesFriend(User u){
       return u.getUserActivities().toString();
    }
    
    //
    // Recebe nome da activityList e User Friend procura essa activitylist e lista 
    public String seeOneActivityList(User u,String activityList){
        return u.getOneActivityList(activityList).toString();                           //toString ACTIVITYLIST  
        
    }
    
   
    //////////////////////////////////// Propriedade dos Administradores//////////////////////////////////////////
    
    public boolean removeUser(String email){                               
        TreeSet<Person> userList = (TreeSet)db.getUserListAdmin();
        boolean Flag = false;
        for(Person u:userList){                                                             //melhorar RETIRAR FOR para Iterator!!!
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
    public void removeActivityList(String name){
        
        for(Person p:db.getUserListAdmin())
            if(p instanceof User)
            {
                boolean found=false;
                User u=(User) p;
                Iterator<ActivityList> it= u.getUserActivities().iterator();
                ActivityList aux=it.next();
                
                while(it.hasNext() && !found)                    
                    if(aux.getName().equals(name))                        
                        found = true;
                    else
                        aux=it.next();
                u.getUserActivitiesAdmin().remove(aux);                  
               
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
        removeActivityList(name);
    
       return found;
       
        
        
    }
    
  
    
    public boolean addSport(String type,String name,int caloriesPerHour,float avgIntensity,TreeSet<String> recordList){
        boolean flag=false;
        Sport aux = new Sport(type,name,caloriesPerHour,avgIntensity,recordList);
        flag=db.getSportsTypeAdmin().add(aux);
        return flag;
        
    }
    

}

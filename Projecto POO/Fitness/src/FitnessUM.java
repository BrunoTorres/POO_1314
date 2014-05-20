
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
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
    //Pesquisa2 -> REceber Uma string e um user e retornar uma activiy
  
  
    
    
    
    
    //////////////////////////                Gerenciamento da aplicação /////////////////////////////////////////////////
  
    public User getUserByEmail(String email){
        User u;
        u=this.db.getUser(email);
        return u;
        
    }
      public boolean existPassAndUser(String email,String pass){                               //////////////////////////////////////////////            
        TreeSet<Person> userList = (TreeSet)this.db.getUserList();
        
        boolean found =false;        
        Iterator<Person> it = userList.iterator();
       
        while(it.hasNext() && !found){
             Person p=it.next();
            if(email.equals(p.getEmail()) && pass.equals(p.getPassword()))
                found= true;
        }
        return found;
    }
   
    
    public boolean isAdmin(String email){                                                           // Procurar por email ou Admin admin?!
        TreeSet<Person> userList = (TreeSet)this.db.getUserList();
        boolean flag=false;
        boolean found=false;
    
       Iterator<Person> it=userList.iterator();
                                                  
       while(it.hasNext() && !found)
       {
           Person p = it.next(); 
           if((p.getEmail().equals(email)) && (p instanceof Admin))
           {
               found=true;
               flag=true;                   
           }
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
        flag=this.db.getUserListAdmin().add(admin);
        
        return flag;
        
    }
    
    
    
    
    /////////////////////////////////////////////////Propriedade dos Utilizadores//////////////////////////////////////
    
    public boolean addFriendInUserList(User u,String email){      //CLASSE MENSAGENS? UM 
        boolean found=false;
        
        User u2=new User();
        TreeSet<Person> userList=(TreeSet)this.db.getUserList();
        
        Iterator<Person> it=userList.iterator();
        
        while(it.hasNext() && !found)
       {    Person p = it.next();
           if((p.getEmail().equals(email)) && (p instanceof User)){
               u2=(User)p;
               found=true;
           }
 
       }
        if(found){
            
        u.addFriend(u2);
        u2.addFriend(u);
        }
        
        return found;
    }
    
 
  //////////////////////////////////////////////////CRIAR ACTIVITIES/////////////////////////////////////  
    public TwoDistances TypeToTwoDistance(String nameSport){
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);
       // System.out.println("Clima:");
        //String weather=input.nextLine();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Distancia percorrida1(horizontal):");
        int distance=input.nextInt();
        System.out.println("Distancia percorrida2(vertical):");
        int secondDistance=input.nextInt();
      
        int calories=0;                                                                                      //defenir calorias
        TwoDistances aux=new TwoDistances(nameSport,name,date,timeSpent,calories,"frio",distance,secondDistance);
        
        return aux;
    
    }
    
    public Distance TypeToDistance(String nameSport){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Clima:");
        String weather=input.nextLine();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Distancia percorrida1(horizontal):");
        int distance=input.nextInt();
             
        int calories=0;                                                                                      //defenir calorias
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);
        Distance aux=new Distance(nameSport,name,date,timeSpent,calories,weather,distance);
        
        return aux;
    }
    
    
    public Group TypeToGroup(String nameSport){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);
        System.out.println("Clima:");
        String weather=input.nextLine();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Distancia percorrida1(horizontal):");
        int distance=input.nextInt();
        System.out.println("Pontuação da equipa");
        int myScore=input.nextInt();
        System.out.println("Pontuação do adeversario");
        int opScore=input.nextInt();
        
             
        int calories=0;                                                                                      //defenir calorias
        Group aux=new Group(nameSport,name,date,timeSpent,calories,weather,distance,myScore,opScore);
        
        return aux;
    }
     public Group TypeToIndoorSolo(String nameSport){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);
        System.out.println("Clima:");
        String weather=input.nextLine();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Distancia percorrida1(horizontal):");
        int distance=input.nextInt();
       
             
        int calories=0;                                                                                      //defenir calorias
        IndoorSolo aux=new IndoorSolo(nameSport,name,date,timeSpent,calories,weather,distance);
        
        return aux;
    }
   public Group TypeToIndoorFighting(String nameSport){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);
        System.out.println("Clima:");
        String weather=input.nextLine();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Distancia percorrida1(horizontal):");
        int distance=input.nextInt();
       
             
        int calories=0;                                                                                      //defenir calorias
        IndoorFighting aux=new IndoorFighting(nameSport,name,date,timeSpent,calories,weather,distance);
        
        return aux;
    }
    public Extreme TypeToExtreme(String nameSport){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);
        System.out.println("Clima:");
        String weather=input.nextLine();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Distancia percorrida1(horizontal):");
        int distance=input.nextInt();
       
            
        int calories=0;                                                                                      //defenir calorias
        Extreme aux=new Extreme(nameSport,name,date,timeSpent,calories,weather);
        
        return aux;
    }
       public Other TypeToOther(String nameSport){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);
        System.out.println("Clima:");
        String weather=input.nextLine();                    //ERRO
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Distancia percorrida1(horizontal):");
        int distance=input.nextInt();
       
        int calories=0;                                                                                      //defenir calorias
        Other aux=new Other(nameSport,name,date,timeSpent,calories,weather);
        
        return aux;
    }
       
       ////////////////////////////////////////////////////////////////////////////////////////////
          public boolean ExistSport(String name){
        boolean found=false;
        Iterator<Sport> it=this.db.getSportsType().iterator();
        while(it.hasNext() && !found)
            if(it.next().getName().equals(name))
                found=true;
        return found;       
            
    }
    
    
    public String listSports(){
        StringBuilder sb= new StringBuilder();
        sb.append("Tipo de desporto a escolher").append("\n");
        for(Sport s:this.db.getSportsType())
            sb.append(s.getName()).append("\n");
        
        return sb.toString();
    }
    
    public String getSportTypeByName(String name){
        boolean found=false;
        
        Iterator<Sport> it=this.db.getSportsType().iterator();
        Sport sport=new Sport();
        while(it.hasNext() && !found){
            sport=it.next();
            if(sport.getName().equals(name))
                found=true;
        }
        return sport.getType();
    }
       
    
    public Activity createActivityByTypeSport(String type,String nameSport){
        Activity nova;       
        
        switch(type){            
            case "TwoDistances":
                nova=TypeToTwoDistance(nameSport);               
                break;
            case "Distance":
                nova= TypeToDistance(nameSport);
                break;
            case "Group":
                nova= TypeToGroup(nameSport);
                break;
            case "IndoorSolo":
                nova=TypeToIndoorSolo(nameSport);
                break;
            case "IndoorFighting":
                nova=TypeToIndoorFighting(nameSport);
                break;
            case "Extreme":
                nova=TypeToExtreme(nameSport);
                break;
            default:
                nova=TypeToOther(nameSport);
                break;
        }       
        return nova;       
                   
    }
    
 
    
    
    public boolean addActivity(Activity act,User u){
        boolean flag=false;
        if (ExistSport(act.getSportName())){                                                    
    }
        return flag;
    }
           
    public Set<Activity>getLast10Activities(User u){
        TreeSet<Activity> aux= new TreeSet();
        Iterator<Activity>it = u.getUserActivities().iterator();
        for(int i=0;i<10&&it.hasNext();i++)
            aux.add(it.next());
        return aux;       
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
       TreeSet<Person> dbUsers=(TreeSet)this.db.getUserList();
       TreeSet<String> userActivities = (TreeSet)u.getFriendsList();
       TreeSet<User> users=new TreeSet<User>();
       
       for(String s:u.getFriendsList())
       {
           boolean found=false;
           Iterator<Person> it=dbUsers.iterator();        
           while(it.hasNext() && !found){
               Person p = it.next();
               if(p.getName().equals(s))
                   users.add((User)p);
           } 
               
       }
       
       return (FriendToString(users));
        
    }
    
    
 
 

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
    public String seeOneActivityList(User u,String activity){
        return u.getOneActivity(activity).toString();                                          //toString ACTIVITYLIST  
        
    }
    
   
    
    
    //////////////////////////////////// Propriedade dos Administradores//////////////////////////////////////////
    
    public boolean removeUser(String email){                               
        TreeSet<Person> userList = (TreeSet)this.db.getUserListAdmin();
        boolean Flag = false;
        for(Person u:userList){                                                             //melhorar RETIRAR FOR para Iterator!!!
            if(email.equals(u.getEmail()))
          Flag= userList.remove(u);                
        }
        return Flag;
    }
    
    
    
    
    public boolean removeActivity(Activity activity){                       
        boolean flag=false;
        TreeSet<Person> userList=(TreeSet<Person>)this.db.getUserListAdmin();
        
        for(Person p:userList){
            if(p instanceof User){
            User u= (User)p;
           flag= u.getUserActivitiesAdmin().remove(activity);         
              
        }   
        }
        return flag;
        
    }
    public void removeActivityFromUser(String name){
        
        for(Person p:this.db.getUserListAdmin())
            if(p instanceof User)
            {
                boolean found=false;
                User u=(User) p;
                Iterator<Activity> it= u.getUserActivities().iterator();
                
                
                while(it.hasNext() && !found){
                    Activity aux=it.next();                       
                    if(aux.getName().equals(name))                        
                        found = true;
                }
                
                u.getUserActivitiesAdmin().remove(aux);                  
               
            }
        
    }
    
    public boolean removeSport(String name){
       boolean found=false;
        
       Iterator<Sport>it=this.db.getSportsType().iterator();
       
       
       while(it.hasNext() && !found){
           Sport aux=it.next();
          if(aux.getName().equals(name))
              found=true;
         
       }
       this.db.getSportsTypeAdmin().remove(aux);
       if(found)
        removeActivityFromUser(name);                           // VER AQUI NOME DO SPORT E NOME DA ACTIVITY!!!!!!!
    
       return found;
       
        
        
    }
    
  
    
    public boolean addSport(String type,String name,int caloriesPerHour,float avgIntensity,TreeSet<String> recordList){
        boolean flag=false;
        Sport aux = new Sport(type,name,caloriesPerHour,avgIntensity,recordList);
        flag=this.db.getSportsTypeAdmin().add(aux);
        return flag;
        
    }
    

}

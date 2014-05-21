package Fitness;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
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
    
    public void addPerson(TreeSet<Person> persons){
        db.addPerson(persons);
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
    
    //Aceder as estatisticas(mensais anuais) STATISTICS by distancia tempo e\calorias
    
    public String searchStatisticsMONTH(User u,String tipo,int mes,int ano){
       TreeMap<GregorianCalendar,Statistics>aux =(TreeMap)u.getStats();
       
       GregorianCalendar data= new GregorianCalendar(ano,mes,0);
       Statistics stats=aux.get(data);
       String s;
       
       switch(tipo){
            case "distância":
                s=stats.toStringDistance();
                break;
            case "tempo":
                s=stats.toStringTimeSpend();
                break;
            default:
                s=stats.toStringCalories();
                break;         
       }
       return s;
        
    }
    
    public String searchStatisticsYear(User u,String tipo,int ano){
        TreeMap<GregorianCalendar,Statistics>aux =(TreeMap)u.getStats();
        Statistics nova=new Statistics();
       for(int i=1;i<=12;i++)
       {
           GregorianCalendar date=new GregorianCalendar(ano,i,0);
           if(aux.containsKey(date))
               nova.incrementsTimeDistanceCalories(aux.get(date).getTimeSpend(), aux.get(date).getDistance(), aux.get(date).getCalories());
               
       }
       return nova.toString();                                                                                                //T
        
    }

   
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public boolean addFriendInUserList(User u,String email){                                                         //CLASSE MENSAGENS? UM 
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
            
        u.addFriend(u2);                                 //VER ISTOOOOOOOOOOOOOOOOOOOOOOOOOO/////////////////////
        u2.addFriend(u);
        }
        
        return found;
    }
    
 
  //////////////////////////////////////////////////CRIAR ACTIVITIES////////////////////////////////////////////////////// 
     public Snowbording TypeToSnowbording(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        System.out.println("Distancia horizontal:");
        double distance=input.nextInt();
        System.out.println("Distancia vertical:");
        double verticaldistance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               //defenir calorias
        Snowbording aux=new Snowbording(name,date,timeSpent,distance,verticaldistance,weather);
        
        return aux;
    }  
    public Orienteering TypeToOrienteering(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        System.out.println("Distancia:");
        double distance=input.nextInt();
        
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                      
        Orienteering aux=new Orienteering(name,date,timeSpent,distance,weather);
        
        return aux;
    }  
    public MountainBiking TypeToMountainBiking(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        System.out.println("Distancia horizontal:");
        double distance=input.nextInt();
        System.out.println("Distancia vertical:");
        double verticaldistance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                      
        MountainBiking aux=new MountainBiking(name,date,timeSpent,distance,verticaldistance,weather);
        
        return aux;
    }  
    
    public Cycling TypeToCycling(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                             
        Cycling aux=new Cycling(name,date,timeSpent,distance,weather);
        
        return aux;
    } 
    
    public Skiing TypeToSkiing(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        System.out.println("Distancia horizontal:");
        double distance=input.nextInt();
        System.out.println("Distancia: vertical");
        double verticaldistance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Skiing aux=new Skiing(name,date,timeSpent,distance,verticaldistance,weather);
        
        return aux;
    } 
    
    
    public Tennis TypeToTennis(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Tennis aux=new Tennis(name,date,timeSpent,myScore,opScore,weather);
        
        return aux;
    }
    
    public Walking TypeToWalking(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Walking aux=new Walking(name,date,timeSpent,distance,weather);
        
        return aux;
    }
    
    public Sailing TypeToSailing(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
         System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Sailing aux=new Sailing(name,date,timeSpent,distance,weather);
        
        return aux;
    }
    
    public Skating TypeToSkating(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
         System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Skating aux=new Skating(name,date,timeSpent,distance,weather);
        
        return aux;
    }
    public Running TypeToRunning(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
          System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Running aux=new Running(name,date,timeSpent,distance,weather);
        
        return aux;
    }
    
    public VolleyBallBeach TypeToVolleyBallBeach(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        VolleyBallBeach aux=new VolleyBallBeach(name,date,timeSpent,myScore,opScore,weather);
        
        return aux;
    }
  
    public Polo TypeToPolo(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Polo aux=new Polo(name,date,timeSpent,myScore,opScore,weather);
        
        return aux;
    }
    
    public Football TypeToFootball(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.nextLine();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Football aux=new Football(name,date,timeSpent,myScore,opScore,weather);
        
        return aux;
    }
    
    public VolleyBallIndoor TypeToVolleyBallIndoor(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        VolleyBallIndoor aux=new VolleyBallIndoor(name,date,timeSpent,myScore,opScore);
        
        return aux;
    }
    public Badminton TypeToBadminton(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Badminton aux=new Badminton(name,date,timeSpent,myScore,opScore);
        
        return aux;
    }
     public Boxing TypeToBoxing(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Boxing aux=new Boxing(name,date,timeSpent,myScore,opScore);
        
        return aux;
    }
    
    public TableTennis TypeToTableTennis(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        TableTennis aux=new TableTennis(name,date,timeSpent,myScore,opScore);
        
        return aux;
    }
    
    public Basketball TypeToBasketball(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Basketball aux=new Basketball(name,date,timeSpent,myScore,opScore);
        
        return aux;
    }
    public Handball TypeToHandball(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Score proprio");
        int myScore=input.nextInt();       
        System.out.println("Score do adeversario:");
        int opScore=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Handball aux=new Handball(name,date,timeSpent,myScore,opScore);
        
        return aux;
    }
    public Swimming TypeToSwimming(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Distancia:");
        double distance=input.nextInt();
        
       
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Swimming aux=new Swimming(name,date,timeSpent,distance);
        
        return aux;
    }
    public Cycling TypeToIndoorCycling(){
        
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
        System.out.println("Distancia:");
        double distance=input.nextInt();
      
       
        Cycling aux=new Cycling(name,date,timeSpent,distance,weather);
        
        return aux;
         
    }
    public Aerobics TypeToAerobics(){
        
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        
       
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Aerobics aux=new Aerobics(name,date,timeSpent);
        
        return aux;
    }
    public Yoga TypeToYoga(){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.nextLine();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        
       
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Yoga aux=new Yoga(name,date,timeSpent);
        
        return aux;
    }
       
       ////////////////////////////////////////////////////////////////////////////////////////////
       
       
    
    public Activity createActivity(String type){
        Activity nova;       
        
        switch(type){            
            case "Yoga":
                nova=TypeToYoga();               
                break;
            case "Aerobics":
                nova= TypeToAerobics();
                break;
            case "Swimming":
                nova= TypeToSwimming();
                break;
            case "IndoorCycling":
                nova=TypeToIndoorCycling();
                break;
            case "Handball":
                nova=TypeToHandball();
                break;
            case "Basketball":
                nova=TypeToBasketball();
                break;
            case "TableTennis":
                nova=TypeToTableTennis();
                break;
            case "Boxing":
                nova=TypeToBoxing();
                break;
            case "Badminton":
                nova=TypeToBadminton();
                break;
            case "VolleyBallIndoor":
                nova=TypeToVolleyBallIndoor();
                break;
             case "Football":
                nova=TypeToFootball();
                break;
            case "Polo":
                nova=TypeToPolo();
                break;
            case "VolleyBallBeach":
                nova=TypeToVolleyBallBeach();
                break;   
            case "Running":
                nova=TypeToRunning();               
                break;
            case "Skating":
                nova= TypeToSkating();
                break;
            case "Saling":
                nova= TypeToSailing();
                break;
            case "Walking":
                nova=TypeToWalking();
                break;
            case "Tennis":
                nova=TypeToTennis();
                break;
            case "Skiing":
                nova=TypeToSkiing();
                break;
            case "Cycling":
                nova=TypeToCycling();
                break;            
            case "MountainBiking":
                nova=TypeToMountainBiking();
                break;
            case "Orienteering":
                nova=TypeToOrienteering();
                break;
            default://Snowbording
                nova=TypeToSnowbording();
                break;
                
        }       
        return nova;       
                   
    }
    
 
    
    /*
    public boolean addActivity(Activity act,User u){
        boolean flag=false;
        if (ExistSport(act.getSportName())){                                                    
    }
        return flag;
    }
    */
           
    public Set<Activity>getLast10Activities(User u){
        TreeSet<Activity> aux= new TreeSet();
        Iterator<Activity>it = u.getActivities().iterator();
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
        sb.append(friend.getActivities().toString());                                           //toSring() METODO IMPLENTADO NA ACTIVITYLIST!!!!
        
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
    //Lista Activity do amigo 
    public String allActivitiesFriend(User u){
        StringBuilder sb=new StringBuilder();
        for(Activity act:u.getActivities())
            sb.append(act.toString());
       
       return sb.toString();
               
    }
    
    //
    // Recebe nome da activityList e User Friend procura essa activity e lista 
    public String seeOneActivityList(User u,String activity){
        return u.getOneActivity(activity).toString();                                          //toString ACTIVITY  
        
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
    
    public void removeActivityFromUser(String name){    //remove uma actividade de todos os users name of activity
        
        for(Person p:this.db.getUserListAdmin())
            if(p instanceof User)
            {
                boolean found=false;
                User u=(User) p;
                Iterator<Activity> it= u.getActivities().iterator();
                
                
                while(it.hasNext() && !found){
                    Activity aux=it.next();                       
                    if(aux.getName().equals(name)){
                           found = true;
                            u.getUserActivitiesAdmin().remove(aux); 
                        
                    }                        
                     
                }
               
            }
        
    }
    
    

}

package Fitness;


import java.io.Console;
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
  
  ////////////////////////////////////////////////
    
    public  int menuUser(){
         Scanner input = new Scanner(System.in);
         int i;
         System.out.println("1-Visualizar a informaçao da últimas 10 actividades");
         System.out.println("2-Registar uma actividade");
         System.out.println("3-Consultar ou remover actividades");
         System.out.println("4-Aceder às estatíticas(mensais ou anuais)");
         i=input.nextInt();
         
        return i;
    }
     public  int registarActividade(){
         Scanner input = new Scanner(System.in);
         System.out.println("Escolha uma actividade:");
         System.out.println("1 Yoga");
         System.out.println("2 Aerobics");
         System.out.println("3 Swimming");
         System.out.println("4 IndoorCycling");
         System.out.println("5 Handball");
         System.out.println("6 Basketball");
         System.out.println("7 TableTennis");
         System.out.println("8 Boxing");
         System.out.println("9 Badminton");
         System.out.println("10 VolleyBallIndoor");
         System.out.println("11 Football");
         System.out.println("12 VolleyBallBeach");
         System.out.println("13 Running");
         System.out.println("14 Skating");
         System.out.println("15 Saling");
         System.out.println("16 Walking");
         System.out.println("17 Tennis");
         System.out.println("18 Skiing");
         System.out.println("19 Cycling");
         System.out.println("20 MountainBiking");
         System.out.println("21 Orienteering");
         System.out.println("22 Snowbording");
         System.out.println("23 Polo");
       
         int i=input.nextInt();       
         
         return i;         
     }
     
    
       public  Activity criaActividade(int i){
           Activity act;
         switch(i){
             case 1:
                 act=createActivity("Yoga");
                 break;
             case 2:
                 act=createActivity("Aerobics");
                 break;
             case 3:
                 act=createActivity("Swimming");
                 break;
             case 4:
                 act=createActivity("IndoorCycling");
                 break;
             case 5:
                 act=createActivity("Handball");
                 break;
             case 6:
                 act=createActivity("Basketball");
                 break;
             case 7:
                 act=createActivity("TableTennis");
                 break;
             case 8:
                 act=createActivity("Boxing");
                 break;
             case 9:
                 act=createActivity("Badminton");
                 break;
             case 10:
                 act=createActivity("VolleyBallIndoor");
                 break;
             case 11:
                 act=createActivity("Football");
                 break;
             case 12:
                 act=createActivity("VolleyBallBeach");
                 break;
             case 13:
                 act=createActivity("Running");
                 break;
             case 14:
                 act=createActivity("Skating");
                 break;
             case 15:
                 act=createActivity("Saling");
                 break;
             case 16:
                 act=createActivity("Walking");
                 break;
             case 17:
                 act=createActivity("Tennis");
                 break;
             case 18:
                 act=createActivity("Skiing");
                 break;
             case 19:
                 act=createActivity("Cycling");
                 break;
             case 20:
                 act=createActivity("MountainBiking");
                 break;
             case 21:
                 act=createActivity("Orienteering");
                 break;
             case 22:
                 act=createActivity("Snowbording");
                 break;
             default:
                 act=createActivity("Polo");
                 break;
         }
         return act;  
         
     }
    
  
    
    
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
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia horizontal:");
        double distance=input.nextInt();
        System.out.println("Distancia vertical:");
        double verticaldistance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);
        
        
        Snowbording aux=new Snowbording(name,date,timeSpent,distance,verticaldistance,weather);
        
        return aux;
    }  
    public Orienteering TypeToOrienteering(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance=input.nextInt();
        
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                      
        Orienteering aux=new Orienteering(name,date,timeSpent,distance,weather);
        
        return aux;
    }  
    public MountainBiking TypeToMountainBiking(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
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
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                             
        Cycling aux=new Cycling(name,date,timeSpent,distance,weather);
        
        return aux;
    } 
    
    
    public Skiing TypeToSkiing(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
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
        String name = input.next();
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
        String weather = input.next();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Tennis aux=new Tennis(name,date,timeSpent,myScore,opScore,weather);
        
        return aux;
    }
    
    public Walking TypeToWalking(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
        System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Walking aux=new Walking(name,date,timeSpent,distance,weather);
        
        return aux;
    }
    
    public Sailing TypeToSailing(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
         System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               

        Sailing aux=new Sailing(name,date,timeSpent,distance,weather);
        
        return aux;
    }
    
    public Skating TypeToSkating(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
         System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Skating aux=new Skating(name,date,timeSpent,distance,weather);
        
        return aux;
    }
    public Running TypeToRunning(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
        System.out.println("Dia:");
        int dia=input.nextInt();
        System.out.println("Mes:");
        int mes=input.nextInt();
        System.out.println("Ano:");
        int ano=input.nextInt();
        System.out.println("Tempo despendido:");
        int timeSpent=input.nextInt();
        System.out.println("Tempo exterior:");
        String weather = input.next();
          System.out.println("Distancia:");
        double distance=input.nextInt();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Running aux=new Running(name,date,timeSpent,distance,weather);
        
        return aux;
    }
    
    public VolleyBallBeach TypeToVolleyBallBeach(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
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
        String weather = input.next();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        VolleyBallBeach aux=new VolleyBallBeach(name,date,timeSpent,myScore,opScore,weather);
        
        return aux;
    }
  
    public Polo TypeToPolo(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
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
        String weather = input.next();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                               
        Polo aux=new Polo(name,date,timeSpent,myScore,opScore,weather);
        
        return aux;
    }
    
    public Football TypeToFootball(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
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
        String weather = input.next();
        GregorianCalendar date=new GregorianCalendar(ano,mes,dia);                                                                              
        Football aux=new Football(name,date,timeSpent,myScore,opScore,weather);
        
        return aux;
    }
    
    public VolleyBallIndoor TypeToVolleyBallIndoor(){
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
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
        String name = input.next();
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
        String name = input.next();
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
        String name = input.next();
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
        String name = input.next();
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
        String name = input.next();
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
        String name = input.next();
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
    public IndoorCycling TypeToIndoorCycling(){
        Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
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
        IndoorCycling aux=new IndoorCycling(name,date,timeSpent,distance);
        
        return aux;
         
    }
    public Aerobics TypeToAerobics(){
        
       Scanner input = new Scanner(System.in);
        System.out.println("Nome da actividade:");
        String name = input.next();
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
        String name = input.next();
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

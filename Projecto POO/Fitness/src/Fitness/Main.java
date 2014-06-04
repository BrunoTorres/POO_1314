package Fitness;


import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class Main {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        
        User u1,u2,u3;
        Admin a1;
        //DataBase db=new DataBase();
        FitnessUM um=new FitnessUM();
        TreeSet<Person> person= new TreeSet(new ComparePersonByName());
       
      
      
        /*
        if(um.isAdmin("cois1@gmail.com"))
          System.out.println("E SIM"); 
        else
            System.out.println("NAO É");
        
        */
        /*
        System.out.println("User name(email)\n");
        String email=input.next();
       
        
        System.out.println("Insira pass\n");
        String pass=input.next();
        
       if(um.existPassAndUser(email,pass))
       System.out.println("ok");
       else
           System.out.println("User correcto");
               
       */
         
         

        /*
        System.out.println("Pesquisar user");
       System.out.println(um.getUserByEmail("cois@gmail.com").toString());
         */
        //um.addUser("novo@gmail.com","1111","Novo",'M',date,12,14,"fugir");
       //System.out.println(um.getUserByEmail("user1@gmail.com").toString());
        //System.out.println(db.toString());
       
       
       //ADICIONAR ACTIVITIES A UM USER
      // User u=um.getUserByEmail("user1@gmail.com");
  
       GregorianCalendar date1=new GregorianCalendar(2000,11,2);
       GregorianCalendar date2= new GregorianCalendar(2001,9,3);
       GregorianCalendar date3= new GregorianCalendar(2002,10,4);
       
       /*
       
       da
        Activity act = new MountainBiking("bike", date1, 155, 20, 5, "chuva");
        */
	   //Activity actcy = new Cycling("cy", date2, 155, 20, "chuva");
       /* Activity act2 = new Running("run", date3, 155, 20, "chuva");
       */
        
       //Activity act3=um.createActivity("Swimming");   
        Activity actcy = new Cycling("cy", date2, 120, 20, "chuva");
        Activity actc = new Cycling("cyy", date2, 60,100, "chuva");
        
        
        Activity actbad1 = new Badminton("cy", date2,155, 10, 0);
        Activity actbad2 = new Badminton("cyy", date2,155, 50,20);
       //u.addActivity(act, "Running");
       //u.addActivity(act1, "Running");
       //u.addActivity(act2, "Running");
        //u.addActivity(actcy, "Cycling");
      //u.addActivity(actc, "Cycling");
       GregorianCalendar dateu3,dateu1,dateu2,date33;
        dateu1 =new GregorianCalendar(1988,2,12);
        dateu2 =new GregorianCalendar(1900,2,12);
        dateu3 =new GregorianCalendar(1990,2,12);
        date33 =new GregorianCalendar(1100,2,12);
      u1=new User("user1@gmail.com","2211","jose",'M',dateu1,12,14,"correr");
      u2=new User("user3@gmail.com","1122","Manela",'F',dateu2,11,15,"FAzer nada");  
      u3= new User("user4@gmail.com","3322","Raul",'M',dateu3,10,13,"Fazer NADa");
      
       um.addUserByUser(u1);                  //VER GregorianCALENDAR!!!!
       um.addUserByUser(u2);
       um.addUserByUser(u3);
       //um.addAdmin("user4222@gmail.com","3322","Joselinaa",'M',date);
         Activity run1 = new Running("run", date3, 60, 20, "chuva");
         Activity run2 = new Running("run", date3, 70, 30, "chuva");
         Activity run3 = new Running("run", date3, 100, 40, "chuva");
        Activity act11 = new MountainBiking("MountainBiking", date3,20, 2, 0.1, "chuva");
        Activity act12 = new MountainBiking("MountainBiking",date3, 100, 50, 0.2,"chuva");
        Activity act21 = new MountainBiking("MountainBiking", date3, 500, 60,1, "chuva");
       u1.addActivity(actbad1, "Badminton");
       u1.addActivity(actbad2, "Badminton");
       
       
       
       u1.addActivity(act11, "MountainBiking");
       u1.addActivity(act12, "MountainBiking");
       u1.addActivity(act21, "MountainBiking");   
       u1.addActivity(run1, "Running");
       u1.addActivity(run2, "Running");
       u1.addActivity(run3, "Running");
       
        Activity act = new MountainBiking("MountainBiking", date3,300, 40, 0.1, "chuva");
        Activity act1 = new MountainBiking("MountainBiking",date3, 350,50, 0.2,"chuva");
        Activity act2 = new MountainBiking("MountainBiking", date3, 10,2,0.5, "chuva");
        Activity run11 = new Running("run1", date3, 20, 4, "chuva");
        Activity run21 = new Running("run2", date3, 60, 15, "chuva");
        Activity run31 = new Running("run3", date3, 15, 2, "chuva");
        
       u2.addActivity(act, "MountainBiking");
       u2.addActivity(act1, "MountainBiking");
       u2.addActivity(act2, "MountainBiking"); 
       u2.addActivity(run11, "Running");
       u2.addActivity(run21, "Running");
       u2.addActivity(run31, "Running");
       //String name, GregorianCalendar date, double timeSpent,double distance, double verticaldistance,String weather)
        Activity actbtt1 = new MountainBiking("MountainBiking", date3,120, 40, 0.1, "chuva");
        Activity act1bbt2 = new MountainBiking("MountainBiking",date3, 150, 50, 0.2,"chuva");
        Activity act2btt3 = new MountainBiking("MountainBiking", date3, 250, 60,1, "chuva");
        Activity run12 = new Running("run", date3, 155, 60, "chuva");
        Activity run22 = new Running("run", date33, 200, 70, "chuva");
        Activity run32 = new Running("run", date3, 140, 90, "chuva");
      // TreeSet activi=(TreeSet)um.getLast10Activities(u);
      //System.out.println(activi.toString()); 
       u3.addActivity(actbtt1, "MountainBiking");
       u3.addActivity(act1bbt2, "MountainBiking");
       u3.addActivity(act2btt3, "MountainBiking");
       u3.addActivity(run12, "Running");
       u3.addActivity(run22, "Running");
       u3.addActivity(run32, "Running");
       
       GregorianCalendar limite=new GregorianCalendar(2014,11,2);
       GregorianCalendar datacome= new GregorianCalendar(2014,11,4);
       
       um.addMarathonBTT("serra", "barcelos", 40, datacome,limite, 155);
       um.addMarathon("corridaNarua", "barcelos", 40, datacome,limite);
        Event e1= um.getEventByName("corridaNarua");
       Event e= um.getEventByName("serra");
       e1.addUser(u1);
       e1.addUser(u2);
       e1.addUser(u3);
       //um.simulaEvent(e1, "Chuva com ventos fortes", 29);
       
       //Event e= um.getEventByName("calhaus corrida");
       
       
       //System.out.println(act.getCalories());
       /////////////////////////////////////////////
       //AMIGOS//
      // User amigo=um.getUserByEmail("user3@gmail.com");
       //System.out.println(amigo.toString());
       //um.sendFriendRequest(u,amigo);
       //if(um.existsFriendToAdd(u)){
          // System.out.println("sim existe \n");
         //  um.acceptFriend(u,"user3@gmail.com");
       //}
      //for(String s :u1.getRecords().keySet())
      // System.out.println(u2.getRecords().get(s).toString());
       
       
       
     //  um.addMarathonBTT("serra", "barcelos", 40, datacome,limite, 155,90);
      // Event e= um.getEventByName("serra");
       //um.addMarathon("calhaus corrida", "polo norte", 40, datacome,limite, 155);
       //Event e= um.getEventByName("calhaus corrida");
       
    
//       um.userRegistEvent(u3, e);
       //for(Activity a:u3.getActivities())
          // System.out.println(a.toString());
       
      //double cal=um.formula(u3, "Sol", 30, "MarathonBTT", 90);
       
      // double cal=um.calculaTmMarathonBTT(u3, 90);
      //   System.out.println(cal);
      
      
        // System.out.println(hora);
     
         
        
   //um.userRegistEvent(u1, e);
     //System.out.println(u1.toString());
      //um.userRegistEvent(u3, e);
     // System.out.println(u3.toString());
      //um.userRegistEvent(u2, e);
     
      // e.addUser(u3);
      //    System.out.println(e.toString());
       
       
      // System.out.println(teste);


//System.out.println(u.getFriendsList().toString());
       
       //Para ver actividades do amigo= list amigos getUserbyEmail depois getLast10activity do user e print
       // System.out.println(um.getLast10Activities(u).toString());
      //System.out.println(u.getOneActivity("bike").toString());
      
      
      for(Statistics s :u2.getStats().values()){
         System.out.println(s.toStringDistance());
         System.out.println(s.toStringCalories());
         System.out.println(s.toStringTimeSpend()); 
         
      }
      
      u2.removeActivity("run2");
      
      
      System.out.println("novo\n");
            
      
       for(Statistics s :u2.getStats().values()){
         System.out.println(s.toStringDistance());
         System.out.println(s.toStringCalories());
         System.out.println(s.toStringTimeSpend()); 
         
      }
         System.out.println(".......................\n");
       System.out.println(run22.getCalories());
        System.out.println(".......................\n");
       // date33 =new GregorianCalendar(1900,2,12);
       um.searchStatisticsYear(u3, 3, 1100);
       //System.out.println(um.getUserByEmail("cois@gmail.com").toString());
      //System.out.println( act.toString());
      
      //  um.searchStatisticsMONTH(u, 1, 11, 2000);
        
       
       
    }
    
    
  
}

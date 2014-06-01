package Fitness;


import java.util.Calendar;
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
        
        GregorianCalendar date;
        date =new GregorianCalendar(1988,2,12);
        User u1,u2,u3;
        Admin a1;
        //DataBase db=new DataBase();
        FitnessUM um=new FitnessUM();
        TreeSet<Person> person= new TreeSet(new ComparePersonByName());
       
      u1=new User("user1@gmail.com","2211","jose",'M',date,12,14,"correr");
      u2=new User("user3@gmail.com","1122","Manel",'F',date,11,15,"FAzer nada");  
      u3= new User("user4@gmail.com","3322","Raul",'M',date,10,13,"Fazer NADa");
      
       um.addUserByUser(u1);                  //VER GregorianCALENDAR!!!!
       um.addUserByUser(u2);
       um.addUserByUser(u3);
       um.addAdmin("user4222@gmail.com","3322","Joselinaa",'M',date);

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
        um.addUser("novo@gmail.com","1111","Novo",'M',date,12,14,"fugir");
       //System.out.println(um.getUserByEmail("user1@gmail.com").toString());
        //System.out.println(db.toString());
       
       
       //ADICIONAR ACTIVITIES A UM USER
       User u=um.getUserByEmail("user1@gmail.com");
      // Activity act=um.createActivity("Cycling");
       //Activity act2=um.createActivity("Running");
       GregorianCalendar date1=new GregorianCalendar(2000,11,2);
       GregorianCalendar date2= new GregorianCalendar(2001,9,3);
       GregorianCalendar date3= new GregorianCalendar(2002,10,4);
       /*
        Activity act = new MountainBiking("bike", date1, 155, 20, 5, "chuva");
        */
	   //Activity actcy = new Cycling("cy", date2, 155, 20, "chuva");
       /* Activity act2 = new Running("run", date3, 155, 20, "chuva");
       */
        Activity act = new Running("run", date3, 100, 100, "chuva");
        Activity act1 = new Running("run", date3, 11, 50, "chuva");
        Activity act2 = new Running("run", date3, 155, 20, "chuva");
       //Activity act3=um.createActivity("Swimming");   
        Activity actcy = new Cycling("cy", date2, 120, 20, "chuva");
        Activity actc = new Cycling("cyy", date2, 60,100, "chuva"); 
       u.addActivity(act, "Running");
       u.addActivity(act1, "Running");
       u.addActivity(act2, "Running");
        u.addActivity(actcy, "Cycling");
      u.addActivity(actc, "Cycling");
       u2.addActivity(act, "Running");
       u2.addActivity(act1, "Running");
       u2.addActivity(act2, "Running");
      
       
       //String name, GregorianCalendar date, double timeSpent,double distance, double verticaldistance,String weather)
       
       Activity actbtt1 = new MountainBiking("MountainBiking", date3,120, 40, 0.1, "chuva");
        Activity act1bbt2 = new MountainBiking("MountainBiking",date3, 150, 50, 0.2,"chuva");
        Activity act2btt3 = new MountainBiking("MountainBiking", date3, 250, 60,1, "chuva");
      // TreeSet activi=(TreeSet)um.getLast10Activities(u);
      //System.out.println(activi.toString()); 
      u3.addActivity(actbtt1, "MountainBiking");
       u3.addActivity(act1bbt2, "MountainBiking");
       u3.addActivity(act2btt3, "MountainBiking");
       /////////////////////////////////////////////
       //AMIGOS//
      // User amigo=um.getUserByEmail("user3@gmail.com");
       //System.out.println(amigo.toString());
       //um.sendFriendRequest(u,amigo);
       //if(um.existsFriendToAdd(u)){
          // System.out.println("sim existe \n");
         //  um.acceptFriend(u,"user3@gmail.com");
       //}
      // for(String s :u.getRecords().keySet())
        //System.out.println(u.getRecords().get(s).toString());
       
       GregorianCalendar limite=new GregorianCalendar(2014,11,2);
       GregorianCalendar datacome= new GregorianCalendar(2014,11,4);
       
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
      
      
      double min=155.80;
      int hora=(int)min/60;
      int min2=(int)min%60;
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
      
      /*
      for(Statistics s :u.getStats().values()){
         System.out.println(s.toStringDistance());
         System.out.println(s.toStringCalories());
         System.out.println(s.toStringTimeSpend()); 
         
      }
              */
       //System.out.println(um.getUserByEmail("cois@gmail.com").toString());
      //System.out.println( act.toString());
      
      //  um.searchStatisticsMONTH(u, 1, 11, 2000);
        
       
       
    }
    
    
  
}

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
        
        GregorianCalendar date;
        date =new GregorianCalendar(2014,2,12);
        User u1,u2,u3;
        Admin a1;
        //DataBase db=new DataBase();
        FitnessUM um=new FitnessUM();
        TreeSet<Person> person= new TreeSet(new ComparePerson());
       
      
       um.addUser("user1@gmail.com","2211","jose",'M',date,12,14,"correr");                    //VER GregorianCALENDAR!!!!
       um.addUser("user3@gmail.com","1122","Manel",'F',date,11,15,"FAzer nada");
       um.addUser("user4@gmail.com","3322","Raul",'M',date,10,13,"Fazer NADa");
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
        
        um.addUser("novo@gmail.com","1111","Novo",'M',date,12,14,"fugir");
        System.out.println(db.toString());
        */
       
       //ADICIONAR ACTIVITIES A UM USER
       User u=um.getUserByEmail("user1@gmail.com");
      // Activity act=um.createActivity("Cycling");
       //Activity act2=um.createActivity("Running");
       GregorianCalendar date1=new GregorianCalendar(2000,11,2);
       GregorianCalendar date2= new GregorianCalendar(2001,9,3);
       GregorianCalendar date3= new GregorianCalendar(2002,10,20);
       GregorianCalendar date4= new GregorianCalendar(2002,11,4);
       GregorianCalendar date5= new GregorianCalendar(2013,10,4);
       GregorianCalendar date6= new GregorianCalendar(2002,10,30);
       GregorianCalendar date7= new GregorianCalendar(2002,10,4);

        Activity act1 = new MountainBiking("bike", date1, 155, 20, 5, "chuva");
        Activity act2 = new Cycling("cy", date2, 155, 20, "chuva");
        Activity act3 = new Orienteering("ah e tal", date3, 155, 20, "sol");
        Activity act4 = new Sailling("regata", date4, 155, 20, "tempestade do caralho");
        Activity act5 = new Running("run", date5, 30, 5, "sole");
        Activity act6 = new Running("corrida com os amigos", date6, 66, 15, "chuva");
       
       //Activity act3=um.createActivity("Swimming");       
       u.addActivity(act1, "MountainBiking");
       u.addActivity(act2, "Cycling");
       u.addActivity(act3, "Orienteering");
       u.addActivity(act4, "Sailling");
       u.addActivity(act5, "Running");
       u.addActivity(act6, "Running");

      // TreeSet activi=(TreeSet)um.getLast10Activities(u);
      //System.out.println(activi.toString()); 
      
       /////////////////////////////////////////////
       //AMIGOS//
       User amigo=um.getUserByEmail("user3@gmail.com");
       //System.out.println(amigo.toString());
       um.sendFriendRequest(u,amigo);
       if(um.existsFriendToAdd(u)){
          // System.out.println("sim existe \n");
           um.acceptFriend(u,"user3@gmail.com");
       }

       //System.out.println(u.getFriendsList().toString());
       
       //Para ver actividades do amigo= list amigos getUserbyEmail depois getLast10activity do user e print
       
      // System.out.println(um.getLast10Activities(u).toString());
      //System.out.println(u.getOneActivity("bike").toString());
      
      
      for(Statistics s :u.getStats().values()){
         System.out.println(s.toStringDistance());
         System.out.println(s.toStringCalories());
         System.out.println(s.toStringTimeSpend()); 
         
      }
       //System.out.println(um.getUserByEmail("cois@gmail.com").toString());
      //System.out.println( act.toString());
    }
    
}

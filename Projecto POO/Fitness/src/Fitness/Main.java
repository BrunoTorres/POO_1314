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
       User u=um.getUserByEmail("user1@gmail.com");
       Activity act=um.createActivity("Cycling");
       Activity act2=um.createActivity("Running");
       
       
       //Activity act3=um.createActivity("Swimming");       
       u.addActivity(act, "Cycling");
       u.addActivity(act2, "Running");
      // u.addActivity(act3, "Swimming");
       
       User amigo=um.getUserByEmail("user2@gmail.com");
       
       TreeSet activi=(TreeSet)um.getLast10Activities(u);///////////////MAL!!!!
       System.out.println(activi.toString()); 
       //u.addFrindToMessage(null);
      
       //System.out.println(um.getUserByEmail("cois@gmail.com").toString());
      System.out.println( act.toString());
    }
    
}

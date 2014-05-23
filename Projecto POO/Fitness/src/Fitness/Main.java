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
        date =new GregorianCalendar();
        User u1,u2,u3;
        Admin a1;
        //DataBase db=new DataBase();
        FitnessUM um=new FitnessUM();
        TreeSet<Person> person= new TreeSet(new ComparePerson());
       
      
        u1=new User("cois@gmail.com","2211","jose",'M',date,12,14,"correr");                    //VER GregorianCALENDAR!!!!
        u2=new User("cois1@gmail.com","1122","Manel",'F',date,11,15,"FAzer nada");
        u3=new User("cois2@gmail.com","3322","Raul",'M',date,10,13,"Fazer NADa");
        a1 =new Admin("cois222@gmail.com","3322","Joselinaa",'M',date);
        
         person.add(u1);
         person.add(u2);
         person.add(u3);
         person.add(a1);
         
         um.addPerson(person);
         
     
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
       User u=um.getUserByEmail("cois@gmail.com");
       Activity act=um.createActivity("Cycling");
       
      //um.getUserByEmail("cois@gmail.com").addActivity(act);

      
       //System.out.println(um.getUserByEmail("cois@gmail.com").toString());
      System.out.println( act.toString());
    }
    
}

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
         GregorianCalendar date=new GregorianCalendar();
        
        User u1,u2,u3;
        Admin a1;
        //DataBase db=new DataBase();
        FitnessUM um=new FitnessUM();
        TreeSet<Person> person= new TreeSet(new ComparePerson());
        private Activity act;
    
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
        FitnessUM um=new FitnessUM();
        TreeSet<Person> person= new TreeSet(new ComparePerson());
       
      
        u1=new User("cois@gmail.com","2211","jose",'M',date,12,14,"correr");               
        u2=new User("cois1@gmail.com","1122","Manel",'F',date,11,15,"FAzer nada");
        u3=new User("cois2@gmail.com","3322","Raul",'M',date,10,13,"Fazer NADa");
        a1 =new Admin("cois222@gmail.com","3322","Joselinaa",'M',date);
         person.add(u1);
         person.add(u2);
         person.add(u3);
         person.add(a1); 
         um.addPerson(person);
         
     /*
       User u=um.getUserByEmail("cois@gmail.com");
       Activity act=um.createActivity("Cycling");  
      um.getUserByEmail("cois@gmail.com").addActivity(act);
      //System.out.println(um.getUserByEmail("cois@gmail.com").toString());
      System.out.println( act.toString());
      */
      
         
         int actividade=1;
         int i=um.menuUser();
         if(i==2)
            actividade=um.registarActividade();
         
         Activity act=um.criaActividade(actividade);
         
         um.getUserByEmail("cois@gmail.com").addActivity(act);
         System.out.println(um.getUserByEmail("cois@gmail.com").toString());
      
    }
    
}

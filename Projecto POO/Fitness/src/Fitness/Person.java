package Fitness;


import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Person
{
    private String email;
    private String password;
    private String name;
    private char gender;
    private GregorianCalendar dateOfBirth;


    public Person(){
        this.email="";
        this.password="";
        this.name="";
        this.gender='N';
        this.dateOfBirth=new GregorianCalendar();
          
        
    }
    //Construtores
    public Person(String email,String pass,String name,char gender,GregorianCalendar date){
        this.email=email;
        this.password=pass;
        this.name=name;
        this.gender=gender;
        this.dateOfBirth=(GregorianCalendar)date.clone();
    }

    public Person(Person p){
        this.email=p.getEmail();
        this.password=p.getPassword();
        this.name=p.getName();
        this.gender=p.getGender();
        this.dateOfBirth=p.getDate();
    }

    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getName(){
        return this.name;
    }
    public char getGender(){
        return this.gender;
    }
    public GregorianCalendar getDate(){
        return (GregorianCalendar)this.dateOfBirth.clone();
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String pass){
        this.password=pass;
    }




//Equals,toString & Clone
    @Override
    public boolean equals(Object person){
    if(this==person)
        return true;
    if((person==null) ||(this.getClass()) != person.getClass())
        return false;
    else{
        Person p=(Person) person;
        return (this.email.equals(p.getEmail()) 
                && this.name.equals(p.getName()) 
                && this.password.equals(p.getPassword())
                && (this.gender==(p.getGender())) 
                && this.dateOfBirth.equals(p.getDate()) );               
    }
}
    

    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder();
    
    sb.append("Nome: ");sb.append(this.name).append("\n");
    sb.append("Email: ");sb.append(this.email).append("\n");
    sb.append("Password: ");sb.append(this.password).append("\n");
    sb.append("Gender: ");sb.append(this.gender).append("\n");
    sb.append("Date of Birth: ");sb.append(this.dateOfBirth.toString()).append("\n");
    
    return sb.toString(); 
}
    
    @Override
    public Person clone(){
        return new Person(this) {};  // {} ??
    }
    
        
//HASCODE AUTOMATICO 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.gender;
        hash = 59 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }
}
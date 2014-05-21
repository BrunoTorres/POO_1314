
import java.util.GregorianCalendar;


public class Admin extends Person
{
    
  public Admin(){
      super();
  }
  
  public Admin(String email,String pass,String name,char gender,GregorianCalendar date){
       super(email,pass,name,gender,date);
  }
  
  public Admin(Admin admin){
      super(admin.getEmail(), admin.getPassword(), admin.getName(), admin.getGender(), admin.getDate());
  }
  

    //Equals,toString e Clone
    
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if((o==null)|| (this.getClass() !=o.getClass()))
            return false;
        else{
            Admin admin = (Admin) o;
            return( super.equals(admin));                   
        }
        
    }
    
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
   
        sb.append(super.toString());
            
        return sb.toString();      
        
        
    }
    
    @Override
    public Admin clone(){
        return new Admin(this);
    }

  
    
}

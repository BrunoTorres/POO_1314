
// ESTA CLASSE FAZ SENTIDO?? 

import java.util.TreeSet;


public class AdminRightsDB extends DataBase
{
    
    public AdminRightsDB(){
        super();
    }
    public AdminRightsDB(TreeSet<Sport> sports,TreeSet<Person> user,TreeSet<Event> eventList){
        super(sports,user,eventList);
    }
    
    public AdminRightsDB(AdminRightsDB adminRights){
        super((TreeSet<Sport>)adminRights.getSportsType(),(TreeSet<Person>)adminRights.getUserList(),(TreeSet<Event>)adminRights.getEventList());
        
    }
    
    
    
}

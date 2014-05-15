
import java.util.TreeSet;


public class AdminRightsDB extends DataBase
{
    
    
    
    public boolean removeActivity(Activity activity){
        boolean Flag=true;
        TreeSet<Person> userList=(TreeSet<Person>)super.getUserListAdmin();
        
        for(Person p:userList){
            User u= (User)p;
            TreeSet<ActivityList> userActivities= (TreeSet)u.getUserActivitiesAdmin();         
            TreeSet<Activity> activityList=userActivities.getActivityListAdmin();
            
            Flag=activityList.remove(activity);           
                       
        }
        
            return Flag;
        
        
       // return super.activitiesList.remove(activity);

    }
}

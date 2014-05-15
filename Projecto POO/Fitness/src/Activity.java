
import java.util.GregorianCalendar;
import java.util.TreeSet;


public abstract class Activity
{
   private String name;                         // corrida ao leu
   private GregorianCalendar date;
   private GregorianCalendar timeSpent;
   private int calories;
   private String weather;
   private TreeSet<Statistics> activityRecords;
   
   
   
   public abstract float setCalories();
}

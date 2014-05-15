
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class ActivityList
{
   private String name;                             //Corrida/futebol(que esta em sport) || Corrida/andebol(que tem que existir em sport)
   private int totalCalories;
   private GregorianCalendar totalTime;
   private GregorianCalendar firstActivity;
   private GregorianCalendar lastActivity;
   private int numberOfDays;
   private TreeSet<Activity> activityList;
   private TreeSet<Statistics> personalBests;
   
   
}

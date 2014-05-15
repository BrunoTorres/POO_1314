
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

public class FitnessUM {

	private DataBase db;
	private Person person;

	public boolean isAdmin(String email) {                   // Procurar por email ou Admin admin?!
		TreeSet<Person> userList = (TreeSet) db.getEventList();
		boolean flag = false;
		boolean found = false;

		Iterator<Person> it = userList.iterator();
		Person p = it.next();                              //DUVIDAS SE FUNCIONA POIS TENHO QUE ACEDER DUAS VEZES AO it.next()!!!!!
		while (it.hasNext() && !found) {
			if ((p.getEmail().equals(email)) && (p instanceof Admin)) {
				found = true;
				flag = true;
			}
		}

		return flag;

	}

	public boolean addUser(String email, String pass, String name, char gender, GregorianCalendar date,
			int height, float weight, String favoriteActivity) {
		boolean flag = false;
		User u = new User(email, pass, name, gender, date, height, weight, favoriteActivity);
		flag = db.getUserListAdmin().add(u);

		return flag;

	}

	public boolean removeUser(String email) {
		TreeSet<Person> userList = (TreeSet) db.getUserListAdmin();
		boolean Flag = false;
		for (Person u : userList) {
			if (email.equals(u.getEmail())) {
				Flag = userList.remove(u);
			}
		}
		return Flag;
	}

	public boolean removeActivity(Activity activity) {
		boolean Flag = false;
		TreeSet<Person> userList = (TreeSet<Person>) db.getUserListAdmin();

		for (Person p : userList) {
			if (p instanceof User) {
				User u = (User) p;
				TreeSet<ActivityList> userActivities = (TreeSet) u.getUserActivitiesAdmin();
				TreeSet<Activity> activityList = userActivities.getActivityListAdmin();

				Flag = activityList.remove(activity);
			}
		}
		return Flag;

	}

}

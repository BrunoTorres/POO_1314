package Fitness;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class User extends Person implements Serializable{

	private int height; // centímetros
	private double weight; // kilogramas
	private String favoriteActivity;
	private TreeSet<Activity> userActivities;
	private TreeSet<String> friendsList;
	private TreeMap<GregorianCalendar, Statistics> stats;
	private TreeMap<String, ListRecords> records;
	private TreeSet<String> messageFriend;

	public User() {
		super();
		this.height = 0;
		this.weight = 0;
		this.favoriteActivity = "";
		this.userActivities = new TreeSet<>(new CompareActivity());
		this.friendsList = new TreeSet<>();
		this.stats = new TreeMap<>(new CompareStatsPerYearAndMonth());
		this.messageFriend = new TreeSet<>();
		this.records = new TreeMap<>();
	}

	public User(String email, String pass, String name, char gender, GregorianCalendar date, int height, double weight, String favoriteActivity, TreeSet<Activity> userActivities, TreeSet<String> friendsList) {
		super(email, pass, name, gender, date);
		this.height = height;
		this.weight = weight;
		this.favoriteActivity = favoriteActivity;
		for (Activity act : userActivities) {
			this.userActivities.add((Activity) act.clone());
		}
		this.friendsList = (TreeSet<String>) friendsList.clone();
		this.stats = new TreeMap<>(new CompareStatsPerYearAndMonth());
		this.messageFriend = new TreeSet<>();
		this.records = new TreeMap<>();
	}

	public User(String email, String pass, String name, char gender, GregorianCalendar date,
			int height, double weight, String favoriteActivity) {
		super(email, pass, name, gender, date);
		this.height = height;
		this.weight = weight;
		this.favoriteActivity = favoriteActivity;
		this.userActivities = new TreeSet<>(new CompareActivity());
		this.friendsList = new TreeSet<>();
		this.stats = new TreeMap<>(new CompareStatsPerYearAndMonth());
		this.messageFriend = new TreeSet<>();
		this.records = new TreeMap<>();
	}

	public User(User u) {
		super(u.getEmail(), u.getPassword(), u.getName(), u.getGender(), u.getDate());
		this.height = u.getHeight();
		this.weight = u.getWeight();
		this.favoriteActivity = u.getFavoriteActivity();
		this.userActivities = (TreeSet<Activity>) u.getActivities();
		this.friendsList = (TreeSet<String>) u.getFriendsList();
		this.stats = (TreeMap<GregorianCalendar, Statistics>) u.getStats();
		this.messageFriend = (TreeSet<String>) u.getMessage();
		this.records = (TreeMap<String, ListRecords>) u.getRecords();
	}

	public Map<String, ListRecords> getRecords() {
		TreeMap<String, ListRecords> aux = new TreeMap<>();

		for (String s : this.records.keySet()) {
			aux.put(s, this.records.get(s));
		}
		return aux;
	}

	public int getHeight() {
		return this.height;
	}

	public double getWeight() {
		return this.weight;
	}

	public String getFavoriteActivity() {
		return this.favoriteActivity;
	}

	public Set<Activity> getActivities() {
		TreeSet<Activity> res = new TreeSet<>(new CompareActivity());
		for (Activity act : this.userActivities) {
			res.add(act.clone());
		}
		return res;
	}

	public Set<String> getFriendsList() {
		return (TreeSet<String>) this.friendsList.clone();
	}

	public Map<GregorianCalendar, Statistics> getStats() {
		TreeMap<GregorianCalendar, Statistics> aux = new TreeMap<>(new CompareStatsPerYearAndMonth());

		for (GregorianCalendar key : this.stats.keySet()) //FUNCIONA??!!!
		{
			aux.put(key, this.stats.get(key));
		}

		return aux;

	}

	public Set<String> getMessage() {
		return this.messageFriend;
	}

	public void addFriendToMessage(String email) {
		this.messageFriend.add(email);
	}

	public void removeFriendFromMessage(String email) {
		this.messageFriend.remove(email);
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void setFavoriteActivity(String favorite) {
		this.favoriteActivity = favorite;
	}

	public Activity getOneActivity(String name) {

		Activity act;
		boolean found = false;
		Iterator<Activity> it = this.userActivities.iterator();
		act = it.next();
		while (it.hasNext() && !found) {
			if (act.getName().equals(name)) {
				found = true;
			} else {
				act = it.next();
			}
		}

		return act;      //PODE RETORNAR NULL||||
	}

//////////////////////////////TO STATS                              compor NAO esta POR MES!!!!!||||||||||||||||||||||||||||||||||||\\
	private void updateStat(Activity actt) {

		GregorianCalendar date = new GregorianCalendar(actt.getDate().get(Calendar.YEAR), actt.getDate().get(Calendar.MONTH), 0);

		if (actt instanceof Distance) {
			Distance act = (Distance) actt;

			((Statistics) this.stats.get(date)).incrementsTimeDistanceCalories(actt.getTimeSpent(), act.getDistance(), actt.getCalories());
		} else {

			((Statistics) this.stats.get(date)).incrementsTimeDistanceCalories(actt.getTimeSpent(), 0, actt.getCalories());

		}

	}

	private void createStat(Activity actt) {
		GregorianCalendar date = new GregorianCalendar(actt.getDate().get(Calendar.YEAR), actt.getDate().get(Calendar.MONTH), 0);

		if (actt instanceof Distance) {
			Distance act = (Distance) actt;
			Statistics stat = new Statistics(actt.getTimeSpent(), actt.getCalories(), act.getDistance());
			this.stats.put(date, stat);
		} else {
			Statistics stat = new Statistics(actt.getTimeSpent(), actt.getCalories());
			this.stats.put(date, stat);
		}

	}

	private void setStats(Activity act) {
		GregorianCalendar date = new GregorianCalendar(act.getDate().get(Calendar.YEAR), act.getDate().get(Calendar.MONTH), 0);
		if (this.stats.containsKey(date)) {
			updateStat(act);
		} else {
			createStat(act);
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean addActivity(Activity act, String tipoActividade) {
		if ((act instanceof Running) || (act instanceof Walking)
				|| (act instanceof Cycling) || (act instanceof MountainBiking) || (act instanceof Swimming)) {
			updateRecords(tipoActividade, act);
		}
		act.setCalories(this.weight);
		setStats(act);
		return this.userActivities.add(act);
	}

	public boolean addFriend(User u) {              //Adiciona amigos a lista
		boolean flag = false, found = false;
		flag = this.friendsList.add(u.getEmail());

		return flag;
	}

	public boolean removeActivity(String activityName) {
		boolean found = false;
		boolean flag = false;
		Iterator<Activity> it = this.userActivities.iterator();
		Activity act = it.next();
		while (it.hasNext() && !found) {
			if (act.getName().equals(activityName)) {
				flag = this.userActivities.remove(act);
				found = true;
			}
		}
		return flag;

	}

    //////////////////Records///////////////
	public boolean addRecord(String tipoActividade, Activity act) {
		RecordsActivity a;
		if (act instanceof RecordsActivity) {
			a = (RecordsActivity) act;
			this.records.put(tipoActividade, a.getListRecords());
		}
		return true;

	}

	public boolean updateRecords(String tipoActividade, Activity act) {

		if (!this.records.containsKey(tipoActividade)) {
			return addRecord(tipoActividade, act);
		} else {

			ListRecords recUser = this.records.get(tipoActividade);
			ListRecords recAct;
			boolean flag = false;
			RecordsActivity a;
			if (act instanceof RecordsActivity) {
				a = (RecordsActivity) act;
				recAct = a.getListRecords();
				recUser.updateList(recAct);
				flag = true;

			}

			return flag;
		}

	}

	//Metodos Para admin
	public Set<Activity> getUserActivitiesAdmin() {
		return this.userActivities;
	}

	public Set<String> getFriendsListAdmin() {

		return this.friendsList;
	}

    //Equals,toString e Clone
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if ((o == null) || (this.getClass() != o.getClass())) {
			return false;
		} else {
			User u = (User) o;
			return (super.equals(u)
					&& this.height == u.getHeight()
					&& this.weight == u.getWeight()
					&& this.favoriteActivity.equals(u.getFavoriteActivity())
					&& this.friendsList.equals(u.getFriendsList())
					&& this.userActivities.equals(u.getActivities()));
		}

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Height: ");
		sb.append(this.height).append("\n");
		sb.append("Weight: ");
		sb.append(this.weight).append("\n");
		sb.append("Favorite Activity: ");
		sb.append(this.favoriteActivity).append("\n");
		sb.append("Friends List: ").append("\n");
		for (String s : this.getFriendsList()) {
			sb.append(s).append("\n");
		}
		for (Activity act : this.userActivities) {
			sb.append(act.toString());
		}

		return sb.toString();

	}

	@Override
	public User clone() {
		return new User(this);
	}
}

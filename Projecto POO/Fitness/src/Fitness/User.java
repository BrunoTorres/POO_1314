package Fitness;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Bruno
 */
public class User extends Person implements Serializable {

    private int height; // centímetros
    private double weight; // kilogramas
    private String favoriteActivity;
    private TreeSet<Activity> userActivities;
    private TreeSet<String> friendsList;
    private TreeMap<GregorianCalendar, Statistics> stats;
    private TreeMap<String, ListRecords> records;
    private TreeSet<String> messageFriend;

    /**
     *
     */
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

    /**
     *
     * @param email
     * @param pass
     * @param name
     * @param gender
     * @param date
     * @param height
     * @param weight
     * @param favoriteActivity
     * @param userActivities
     * @param friendsList
     */
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

    /**
     *
     * @param email
     * @param pass
     * @param name
     * @param gender
     * @param date
     * @param height
     * @param weight
     * @param favoriteActivity
     */
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

    /**
     *
     * @param u
     */
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

    /**
     *
     * @return
     */
    public Map<String, ListRecords> getRecords() {
        TreeMap<String, ListRecords> aux = new TreeMap<>();

        for (String s : this.records.keySet()) {
            aux.put(s, this.records.get(s));
        }
        return aux;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return this.height;
    }

    /**
     *
     * @return
     */
    public double getWeight() {
        return this.weight;
    }

    /**
     *
     * @return
     */
    public String getFavoriteActivity() {
        return this.favoriteActivity;
    }

    /**
     *
     * @return
     */
    public Set<Activity> getActivities() {
        TreeSet<Activity> res = new TreeSet<>(new CompareActivity());
        for (Activity act : this.userActivities) {
            res.add(act.clone());
        }
        return res;
    }

    /**
     *
     * @return
     */
    public Set<String> getFriendsList() {
        return (TreeSet<String>) this.friendsList.clone();
    }

    /**
     *
     * @return
     */
    public Map<GregorianCalendar, Statistics> getStats() {
        TreeMap<GregorianCalendar, Statistics> aux = new TreeMap<>(new CompareStatsPerYearAndMonth());

        for (GregorianCalendar key : this.stats.keySet()) //FUNCIONA??!!!
        {
            aux.put(key, this.stats.get(key));
        }

        return aux;

    }

    /**
     *
     * @return
     */
    public Set<String> getMessage() {
        return this.messageFriend;
    }

    /**
     *
     * @param email
     */
    public void addFriendToMessage(String email) {
        this.messageFriend.add(email);
    }

    /**
     *
     * @param email
     */
    public void removeFriendFromMessage(String email) {
        this.messageFriend.remove(email);
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     *
     * @param favorite
     */
    public void setFavoriteActivity(String favorite) {
        this.favoriteActivity = favorite;
    }

    /**
     *
     * @param name
     * @return
     */
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

    /**
     *
     * @param act
     * @param tipoActividade
     * @return
     */
    public boolean addActivity(Activity act, String tipoActividade) {
        if ((act instanceof Running) || (act instanceof Walking)
                || (act instanceof Cycling) || (act instanceof MountainBiking) || (act instanceof Swimming)) {
            updateRecords(tipoActividade, act);
        }
        act.setCalories(this.weight);
        setStats(act);
        return this.userActivities.add(act);
    }

    /**
     *
     * @param u
     * @return
     */
    public boolean addFriend(User u) {              //Adiciona amigos a lista
        boolean flag = false, found = false;
        flag = this.friendsList.add(u.getEmail());

        return flag;
    }

    /**
     *
     * @param activityName
     * @return
     */
    public boolean removeActivity(String activityName) {
        boolean found = false;
        boolean flag = false;
        TreeSet actAux = new TreeSet<>(new CompareActivity());
        for (Activity a : this.userActivities) {
            actAux.add(a);
        }

        //Iterator<Activity> it = actAux.iterator();
        Iterator<Activity> it = this.userActivities.iterator();
        while (it.hasNext() && !found) {
            Activity act = it.next();
            if (act.getName().equals(activityName)) {
                it.remove();
                flag = true;
                found = true;
            }
        }
        return flag;

    }

    //////////////////Records///////////////
    /**
     *
     * @param tipoActividade
     * @param act
     * @return
     */
    public boolean addRecord(String tipoActividade, Activity act) {
        RecordsActivity a;
        if (act instanceof RecordsActivity) {
            a = (RecordsActivity) act;
            this.records.put(tipoActividade, a.getListRecords());
        }
        return true;

    }

    /**
     *
     * @param tipoActividade
     * @param act
     * @return
     */
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
    /**
     *
     * @return
     */
    public Set<Activity> getUserActivitiesAdmin() {
        return this.userActivities;
    }

    /**
     *
     * @return
     */
    public Set<String> getFriendsListAdmin() {

        return this.friendsList;
    }
    
    private double calculaTmMarathon(double distancia){
        double tempo=0;
        int numero=0;
        double distance=0;
        for(Activity act:this.getActivities())
            if(act instanceof Running){
                Running run=(Running) act;
              distance+=run.getDistance();
              tempo+= (run.getTimeSpent()/run.getDistance());
               numero++;
            } 
        
        tempo=tempo/numero;
        distance=distance/numero;
        distance=distance/distancia;
        tempo=(tempo/numero);
        tempo/=(distance);
      return tempo;  
      
    }
    private double calculaTmMarathonBTT(double distancia){
        double tempo=0;
        int numero=0;
        
        double distance=0;
        double factor=0;
        for(Activity act:this.getActivities()){
            if(act instanceof MountainBiking){
                MountainBiking run=(MountainBiking) act;
               distance+=run.getDistance();
               tempo+= (run.getTimeSpent()/run.getDistance());
               if((run.getVerticalDistance()>0) &&(run.getVerticalDistance()<0.100))
                   factor+=0.1;
               else if((run.getVerticalDistance()>=0.100) &&(run.getVerticalDistance()<0.300))
                   factor+=0.3;
               else if((run.getVerticalDistance()>=0.300) &&(run.getVerticalDistance()<0.500))
                   factor+=0.5;
               else if((run.getVerticalDistance()>=0.500) &&(run.getVerticalDistance()<1))
                   factor+=0.7;
               else if(run.getVerticalDistance()>=1)
                   factor+=0.8;
               numero++;
            }
        }
        distance/=numero;
        distance/=distancia;
        factor/=numero;
        tempo/=numero;
        tempo-=(factor*tempo);
        
        tempo/=(distance);
            
      return tempo;  
      
    }
     
    private int numeroActividadesM(){
        int num=0;
        for(Activity act:this.getActivities())
            if(act instanceof Running)
                num++;
        return num;
    }
    private int numeroActividadesMbtt(){
        int num=0;
        for(Activity act:this.getActivities())
            if(act instanceof MountainBiking)
                num++;
        return num;
    }

    
     private double tabelaWeather(String weather){
        double factor=0;
        switch(weather){
            case "Sol":
                factor=0.2;
                break;
            case "Sol intenso":
                factor=0.7;
                break;
            case "Sol intenso com ventos fortes":
                factor=0.8;
                break;
            case "Chuva":
                factor=0.4;
                break;
            case "Chuva com ventos fortes":
                factor=0.6;
                break;
            case "Chuva intensa":
                factor=0.7;
                break;
            case "Chuva intensa com ventos fortes":
                factor=0.9;
                break;
            case "Trovoada":
                factor=0.3;
                break;
            case "Trovoada com ventos fortes":
                factor=0.5;
                break;
            case "Nublado":
                factor=0.6;
                break;
        }
        return factor;
    }
    
    private double tabelaTemperatura(double temperatura){
        double factor;
        if(temperatura <10)
            factor=0.70;
        else if(temperatura<20)
            factor = 0.60;
        else if(temperatura>39)
            factor = 0.95;
        else if(temperatura >30 )
            factor = 0.80;
        else
            factor = 0.2;
        
        return factor;
    }
    
    
    
    
  
    
    public double kmDesisteM(double kmTotal){        
         //double calories = 10* u.getWeight()*tempo;
        double factor=0;
        GregorianCalendar date=new GregorianCalendar();
        int age=date.get(Calendar.YEAR)-this.getDate().get(Calendar.YEAR);
        double probabilidade;
        if(age<15)       factor=Math.random()+0.1;
        else if(age<20)  factor=Math.random()+0.5;
        else if(age<25 ) factor=Math.random()+0.7;
        else if(age<30)  factor=Math.random()+0.85;
        else if(age<35)  factor=Math.random()+0.9;
        else if(age<40)  factor=Math.random()+0.6;
        else if(age<45)  factor=Math.random()+0.5;
        else if(age<50)  factor=Math.random()+0.4;
        else if(age<55)  factor=Math.random()+0.3;
        else if(age<60)  factor=Math.random()+0.2;
        else if(age<65)  factor=Math.random()+0.1;
        else if(age>=65) factor=Math.random()+0.05;
   
        kmTotal*=factor;
        
        return kmTotal;
    }
      /**
     *
     * 
     * @param weather
     * @param temperatura
     * @param tipo
     * @param distance
     * @return
     */
    public double formula(String weather,double temperatura,String tipo,double distance){
        double tempo;
        double tempoMedio=0;
        double age,numero=0;
        GregorianCalendar date = new GregorianCalendar();
         switch (tipo) {
            case "Marathon":
               tempoMedio= calculaTmMarathon(42.195);
               numero=numeroActividadesM();
                break;
            case "Halfmarathon":
               tempoMedio= calculaTmMarathon(21.1); 
               numero=numeroActividadesM();
                break;
            case "MarathonBTT":
                tempoMedio=calculaTmMarathonBTT(distance);
                numero=numeroActividadesMbtt();
                break;
            case "Trail":
                tempoMedio=calculaTmMarathon(distance);
                tempoMedio=tempoMedio+(tempoMedio*0.3);
                numero=numeroActividadesM();
                break;
                      }
        age=date.get(Calendar.YEAR)-this.getDate().get(Calendar.YEAR);
        tempo=tempoMedio+(1*tabelaWeather(weather))+(1*tabelaTemperatura(temperatura))-(numero/100)+(age/100);
        return tempo;
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

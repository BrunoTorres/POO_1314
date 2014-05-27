package Fitness;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class Activity {

    private String name; //Nome pode ser corrida com os amigos
    private GregorianCalendar date;
    private double timeSpent; //tempo em minutos
    private double calories;

 public Activity() {
        this.name = "";
        this.date = new GregorianCalendar();
        this.timeSpent = 0.0;
        this.calories = 0; 
    }


    public Activity(String name, GregorianCalendar date, double timeSpent) {
        this.name = name;
        this.date = (GregorianCalendar) date.clone();
        this.timeSpent = timeSpent;
        this.calories=0; // VER AQUI
    }

    public Activity(Activity a) {
        this.name = a.getName();
        this.date = a.getDate();
        this.timeSpent = a.getTimeSpent();
        this.calories = a.getCalories();
    }



    /**
    * @return the name
    */
    public String getName() {
        return this.name;
    }


    /**
    * @return the date
    */
    public GregorianCalendar getDate() {
        return (GregorianCalendar) this.date.clone();
    }


    /**
    * @return the timeSpent
    */

    public double getTimeSpent() {
        return this.timeSpent;
    }

    /**
    * @return the calories
    */
    public double getCalories() {
        return this.calories;
    }

    /**
    * @return the activityRecords
    */
    public ArrayList <Record> getPerformance() {
        ArrayList<Record> aux = new ArrayList();
        for (Record rec : this.performance)
            aux.add(rec.clone());
        return aux;
    }

    public ArrayList <Record> getPerformanceAdmin() {
        return this.performance;
    }


    public void setName(String name) {
        this.name = name;
    }

    public abstract void setCalories(double peso);

    public void setActivityCalories(double calories){
        this.calories=calories;
    }

    @Override
    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;

        Activity act = (Activity) a;

        return (this.name.equals(act.getName()) &&
            this.date.equals(act.getDate()) &&
            this.timeSpent==act.getTimeSpent() &&
    this.calories == act.getCalories()); /*&&
        this.performance.equals(act.getPerformance()));*/
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Descrição: ");
        sb.append(this.name).append("\n");
        sb.append("Data: ");
        sb.append(this.date.get(Calendar.DAY_OF_MONTH)).append(" / ");;
        sb.append((this.date.get(Calendar.MONTH))+1).append(" / ");
        sb.append(this.date.get(Calendar.YEAR)).append("\n");
        sb.append("Duração: ");
        sb.append(this.timeSpent).append(" minutos \n");
        return sb.toString();
    }


    @Override
    public abstract Activity clone();
}
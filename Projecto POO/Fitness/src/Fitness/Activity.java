package Fitness;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Activity {

	                   
	private String name;                         //Nome pode ser corrida com os amigos
	private GregorianCalendar date;
	private double timeSpent;                   //tempo em minutos
	private double calories;

	private ArrayList <Records> performance;				//NAO DEVIA SER UMA LISTA??

	public Activity() {
	
		this.name = "";
		this.date = new GregorianCalendar();
		this.timeSpent = 0.0;
		this.calories = 0;

		this.performance = new ArrayList <Records>();
	}


	public Activity(String name, GregorianCalendar date, double timeSpent) {
	
		this.name = name;
		this.date = (GregorianCalendar) date.clone();
		this.timeSpent = timeSpent;
		this.calories=0;                                              // VER AQUI
		
		//this.setPerformance();
	}

	public Activity(Activity a) {
	
		this.name = a.getName();
		this.date = a.getDate();
		this.timeSpent = a.getTimeSpent();
		this.calories = a.getCalories();

		//this.performance = a.getPerformance();
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
		return  this.timeSpent;
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
	public ArrayList <Records> getPerformance() {
		ArrayList<Records> aux = new ArrayList();
	    for (Records rec : this.performance) 
			aux.add(rec.clone());
		return aux;
	}
    
    public ArrayList <Records> getPerformanceAdmin() {
		return this.performance;
	}



	public void setName(String name) {
		this.name = name;
	}
    
    public abstract void setCalories(double peso);
   
    public void setActivityCalories(double calories){
        this.calories=calories;
    }




//	public abstract void setPerformance();


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
		sb.append(this.getName()).append("\n");
		sb.append("Data: ");
		sb.append(this.getDate().toString()).append("\n");
		sb.append("Duração: ");
		sb.append(this.getTimeSpent()).append("\n");
		sb.append("Recordes:\n");
		for (Records rec : this.performance)
			if (!rec.isEmpty())
				sb.append(rec.toString()).append("\n");			
				
		return sb.toString();
	}


	@Override
	public abstract Activity clone();

}


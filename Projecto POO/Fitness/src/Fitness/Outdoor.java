package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public abstract class Outdoor extends Activity implements Serializable
{
    private String weather;

    /**
     *
     */
    public Outdoor(){
        super();
        this.weather = "";
    }

    /**
     *
     * @param name
     * @param date
     * @param timeSpent
     * @param weather
     */
    public Outdoor(String name, GregorianCalendar date, double timeSpent, String weather){
        super(name, date, timeSpent);
        this.weather = weather;
    }

    /**
     *
     * @param act
     */
    public Outdoor(Outdoor act){
        super(act);
        this.weather = act.getWeather();
    }

    /**
     *
     * @return
     */
    public String getWeather(){
        return this.weather;
    }

    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;
        
        Outdoor act = (Outdoor) a;
        return ( (super.equals(act)) && (this.weather.equals(act.getWeather())) );
    }

    public  String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Condiçoes meteorologicas: "); sb.append(this.weather).append("\n");
        return sb.toString();
    }

    public abstract Outdoor clone();

}


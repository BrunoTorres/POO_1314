package Fitness;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe abstracta
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public abstract class Activity implements Serializable {

    private String name;
    private GregorianCalendar date;
    private double timeSpent;
    private double calories;

    /**
     * Construtor Vazio
     */
    public Activity() {
        this.name = "";
        this.date = new GregorianCalendar();
        this.timeSpent = 0.0;
        this.calories = 0;
    }

    /**
     * Construtor
     * @param name Nome da actividade
     * @param date Data da realização da actividade
     * @param timeSpent Tempo gasto em minutos
     */
    public Activity(String name, GregorianCalendar date, double timeSpent) {
        this.name = name;
        this.date = (GregorianCalendar) date.clone();
        this.timeSpent = timeSpent;
        this.calories = 0; // VER AQUI
    }

    /**
     * Construtor de cópia
     * @param a Uma Activity
     */
    public Activity(Activity a) {
        this.name = a.getName();
        this.date = a.getDate();
        this.timeSpent = a.getTimeSpent();
        this.calories = a.getCalories();
    }

    /**
     * @return o nome
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return a data de quando se realizou
     */
    public GregorianCalendar getDate() {
        return (GregorianCalendar) this.date.clone();
    }

    /**
     * @return tempo gasto
     */
    public double getTimeSpent() {
        return this.timeSpent;
    }

    /**
     * @return calorias
     */
    public double getCalories() {
        return this.calories;
    }

    /**
     * @param name Nome do User
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param peso Peso do User
     */
    public abstract void setCalories(double peso);

    /**
     *
     * @param calories Calorias gastas pelo User
     */
    public void setActivityCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a == null || this.getClass() != a.getClass()) {
            return false;
        }

        Activity act = (Activity) a;

        return (this.name.equals(act.getName())
                && this.date.equals(act.getDate())
                && this.timeSpent == act.getTimeSpent()
                && this.calories == act.getCalories()); 
         

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Descrição: ");
        sb.append(this.name).append("\n");
        sb.append("Data: ");
        sb.append(this.date.get(Calendar.DAY_OF_MONTH)).append(" / ");;
        sb.append((this.date.get(Calendar.MONTH)) + 1).append(" / ");
        sb.append(this.date.get(Calendar.YEAR)).append("\n");
        sb.append("Duração: ");
        sb.append(this.timeSpent).append(" minutos \n");
        return sb.toString();
    }

    @Override
    public abstract Activity clone();
}

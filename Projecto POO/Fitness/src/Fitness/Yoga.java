package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade Yoga.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Yoga extends Indoor implements Serializable {

    /**
     * Construtor vazio.
     */
    public Yoga() {
        super();
    }

    /**
     * Construtor parametrizado.
     *
     * @param name Nome da actividade.
     * @param date Data da realização da actividade.
     * @param timeSpent Tempo gasto em minutos.
     */
    public Yoga(String name, GregorianCalendar date, double timeSpent) {
        super(name, date, timeSpent);

    }

    /**
     * Construtor de cópia.
     *
     * @param tb Recebe instância de Yoga.
     */
    public Yoga(Yoga tb) {
        super(tb);

    }

    @Override
    public void setCalories(double peso) {//MET=2.5
        double mets = 2.5;
        double calories = mets * peso * this.getTimeSpent();
        this.setActivityCalories(calories);
    }

    ////////////toString equals clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a == null || this.getClass() != a.getClass()) {
            return false;
        }
        Yoga act = (Yoga) a;
        return (super.equals(act));

    }

    @Override
    public Yoga clone() {
        return new Yoga(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}

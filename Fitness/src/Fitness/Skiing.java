package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade Skiing.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Skiing extends Outdoor implements Distance, VerticalDistance, Serializable {

    private double distance;
    private double verticaldistance;

    /**
     * Construtor vazio.
     */
    public Skiing() {
        super();
    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name - Nome da actividade.
     * @param date - Data da realização da actividade.
     * @param timeSpent - Tempo gasto em minutos.
     * @param distance - Distancia.
     * @param verticaldistance - Diferença entre a maior e a menor altura (valor absoluto).
     * @param weather - Clima.
     *
     */
    public Skiing(String name, GregorianCalendar date, double timeSpent, double distance,
            double verticaldistance, String weather) {
        super(name, date, timeSpent, weather);
        this.distance = distance;
        this.verticaldistance = verticaldistance;
    }

    /**
     * Construtor de cópia.
     *
     * @param tb - instância de Skiing.
     */
    public Skiing(Skiing tb) {
        super(tb);
        this.distance = tb.getDistance();
        this.verticaldistance = tb.getVerticalDistance();
    }

    @Override
    public double getDistance() {
        return this.distance;
    }

    @Override
    public double getVerticalDistance() {
        return this.verticaldistance;
    }

    @Override
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public void setVerticalDistance(double verticaldistance) {
        this.verticaldistance = verticaldistance;
    }

    @Override
    public void setCalories(double peso) {
        double mets = 8.5;
        double calories = mets * peso * (this.getTimeSpent() / 60);
        this.setActivityCalories(calories);
    }

     ////////////toString equals clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distance horizontal").append("\n");
        sb.append(this.distance).append("\n");
        sb.append("Distance vertical").append("\n");
        sb.append(this.verticaldistance).append("\n");
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
        Skiing act = (Skiing) a;
        return (super.equals(act)
                && this.distance == act.getDistance()
                && this.verticaldistance == act.getVerticalDistance());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.verticaldistance) ^ (Double.doubleToLongBits(this.verticaldistance) >>> 32));
        return hash;
    }

    @Override
    public Skiing clone() {
        return new Skiing(this);
    }
}

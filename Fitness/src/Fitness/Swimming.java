package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade Swimming.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Swimming extends Indoor implements Distance, RecordsActivity, Serializable {

    private double distance;
    private ListRecords recs;

    /**
     * Construtor vazio.
     */
    public Swimming() {
        super();
        this.distance = 0;
        this.recs = new ListRecords();
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome da actividade.
     * @param date - Data da realização da actividade.
     * @param timeSpent - Tempo gasto em minutos.
     * @param distance - Distancia.
     */
    public Swimming(String name, GregorianCalendar date, double timeSpent, double distance) {
        super(name, date, timeSpent);
        this.distance = distance;
        this.recs = createRecord();

    }

    /**
     * Construtor de cópia.
     *
     * @param tb - instancia de Swimming.
     */
    public Swimming(Swimming tb) {
        super(tb);
        this.distance = tb.getDistance();
        this.recs = tb.getListRecords();

    }

    @Override
    public double getDistance() {
        return this.distance;
    }

    @Override
    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public void setCalories(double peso) {
        double mets = 8;
        double calories = mets * peso * (this.getTimeSpent() / 60);
        this.setActivityCalories(calories);
    }

    /**
     * Método que devolve a lista de recordes registados nessa actividade.
     *
     * @return Devolve uma ListRecords.
     */
    private ListRecords createRecord() {
        ListRecords list = new ListRecords("Swimming");

        Record rec50m = new TimePerDistance("50 m", 50, this.distance, this.getTimeSpent());
        Record rec100m = new TimePerDistance("100 m", 100, this.distance, this.getTimeSpent());
        Record rec200m = new TimePerDistance("200 m", 200, this.distance, this.getTimeSpent());
        Record rec400m = new TimePerDistance("400 m", 400, this.distance, this.getTimeSpent());
        Record rec1500m = new TimePerDistance("1500 m", 1500, this.distance, this.getTimeSpent());

        list.addRecord(rec50m);
        list.addRecord(rec100m);
        list.addRecord(rec200m);
        list.addRecord(rec400m);
        list.addRecord(rec1500m);

        return list;
    }

     ////////////toString equals clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distance").append("\n");
        sb.append(this.distance).append("\n");
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
        Swimming act = (Swimming) a;
        return (super.equals(act)
                && this.distance == act.getDistance());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        return hash;
    }

    @Override
    public Swimming clone() {
        return new Swimming(this);
    }

    @Override
    public ListRecords getListRecords() {
        return this.recs.clone();
    }
}

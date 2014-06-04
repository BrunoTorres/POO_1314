package Fitness;

import java.io.Serializable;

/**
 * Classe agrega dadas das actividades.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Statistics implements Serializable {

    private double timeSpend;
    private double calories;
    private double distance;

    /**
     * Construtor vazio.
     */
    public Statistics() {

        this.timeSpend = 0;
        this.calories = 0;
        this.distance = 0;
    }

    /**
     * Construtor parametrizado.
     * @param timeSpend  Tempo (double)
     * @param calories Calorias (double)
     */
    public Statistics(double timeSpend, double calories) {
        this.distance = 0;
        this.calories = calories;
        this.timeSpend = timeSpend;
    }

    /**
     * Construtor parametrizado.
     * @param timeSpend  Tempo (double)
     * @param calories  Calorias (double)
     * @param distance  Distância (double)
     */
    public Statistics(double timeSpend, double calories, double distance) {
        this.distance = distance;
        this.calories = calories;
        this.timeSpend = timeSpend;
    }

    /**
     * Construtor de cópia.
     * @param stat  Instâncias de Statistic.
     */
    public Statistics(Statistics stat) {
        this.timeSpend = stat.getTimeSpend();
        this.calories = stat.getCalories();
        this.distance = stat.getDistance();
    }

    /**
     * Método que devolve o tempo.
     * @return Tempo, double.
     */
    public double getTimeSpend() {
        return this.timeSpend;
    }

    /**
     * Método que devolve o número de calorias gastas.
     * @return Calorias, double.
     */
    public int getCalories() {
        return (int) this.calories;
    }

    /**
     * Método que devolve a distância.
     * @return Distância, double.
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * Método que incrementa as tempo, distância e calorias dados três valores.
     * @param time  Tempo a incrementar, double.
     * @param distance  Distância a incrementar, double.
     * @param calories  Calorias a incrementar, double.
     */
    public void incrementsTimeDistanceCalories(double time, double distance, double calories) {
        this.calories += calories;
        this.distance += distance;
        this.timeSpend += time;
    }

    /**
     * Método toString para mostrar apenas a variável de distância.
     * @return Distância, String.
     */
    public String toStringDistance() {
        StringBuilder sb = new StringBuilder();
        sb.append("Distance: ");
        sb.append(this.distance).append("\n");
        return sb.toString();
    }

    /** 
     * Método toString para mostrar apenas a variável de calorias.
     * @return Calorias, String.
     */
    public String toStringCalories() {
        StringBuilder sb = new StringBuilder();
        sb.append("Calories: ");
        sb.append((int) this.calories).append("\n");
        return sb.toString();
    }

    /**
     * Método toString para mostrar apenas a variável de tempo.
     * @return Tempo, String
     */
    public String toStringTimeSpend() {
        StringBuilder sb = new StringBuilder();
        sb.append("Time Spent: ");
        sb.append(this.timeSpend).append("\n");
        return sb.toString();
    }

    @Override
    public Statistics clone() {
        return new Statistics(this);
    }
}

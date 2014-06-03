package Fitness;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class Statistics implements Serializable {

    private double timeSpend;
    private double calories;
    private double distance;

    /**
     *
     */
    public Statistics() {

        this.timeSpend = 0;
        this.calories = 0;
        this.distance = 0;
    }

    /**
     *
     * @param timeSpend
     * @param calories
     */
    public Statistics(double timeSpend, double calories) {
        this.distance = 0;
        this.calories = calories;
        this.timeSpend = timeSpend;
    }

    /**
     *
     * @param timeSpend
     * @param calories
     * @param distance
     */
    public Statistics(double timeSpend, double calories, double distance) {
        this.distance = distance;
        this.calories = calories;
        this.timeSpend = timeSpend;
    }

    /**
     *
     * @param stat
     */
    public Statistics(Statistics stat) {
        this.timeSpend = stat.getTimeSpend();
        this.calories = stat.getCalories();
        this.distance = stat.getDistance();
    }

    /**
     *
     * @return
     */
    public double getTimeSpend() {
        return this.timeSpend;
    }

    /**
     *
     * @return
     */
    public double getCalories() {
        return this.calories;
    }

    /**
     *
     * @return
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     *
     * @param time
     * @param distance
     * @param calories
     */
    public void incrementsTimeDistanceCalories(double time, double distance, double calories) {
        this.calories += calories;
        this.distance += distance;
        this.timeSpend += time;
    }

    /**
     *
     * @return
     */
    public String toStringDistance() {
        StringBuilder sb = new StringBuilder();
        sb.append("Distance: ");
        sb.append(this.distance).append("\n");
        return sb.toString();
    }

    /**
     *
     * @return
     */
    public String toStringCalories() {
        StringBuilder sb = new StringBuilder();
        sb.append("Calories: ");
        sb.append(this.calories).append("\n");
        return sb.toString();
    }

    /**
     *
     * @return
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

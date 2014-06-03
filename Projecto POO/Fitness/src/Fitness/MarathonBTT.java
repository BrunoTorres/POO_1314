
package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class MarathonBTT extends Event implements Serializable {

    private double distance;

    /**
     *
     */
    public MarathonBTT() {
        super();
        this.distance = 0;
    }

    /**
     *
     * @param name
     * @param location
     * @param maxParticipants
     * @param participants
     * @param deadline
     * @param date
     * @param duration
     * @param participantsList
     * @param ranking
     * @param distance
     */
    public MarathonBTT(String name, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking,double distance) {
        super(name, "MountainBiking", location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
        this.distance=distance;
    }

    /**
     *
     * @param name
     * @param location
     * @param maxParticipants
     * @param deadline
     * @param date
     * @param duration
     * @param participantsList
     * @param ranking
     * @param distance
     */
    public MarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking,double distance) {
        super(name, "MountainBiking", location, maxParticipants, deadline, date, duration, participantsList, ranking);
        this.distance=distance;
    }

    /**
     *
     * @param name
     * @param location
     * @param maxParticipants
     * @param deadline
     * @param date
     * @param duration
     * @param distance
     */
    public MarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration,double distance) {
        super(name, "MountainBiking", location, maxParticipants, deadline, date, duration);
        this.distance=distance;
    }

    /**
     *
     * @param name
     * @param location
     * @param maxParticipants
     * @param deadline
     * @param date
     * @param distance
     */
    public MarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date,double distance) {
        super(name, "MountainBiking", location, maxParticipants, deadline, date);
        this.distance=distance;
    }

    /**
     *
     * @param m
     */
    public MarathonBTT(MarathonBTT m) {
        super(m);
        this.distance=m.getDistance();
    }

    /**
     *
     * @return
     */
    public double getDistance() {
        return this.distance;
    }

    //toString,equals,clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distancia= ").append(this.distance).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public MarathonBTT clone() {
        return new MarathonBTT(this);
    }
}
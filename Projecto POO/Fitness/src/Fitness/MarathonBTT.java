
package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;

/**
 *
 * @author Bruno
 */
public class MarathonBTT extends Event {

    private double distance;

    public MarathonBTT() {
        super();
        this.distance = 0;
    }

    public MarathonBTT(String name, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking,double distance) {
        super(name, "MountainBiking", location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
        this.distance=distance;
    }

    public MarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking,double distance) {
        super(name, "MountainBiking", location, maxParticipants, deadline, date, duration, participantsList, ranking);
        this.distance=distance;
    }

    public MarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration,double distance) {
        super(name, "MountainBiking", location, maxParticipants, deadline, date, duration);
        this.distance=distance;
    }

    public MarathonBTT(MarathonBTT m) {
        super(m);
        this.distance=m.getDistance();
    }

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
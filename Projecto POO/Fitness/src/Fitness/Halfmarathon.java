package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;

/**
 *
 * @author Bruno
 */
public class Halfmarathon extends Event {

    private final double distance = 21.1;

    public Halfmarathon() {
        super();
        this.distance = 0;
    }

    public Halfmarathon(String name, String tipoActivity, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, GregorianCalendar duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, tipoActivity, location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
    }

    public Halfmarathon(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, GregorianCalendar duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, tipoActivity, location, maxParticipants, deadline, date, duration, participantsList, ranking);
    }

    public Halfmarathon(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, GregorianCalendar duration) {
        super(name, tipoActivity, location, maxParticipants, deadline, date, duration);
    }

    public Halfmarathon(Halfmarathon m) {
        super(m);
    }

    public double getDistance() {
        return this.distance;
    }

    //toString,equals,clone
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distancia= 21 km").append("\n");
        return sb.toString();
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public Halfmarathon clone() {
        return new Halfmarathon(this);
    }
}
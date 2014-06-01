package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class Halfmarathon extends Event implements Serializable{

    private final double distance = 21.1;

    public Halfmarathon() {
        super();
        //this.distance = 0;
    }

    public Halfmarathon(String name, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, "Running", location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
    }

    public Halfmarathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, "Running", location, maxParticipants, deadline, date, duration, participantsList, ranking);
    }

    public Halfmarathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration) {
        super(name, "Running", location, maxParticipants, deadline, date, duration);
    }
     public Halfmarathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date) {
        super(name, "Running", location, maxParticipants, deadline, date);
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
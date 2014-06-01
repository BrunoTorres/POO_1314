/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;

/**
 *
 * @author Bruno
 */
public class Marathon extends Event implements Serializable{

    private final double distance = 42.195;
   
  
    public Marathon() {
        super();
    }

    public Marathon(String name, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, "Running", location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
    }

    public Marathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, "Running", location, maxParticipants, deadline, date, duration, participantsList, ranking);
    }

    public Marathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration) {
        super(name, "Running", location, maxParticipants, deadline, date, duration);
    }

    public Marathon(Marathon m) {
        super(m);
    }

    public double getDistance() {
        return this.distance;
    }

    //toString,equals,clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
       sb.append(super.toString());
       //sb.append("Distancia= ").append(this.distance).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public Marathon clone() {
        return new Marathon(this);
    }
}
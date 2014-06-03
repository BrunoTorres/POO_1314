/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.io.Serializable;
/**
 *
 * @author Bruno
 */
public class Trail extends Event implements Serializable{
    
    
    double distance;
  
    /**
     *
     */
    public Trail() {
        super();
    }

    /**
     *
     * @param name
     * @param tipoActivity
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
    public Trail(String name, String tipoActivity, String location, int maxParticipants, int participants,
            GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList,
            TreeSet<Ranking> ranking,double distance) {

        super(name, tipoActivity, location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
        this.distance=distance;
    }

    /**
     *
     * @param name
     * @param tipoActivity
     * @param location
     * @param maxParticipants
     * @param deadline
     * @param date
     * @param duration
     * @param participantsList
     * @param ranking
     * @param distance
     */
    public Trail(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date,
            double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking,double distance) {

        super(name, tipoActivity, location, maxParticipants, deadline, date, duration, participantsList, ranking);
        this.distance=distance;
    }

    /**
     *
     * @param name
     * @param tipoActivity
     * @param location
     * @param maxParticipants
     * @param deadline
     * @param date
     * @param duration
     * @param distance
     */
    public Trail(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date,
            double duration,double distance) {

        super(name, tipoActivity, location, maxParticipants, deadline, date, duration);
        this.distance=distance;
    }

    /**
     *
     * @param m
     */
    public Trail(Trail m) {
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
    public Trail clone() {
        return new Trail(this);
    }
    
    
}

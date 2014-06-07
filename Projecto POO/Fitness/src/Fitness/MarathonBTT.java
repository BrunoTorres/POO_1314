package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.io.Serializable;

/**
 * Evento MarathonBTT
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class MarathonBTT extends Event implements Serializable {

    private double distance;

    /**
     * Construtor vazio
     */
    public MarathonBTT() {
        super();
        this.distance = 0;
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param participants- Numero de participantes inscritos
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     * @param duration - duração.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - Classificação final do Evento.
     * @param distance  Distancia do evento.
     */
    public MarathonBTT(String name, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking, double distance) {
        super(name, "MountainBiking", location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
        this.distance = distance;
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     * @param duration - duração.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - Classificação final do Evento.
     * @param distance  Distancia do evento.
     */
    public MarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking, double distance) {
        super(name, "MountainBiking", location, maxParticipants, deadline, date, duration, participantsList, ranking);
        this.distance = distance;
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     * @param duration - Duração do evento.
     * @param distance Distancia do evento.
     */
    public MarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, double distance) {
        super(name, "MountainBiking", location, maxParticipants, deadline, date, duration);
        this.distance = distance;
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     * @param distance Distancia do evento.
     */
    public MarathonBTT(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double distance) {
        super(name, "MountainBiking", location, maxParticipants, deadline, date);
        this.distance = distance;
    }

    /**
     * Construtor de cópia
     *
     * @param m-Instancia de MarathonBTT.
     */
    public MarathonBTT(MarathonBTT m) {
        super(m);
        this.distance = m.getDistance();
    }

    /**
     * Método que devolve a distancia do evento.
     *
     * @return double,distancia
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
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        return hash;
    }

    @Override
    public MarathonBTT clone() {
        return new MarathonBTT(this);
    }
}

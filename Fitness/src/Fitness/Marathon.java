package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.io.Serializable;

/**
 * Evento Marathon
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Marathon extends Event implements Serializable {

    private final double distance = 42.195;

    /**
     * Construtor vazio.
     */
    public Marathon() {
        super();
    }

    /**
     *
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
     * @param ranking - classificação final do Evento.
     */
    public Marathon(String name, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, "Running", location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     * @param duration - duração.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - classificação final do Evento.
     */
    public Marathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, "Running", location, maxParticipants, deadline, date, duration, participantsList, ranking);
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
     *
     */
    public Marathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration) {
        super(name, "Running", location, maxParticipants, deadline, date, duration);
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome do Evento.
     * @param location - Nome da localidade do Evento.
     * @param maxParticipants - Numero de participantes máximo.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Evento.
     */
    public Marathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date) {
        super(name, "Running", location, maxParticipants, deadline, date);
    }

    /**
     * Construtor de cópia
     *
     * @param m-Instancia de Marathon.
     */
    public Marathon(Marathon m) {
        super(m);
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
        //sb.append("Distancia= ").append(this.distance).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        return hash;
    }

    @Override
    public Marathon clone() {
        return new Marathon(this);
    }
}

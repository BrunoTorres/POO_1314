package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.io.Serializable;

/**
 * Evento Halfmarathon.
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Halfmarathon extends Event implements Serializable{

    private final double distance = 21.1;

    /**
     * Construtor vazio.
     */
    public Halfmarathon() {
        super();
      
    }

    /**
     *
     * Construtor parametrizado.
     * @param name - Nome do Trail.
     * @param location - Nome da localidade do Trail.
     * @param maxParticipants - Numero de participantes máximo.
     * @param participants - Numero de participantes inscritos.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Trail.
     * @param duration - duração.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - classificação final do Trail.
     */
    public Halfmarathon(String name, String location, int maxParticipants, int participants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, "Running", location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
    }

    /**
     * Construtor parametrizado.
     * @param name - Nome do Trail.
     * @param location - Nome da localidade do Trail.
     * @param maxParticipants - Numero de participantes maximo.
     * @param deadline - Data limite de inscriçao.
     * @param date - Data do Trail.
     * @param duration - Duraçao.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - Classificaçao final do Trail.
     */
    public Halfmarathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking) {
        super(name, "Running", location, maxParticipants, deadline, date, duration, participantsList, ranking);
    }

    /**
     *
      * Construtor parametrizado.
     * @param name - Nome do Trail.
     * @param location - Nome da localidade do Trail.
     * @param maxParticipants - Numero de participantes maximo.
     * @param deadline - Data limite de inscriçao.
     * @param date - Data do Trail.
     * @param duration - Duração do evento.
     */
    public Halfmarathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double duration) {
        super(name, "Running", location, maxParticipants, deadline, date, duration);
    }

    /**
     *
     * @param name - Nome do Trail.
     * @param location - Nome da localidade do Trail.
     * @param maxParticipants - Numero de participantes maximo.
     * @param deadline - Data limite de inscriçao.
     * @param date - Data do Trail.
     */
    public Halfmarathon(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date) {
        super(name, "Running", location, maxParticipants, deadline, date);
    }

    /**
     *
     * Construtor de cópia.
     * @param m - Instancia de Halfmarathon.
     */
    public Halfmarathon(Halfmarathon m) {
        super(m);
    }

    /**
     * Método que devolve a distancia realizada na actividade.
     * @return Devolve um inteiro.
     */
    public double getDistance() {
        return this.distance;
    }

    //toString,equals,clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distancia= 21 km").append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public Halfmarathon clone() {
        return new Halfmarathon(this);
    }
}
package Fitness;

import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.io.Serializable;

/**
 *
 * Evento Trail.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Trail extends Event implements Serializable {

    double distance;

    /**
     * Construtor vazio.
     */
    public Trail() {
        super();
    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name - Nome do Trail.
     * @param tipoActivity - Tipo de Activity a que o evento pertence.
     * @param location - Nome da localidade do Trail.
     * @param maxParticipants - Numero de participantes máximo.
     * @param participants - Numero de participantes inscritos.
     * @param deadline - Data limite de inscrição.
     * @param date - Data do Trail.
     * @param duration - duração.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - classificação final do Trail.
     * @param distance - Distancia.
     */
    public Trail(String name, String tipoActivity, String location, int maxParticipants, int participants,
            GregorianCalendar deadline, GregorianCalendar date, double duration, TreeSet<User> participantsList,
            TreeSet<Ranking> ranking, double distance) {

        super(name, tipoActivity, location, maxParticipants, participants, deadline, date, duration, participantsList, ranking);
        this.distance = distance;
    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name - Nome do Trail.
     * @param tipoActivity - Tipo de Activity.
     * @param location - Nome da localidade do Trail.
     * @param maxParticipants - Numero de participantes maximo.
     * @param deadline - Data limite de inscriçao.
     * @param date - Data do Trail.
     * @param duration - Duraçao.
     * @param participantsList - Lista de participantes inscritos.
     * @param ranking - Classificaçao final do Trail.
     * @param distance - Distancia.
     */
    public Trail(String name, String tipoActivity, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date,
            double duration, TreeSet<User> participantsList, TreeSet<Ranking> ranking, double distance) {

        super(name, tipoActivity, location, maxParticipants, deadline, date, duration, participantsList, ranking);
        this.distance = distance;
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome do Trail.
     * @param location - Nome da localidade do Trail.
     * @param maxParticipants - Numero de participantes maximo.
     * @param deadline - Data limite de inscriçao.
     * @param date - Data do Trail.
     * @param distance - Distancia.
     */
    public Trail(String name, String location, int maxParticipants, GregorianCalendar deadline, GregorianCalendar date, double distance) {

        super(name, "Running", location, maxParticipants, deadline, date);
        this.distance = distance;
    }

    /**
     * Construtor de cópia.
     *
     * @param m - Instancia de Trail.
     */
    public Trail(Trail m) {
        super(m);
        this.distance = m.getDistance();
    }

    /**
     * Método que devolve a distancia realizada na actividade.
     *
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
        sb.append("Distancia= ").append(this.distance).append("\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        return hash;
    }

    @Override
    public Trail clone() {
        return new Trail(this);
    }

}

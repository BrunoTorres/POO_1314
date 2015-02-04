package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade Badminton
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Badminton extends Indoor implements UserVs, Serializable {

    private int myScore;
    private int opScore;

    /**
     * Construtor vazio
     */
    public Badminton() {
        super();
    }

    /**
     * Construtor parametrizado.
     *
     * @param name Nome da actividade.
     * @param date Data da realização da actividade.
     * @param timeSpent Tempo gasto em minutos.
     * @param myScore Pontos feitos.
     * @param opScore Pontos recebidos.
     *
     */
    public Badminton(String name, GregorianCalendar date, double timeSpent, int myScore, int opScore) {
        super(name, date, timeSpent);
        this.myScore = myScore;
        this.opScore = opScore;
    }

    /**
     *
     * Construtor de cópia.
     *
     * @param tb-instância de Badminton.
     */
    public Badminton(Badminton tb) {
        super(tb);
        this.myScore = tb.getMyScore();
        this.opScore = tb.getOpScore();
    }

    @Override
    public int getMyScore() {
        return this.myScore;
    }

    @Override
    public int getOpScore() {
        return this.opScore;
    }

    @Override
    public void setCalories(double peso) {
        double mets = 4.5;
        double calories = mets * peso * (this.getTimeSpent() / 60);
        this.setActivityCalories(calories);
    }

    ////////////toString equals clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("My Score").append("\n");
        sb.append(this.myScore).append("\n");
        sb.append("Opponent Score").append("\n");
        sb.append(this.opScore).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a == null || this.getClass() != a.getClass()) {
            return false;
        }
        Badminton act = (Badminton) a;
        return (super.equals(act)
                && this.myScore == act.getMyScore()
                && this.opScore == act.getOpScore());

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.myScore;
        hash = 97 * hash + this.opScore;
        return hash;
    }

    @Override
    public Badminton clone() {
        return new Badminton(this);
    }

}

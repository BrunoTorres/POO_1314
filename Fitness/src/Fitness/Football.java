package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade Football
 *
 * @author Bruno
 */
public class Football extends Outdoor implements UserVs, Serializable {

    private int myScore;
    private int opScore;

    /**
     * Construtor vazio
     */
    public Football() {
        super();
    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name- Nome da actividade.
     * @param date- Data da realização da actividade.
     * @param timeSpent- Tempo gasto em minutos.
     * @param myScore- Pontos feitos.
     * @param opScore- Pontos recebidos.
     * @param weather-Clima.
     */
    public Football(String name, GregorianCalendar date, double timeSpent, int myScore, int opScore, String weather) {
        super(name, date, timeSpent, weather);
        this.myScore = myScore;
        this.opScore = opScore;
    }

    /**
     * Construtor de cópia.
     *
     * @param tb - instância de Football.
     */
    public Football(Football tb) {
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
        double mets = 8;
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
        Football act = (Football) a;
        return (super.equals(act)
                && this.myScore == act.getMyScore()
                && this.opScore == act.getOpScore());

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.myScore;
        hash = 67 * hash + this.opScore;
        return hash;
    }

    @Override
    public Football clone() {
        return new Football(this);
    }

}

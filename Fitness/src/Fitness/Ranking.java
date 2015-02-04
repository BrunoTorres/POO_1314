package Fitness;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classificação,por km(caso seja desistente),ou tempo.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Ranking implements Serializable {

    private double time;
    private int km;
    private User athlete;

    /**
     * Construtor vazio.
     */
    public Ranking() {
        this.time = 0;
        this.km = 0;
        this.athlete = new User();
    }

    /**
     * Construtor parametrizado
     *
     * @param u - Utilizador.
     * @param time - Tempo registado em minutos.
     */
    public Ranking(User u, double time) {
        this.athlete = u.clone();
        this.time = time;
        this.km = 0;
    }

    /**
     * Construtor parametrizado.
     *
     * @param u - Utilizador.
     * @param km - kilometro em que utilizador desistiu.
     */
    public Ranking(User u, int km) {
        this.athlete = u.clone();
        this.km = km;
        this.time = 0;
    }

    /**
     * Construtor de copia
     *
     * @param r instância de Ranking
     */
    public Ranking(Ranking r) {
        this.athlete = r.getAthlete();
        this.km = r.getKm();
        this.time = r.getTime();
    }

    /**
     * Método que devolve o tempo registado.
     *
     * @return double,tempo em minutos.
     */
    public double getTime() {
        return this.time;
    }

    /**
     * Método que devolve o km que desistiu.
     *
     * @return int,km.
     */
    public int getKm() {
        return this.km;
    }

    /**
     * Método que devolve o utilizador.
     *
     * @return User.
     */
    public User getAthlete() {
        return this.athlete.clone();
    }

    /**
     * Método que altera o tempo.
     *
     * @param time Novo tempo.
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Método que altera os km.
     *
     * @param km Novo km.
     */
    public void setKm(int km) {
        this.km = km;
    }

    //equals,toString,clone
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Ranking r = (Ranking) o;
        return (this.athlete.equals(r.getAthlete()) && this.km == r.getKm() && this.time == r.getTime());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.time) ^ (Double.doubleToLongBits(this.time) >>> 32));
        hash = 37 * hash + this.km;
        hash = 37 * hash + Objects.hashCode(this.athlete);
        return hash;
    }

    @Override
    public Ranking clone() {
        return new Ranking(this);
    }

    /**
     * Método que devolve a descrição dos utilizadores que não desistiram.
     *
     * @return String
     */
    public String toStringTime() {
        StringBuilder sb = new StringBuilder();
        int h, m;
        double s;
        h = (int) this.time / 60;
        m = (int) this.time % 60;

        s = this.time - ((int) this.time);
        s = s * 60;

        sb.append("Nome do atleta: ").append(this.athlete.getName()).append("\n");
        sb.append("\t Tempo: ").append(h).append("(h):");
        sb.append(m).append("(min): ");
        sb.append((int) s).append("(seg)\n");

        return sb.toString();

    }

    /**
     * Método que devolve a descrição dos utilizadores que desistiram.
     *
     * @return String
     */
    public String toStringDesiste() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome do atleta: ").append(this.athlete.getName()).append("\n");
        sb.append("\t Desistiu ao km: ").append(this.km);
        return sb.toString();

    }

}

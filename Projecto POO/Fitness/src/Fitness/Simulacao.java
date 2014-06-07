package Fitness;

import java.io.Serializable;
import java.util.Objects;

/**
 * Regista o resultado de uma simulação para um evento de um utilizador.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Simulacao implements Serializable {

    private double tempoGeral;
    private double tempoMedio;
    private int kmDesiste;
    private User u;

    /**
     * Construtor vazio.
     */
    public Simulacao() {
        this.tempoGeral = 0;
        this.tempoMedio = 0;
        this.kmDesiste = 0;
        this.u = new User();
    }

    /**
     * Construtor parametrizado.
     *
     * @param user - Utilizador associado.
     * @param tempoMedio - Tempo medio por km em minutos.
     * @param km - Numero de kilometros que o utilizador consegue fazer no evento.
     */
    public Simulacao(User user, double tempoMedio, int km) {
        this.tempoGeral = 0;
        this.tempoMedio = tempoMedio;
        this.kmDesiste = km;
        this.u = user.clone();
    }

    /**
     * Construtor de cópia.
     *
     * @param s - instancia de Simulaçao.
     */
    public Simulacao(Simulacao s) {
        this.tempoGeral = s.getTempoGeral();
        this.tempoMedio = s.getTempoMedio();
        this.kmDesiste = s.getKmDesiste();
        this.u = s.getUser();
    }

    /**
     * Método que devolve o tempo geral do utilizador.
     *
     * @return Devolve um double.
     */
    public double getTempoGeral() {
        return tempoGeral;
    }

    /**
     * Método que devolve o tempo médio por km em minutos.
     *
     * @return Devolve um double.
     */
    public double getTempoMedio() {
        return tempoMedio;
    }

    /**
     * Método que devolve o numero de kilometros que o utilizador consegue fazer no evento.
     *
     * @return Devolve um inteiro.
     */
    public int getKmDesiste() {
        return kmDesiste;
    }

    /**
     * Método que o utilizador da Simulação.
     *
     * @return Devolve um clone do User.
     */
    public User getUser() {
        return u.clone();
    }

    /**
     * Método que incrementa o tempo geral de acordo com o tempo médio (para um km).
     *
     * @param intervalo Intervalo de tempo.
     */
    public void actualiza(double intervalo) {
        double tempo = this.tempoMedio * (Math.random() + 0.5);
        this.tempoGeral += (intervalo * tempo);
    }

    //toSting,equals,clone
    @Override
    public Simulacao clone() {
        return new Simulacao(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Simulacao s = (Simulacao) o;
        return (this.kmDesiste == s.getKmDesiste()
                && this.tempoGeral == s.getTempoGeral()
                && this.tempoMedio == s.getTempoMedio()
                && this.u.equals(s.getUser()));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.tempoGeral) ^ (Double.doubleToLongBits(this.tempoGeral) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.tempoMedio) ^ (Double.doubleToLongBits(this.tempoMedio) >>> 32));
        hash = 79 * hash + this.kmDesiste;
        hash = 79 * hash + Objects.hashCode(this.u);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int h, m;
        double s;

        h = (int) this.tempoGeral / 60;
        m = (int) this.tempoGeral % 60;
        s = this.tempoGeral - ((int) this.tempoGeral);
        s = s * 60;
        sb.append("Nome: ").append(u.getName());
        sb.append("\tTempo: ");
        if (h > 0) {
            sb.append(h).append("(h):");
        }
        sb.append(m).append("(min): ");
        sb.append((int) s).append("(seg)\n");
        return sb.toString();
    }
}

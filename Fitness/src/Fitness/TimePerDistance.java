package Fitness;

import java.io.Serializable;

/**
 * Classe que define os recordes de distancia por tempo.
 *
 * @author Bruno Pereiras
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public final class TimePerDistance extends Record implements Serializable {

    private double recordDistance;
    private double time;

    /**
     * Construtor vazio.
     */
    public TimePerDistance() {
        super();
        this.recordDistance = 0.0;
        this.time = 0.0;
    }

    /**
     *
     * Construtor parametrizado.
     *
     * @param name - Nome do recorde.
     * @param recordDistance - Distancia do recorde.
     * @param myDistance - Distancia feita.
     * @param myTime - Tempo feito.
     */
    public TimePerDistance(String name, double recordDistance, double myDistance, double myTime) {
        super(name);
        this.recordDistance = recordDistance;
        this.setStatistic(myDistance, myTime);
    }

    /**
     * Construtor de cópia
     *
     * @param stat - instância de TimePerDistance.
     */
    public TimePerDistance(TimePerDistance stat) {
        super(stat);
        this.recordDistance = stat.getRecordDistance();
        this.time = stat.getTime();
    }

    /**
     * Método que devolve o tempo em minutos.
     *
     * @return double,distancia.
     */
    public double getTime() {
        return this.time;
    }

    /**
     * Método que devolve a distancia do recorde em km.
     *
     * @return double,distancia.
     */
    public double getRecordDistance() {
        return this.recordDistance;
    }

    @Override
    public boolean isEmpty() {
        return (this.time != 0.0);
    }

    /**
     *
     * @param distance
     * @param time
     */
    private void setStatistic(double distance, double time) {
        double div;
        if (!(distance < this.recordDistance)) {
            div = this.recordDistance / distance;
            this.time = div * time;
        }
    }

    /**
     * Método que altera o tempo, caso o parâmetro recebido seja menor que o tempo da instancia.
     *
     * @param act-Instancia Record.
     */
    @Override
    public void update(Record act) {
        TimePerDistance a = (TimePerDistance) act;
        if (this.time < a.getTime()) {
            this.time = a.getTime();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int h, m;
        double s;
        h = (int) this.time / 60;
        m = (int) this.time % 60;

        s = this.time - ((int) this.time);
        s = s * 60;
        sb.append(super.toString());
        if (this.time > 0) {
            sb.append("Tempo registado: ");
            if (h > 0) {
                sb.append(h).append("(h):");
            }
            sb.append(m).append("(min): ");
            sb.append((int) s).append("(seg)\n");
        } else {
            sb.append("Sem recorde").append("\n");
        }

        return sb.toString();
    }

    @Override
    public TimePerDistance clone() {
        return new TimePerDistance(this);
    }
}

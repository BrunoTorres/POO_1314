package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe abstracta para todas as actividades que tenham o clima como variável de instancia.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public abstract class Outdoor extends Activity implements Serializable {

    private String weather;

    /**
     * Construtor vazio
     */
    public Outdoor() {
        super();
        this.weather = "";
    }

    /**
     * Construtor parametrizado.
     *
     * @param name- Nome da actividade.
     * @param date- Data da realização da actividade.
     * @param timeSpent- Tempo gasto em minutos.
     * @param weather -Clima.
     */
    public Outdoor(String name, GregorianCalendar date, double timeSpent, String weather) {
        super(name, date, timeSpent);
        this.weather = weather;
    }

    /**
     * Construtor de cópia.
     *
     * @param act- objecto do tipo Outdoor.
     */
    public Outdoor(Outdoor act) {
        super(act);
        this.weather = act.getWeather();
    }

    /**
     * Método que devolve o clima.
     *
     * @return String.
     */
    public String getWeather() {
        return this.weather;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a == null || this.getClass() != a.getClass()) {
            return false;
        }

        Outdoor act = (Outdoor) a;
        return ((super.equals(act)) && (this.weather.equals(act.getWeather())));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.weather);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Condiçoes meteorologicas: ");
        sb.append(this.weather).append("\n");
        return sb.toString();
    }

    @Override
    public abstract Outdoor clone();

}

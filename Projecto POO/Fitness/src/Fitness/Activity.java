package Fitness;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Classe abstracta de actividades.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public abstract class Activity implements Serializable {

    private String name;
    private GregorianCalendar date;
    private double timeSpent;
    private double calories;

    /**
     * Construtor vazio.
     */
    public Activity() {
        this.name = "";
        this.date = new GregorianCalendar();
        this.timeSpent = 0.0;
        this.calories = 0;
    }

    /**
     * Construtor parametrizado
     *
     * @param name Nome da actividade.
     * @param date Data da actividade.
     * @param timeSpent Tempo gasto na actividade, em minutos.
     */
    public Activity(String name, GregorianCalendar date, double timeSpent) {
        this.name = name;
        this.date = (GregorianCalendar) date.clone();
        this.timeSpent = timeSpent;
        this.calories = 0; // VER AQUI
    }

    /**
     * Construtor de cópia da classe
     *
     * @param a-Objecto Activity.
     */
    public Activity(Activity a) {
        this.name = a.getName();
        this.date = a.getDate();
        this.timeSpent = a.getTimeSpent();
        this.calories = a.getCalories();
    }

    /**
     * Método que devolve o nome da actividade.
     *
     * @return Devolve uma string.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método que devolve a data de quando foi realizada a actividade.
     *
     * @return Devolve um GregorianCalendar.
     */
    public GregorianCalendar getDate() {
        return (GregorianCalendar) this.date.clone();
    }

    /**
     * Método que devolve o tempo gasto na actividade em minutos.
     *
     * @return Devolve um double.
     */
    public double getTimeSpent() {
        return this.timeSpent;
    }

    /**
     * Método que devolve o numero de calorias gastos.
     *
     * @return Devolve um double.
     */
    public double getCalories() {
        return this.calories;
    }

    /**
     * Método para alterar o nome da actividade.
     *
     * @param name String para o novo nome.
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que define as calorias em função do tipo de actividade,do peso do utilizador e da tempo gasto na actividade.
     *
     * @param peso Peso do utilizador.
     */
    public abstract void setCalories(double peso);

    /**
     * Método que redefine as calorias da actividade
     *
     * @param calories Novo numero para as calorias.
     */
    public void setActivityCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a == null || this.getClass() != a.getClass()) {
            return false;
        }

        Activity act = (Activity) a;

        return (this.name.equals(act.getName())
                && this.date.equals(act.getDate())
                && this.timeSpent == act.getTimeSpent()
                && this.calories == act.getCalories());

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.date);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.timeSpent) ^ (Double.doubleToLongBits(this.timeSpent) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.calories) ^ (Double.doubleToLongBits(this.calories) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Descrição: ");
        sb.append(this.name).append("\n");
        sb.append("Data: ");
        sb.append(this.date.get(Calendar.DAY_OF_MONTH)).append(" / ");
        sb.append((this.date.get(Calendar.MONTH)) + 1).append(" / ");
        sb.append(this.date.get(Calendar.YEAR)).append("\n");
        sb.append("Duração: ");
        sb.append(this.timeSpent).append(" minutos \n");
        return sb.toString();
    }

    @Override
    public abstract Activity clone();
}

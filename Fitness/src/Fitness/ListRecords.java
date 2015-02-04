package Fitness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Classe que contem a lista de recordes.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class ListRecords implements Serializable {

    private final String name;            // nome do tipo (Cycling...)
    private ArrayList<Record> recs;

    /**
     * Construtor vazio.
     */
    public ListRecords() {
        this.name = "";
        this.recs = new ArrayList<>();
    }

    /**
     * Construtor parametrizado.
     *
     * @param name Tipo da actividade a qual a a ListRecords se refere.
     */
    public ListRecords(String name) {
        this.name = name;
        this.recs = new ArrayList<>();
    }

    /**
     * Construtor parametrizado.
     *
     * @param name -Tipo da actividade a qual a a ListRecords se refere.
     * @param recs - Set de Record
     */
    public ListRecords(String name, Set<Record> recs) {
        this.name = name;
        for (Record r : recs) {
            this.recs.add(r.clone());
        }
    }

    /**
     * Construtor de cópia.
     *
     * @param list instância de ListRecords.
     */
    public ListRecords(ListRecords list) {
        this.name = list.getName();
        this.recs = (ArrayList<Record>) list.getList();
    }

    /**
     * Método que devolve uma lista de Recordes.
     *
     * @return List de Record
     */
    public List<Record> getList() {
        ArrayList<Record> aux = new ArrayList<>();
        for (Record r : this.recs) {
            aux.add(r);
        }
        return aux;

    }

    /**
     * Método que devolve actualiza todos os recordes da classe.
     *
     * @param list instancia de ListRecords.
     */
    public void updateList(ListRecords list) {
        ArrayList<Record> array = (ArrayList<Record>) list.getList();
        int i = 0;
        for (Record r : this.recs) {
            r.update(array.get(i));
            i++;
        }
    }

    /**
     * Método que devolve o nome da classe.
     *
     * @return String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Método que adiciona um recorde a classe.
     *
     * @param rec Record.
     */
    public void addRecord(Record rec) {

        this.recs.add(rec);
    }

    //toString,equals,clone
    /**
     * Método que altera os recordes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do tipo da actividade: ").append(this.name).append("\n");
        for (Record r : this.recs) {
            sb.append((r.toString()));
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (o.getClass() != this.getClass())) {
            return false;
        }
        ListRecords list = (ListRecords) o;
        return (this.name.equals(list.getName())
                && this.recs.equals(list.getList()));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.recs);
        return hash;
    }

    @Override
    public ListRecords clone() {
        return new ListRecords(this);
    }

}

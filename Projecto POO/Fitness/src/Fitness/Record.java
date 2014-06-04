package Fitness;

import java.io.Serializable;

/**
 * Classe abstracta de recordes.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public abstract class Record implements Serializable {

    private String name;

    /**
     * Construtor vazio.
     */
    public Record() {
        this.name = "";
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome do Recorde.
     */
    public Record(String name) {
        this.name = name;
    }

    /**
     * Construtor de copia.
     *
     * @param stat - Instancia de Record
     */
    public Record(Record stat) {
        this.name = stat.getName();
    }

    /**
     * Método que devolve o nome do recorde.
     *
     * @return Nome, String.
     */
    public String getName() {
        return name;
    }

    /**
     * Método que verifica se o recorde existe.
     *
     * @return True para vazio, False caso contrario.
     */
    public abstract boolean isEmpty();

    /**
     * Método que atualiza o atual recorde caso o recorde dado seja melhor
     *
     * @param act - Objecto do tipo Record
     */
    public abstract void update(Record act);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Nome: ").append("\n");
        sb.append(this.name).append(":\n");
        return sb.toString();
    }

    @Override
    public abstract Record clone();

}

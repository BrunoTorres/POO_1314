package Fitness;

/**
 *
 * Interface de métodos relacionados com pontos(pontos próprios e pontos do adversário)
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 *
 */
public interface UserVs {

    /**
     * Método que devolve os pontos realizados.
     *
     * @return Devolve um inteiro.
     */
    int getMyScore();

    /**
     * Método que devolve os pontos realizados pelo adversário.
     *
     * @return Devolve um inteiro.
     */
    int getOpScore();

}

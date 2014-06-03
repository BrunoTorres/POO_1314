package Fitness;

/**
 *
 * Interface de metodos relacionados com actividades de distancia vertical.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 *
 */
public interface UserVs
{
 
    /**
     * Método que devolve os pontos realizados.
     * @return Devolve um inteiro.
     */
    int getMyScore(); 
    
    /**
     * Método que devolve os pontos realizados pelo adversário.
     * @return Devolve um inteiro.
     */
    int getOpScore();
        
}

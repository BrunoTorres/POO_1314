package Fitness;

/**
 *
 *  Interface de métodos relacionados com actividades de distancia.
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public interface Distance
{
  
    /**
     * Método que devolve a distancia realizada na actividade.
     * @return Devolve um inteiro.
     */
    double getDistance();

    /**
     * Método para alterar a distancia da actividade.
     * @param distance - distancia da actividade.
     */
    void setDistance(double distance);
    
}

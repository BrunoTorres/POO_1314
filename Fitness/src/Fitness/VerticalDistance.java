package Fitness;

/**
 * Interface de métodos relacionados com actividades de distancia vertical.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public interface VerticalDistance {

    /**
     * Método que devolve a distancia vertical realizada na actividade.
     *
     * @return Devolve um inteiro.
     */
    double getVerticalDistance();

    /**
     * Método para alterar a distancia vertical da actividade.
     *
     * @param verticaldistance Distancia percorrida verticalmente(altitude)
     */
    void setVerticalDistance(double verticaldistance);
}

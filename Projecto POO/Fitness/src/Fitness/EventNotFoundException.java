
package Fitness;

/**
 * Classe para as exceções de eventos não encotrados.
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class EventNotFoundException extends Exception {

	/**
	 * Creates a new instance of <code>EventNotFoundException</code> without detail message.
	 */
	public EventNotFoundException() {
	}

	/**
	 * Constructs an instance of <code>EventNotFoundException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public EventNotFoundException(String msg) {
		super(msg);
	}
}

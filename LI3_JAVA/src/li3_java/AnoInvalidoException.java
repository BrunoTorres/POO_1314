/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package li3_java;

/**
 *
 * @author jmano
 */
public class AnoInvalidoException extends Exception {

	/**
	 * Creates a new instance of <code>AnoInvalidoException</code> without detail message.
	 */
	public AnoInvalidoException() {
	}

	/**
	 * Constructs an instance of <code>AnoInvalidoException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public AnoInvalidoException(String msg) {
		super(msg);
	}
}

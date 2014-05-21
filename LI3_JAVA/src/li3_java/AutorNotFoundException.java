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
public class AutorNotFoundException extends Exception {

	/**
	 * Creates a new instance of <code>AutorNotFoundException</code> without detail message.
	 */
	public AutorNotFoundException() {
	}

	/**
	 * Constructs an instance of <code>AutorNotFoundException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public AutorNotFoundException(String msg) {
		super(msg);
	}
}

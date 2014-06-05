/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitness;

/**
 *
 * @author jmano
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

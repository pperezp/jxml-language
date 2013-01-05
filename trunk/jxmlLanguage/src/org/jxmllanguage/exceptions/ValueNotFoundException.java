/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jxmllanguage.exceptions;

/**
 *
 * @author pato
 */
public class ValueNotFoundException extends Exception {

    /**
     * Creates a new instance of
     * <code>ValueNotFoundException</code> without detail message.
     */
    public ValueNotFoundException() {
    }

    /**
     * Constructs an instance of
     * <code>ValueNotFoundException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ValueNotFoundException(String msg) {
        super(msg);
    }
}

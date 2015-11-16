/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaV3.exceptions;

/**
 *
 * @author cristiana
 */
public class IncorrectPasswordException extends RuntimeException{

    public IncorrectPasswordException() {
        super("Password non corretta");
    }

    public IncorrectPasswordException(String message) {
        super(message);
    }
    
}

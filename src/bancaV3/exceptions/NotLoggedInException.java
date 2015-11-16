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
public class NotLoggedInException extends RuntimeException{

    public NotLoggedInException() {
        super("You have to login");
    }

    public NotLoggedInException(String message) {
        super(message);
    }
    
}

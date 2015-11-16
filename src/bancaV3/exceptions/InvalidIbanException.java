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
public class InvalidIbanException extends RuntimeException{

    public InvalidIbanException() {
        super("iban not found");
    }
    
    public InvalidIbanException(String m) {
        super(m);
    }
}

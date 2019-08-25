/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.core;

/**
 *
 * @author alison
 */
public class BowlingGameException extends RuntimeException {

    public BowlingGameException() {
    }

    public BowlingGameException(String string) {
        super(string);
    }

    public BowlingGameException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public BowlingGameException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}

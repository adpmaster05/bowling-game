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
public class ExceedLimitException extends BowlingGameException {

    public ExceedLimitException() {
    }

    public ExceedLimitException(String string) {
        super(string);
    }

    public ExceedLimitException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ExceedLimitException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}

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
public class GameInCompletedException extends BowlingGameException {

    public GameInCompletedException() {
        this("Game is not completed yet.");
    }

    public GameInCompletedException(String string) {
        super(string);
    }

    public GameInCompletedException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GameInCompletedException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}

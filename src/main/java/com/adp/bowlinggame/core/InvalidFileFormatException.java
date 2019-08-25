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
public class InvalidFileFormatException extends BowlingGameException {

    public InvalidFileFormatException() {
        this("File format is not valid");
    }

    public InvalidFileFormatException(int line) {
        this("File format is not valid. Error in line# " + line);
    }

    public InvalidFileFormatException(String string) {
        super(string);
    }

    public InvalidFileFormatException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public InvalidFileFormatException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}

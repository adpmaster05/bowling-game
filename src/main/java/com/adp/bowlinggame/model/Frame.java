/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.model;

/**
 *
 * @author alison
 */
public interface Frame {
    Integer getNum();
    Integer getFirstRoll();
    void setFirstRoll(int firstRoll);
    Integer getSecondRoll();
    void setSecondRoll(int secondRoll);
    Integer getExtraRoll();
    void setExtraRoll(int secondRoll);
    Frame getNextFrame();
    void setNextFrame(Frame frame);
    Frame getPrevFrame();
    void setPrevFrame(Frame frame);
    boolean isLast();
    int getScore();
    
    default boolean isStrike() {
        if(getFirstRoll() == null) return false;
        return getFirstRoll() == 10;
    }
    default boolean isSpare() {
        if(getFirstRoll() == null || getSecondRoll() == null) return false;
        return getFirstRoll() + getSecondRoll() == 10;
    }
}

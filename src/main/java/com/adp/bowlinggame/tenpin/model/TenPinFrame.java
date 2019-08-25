/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.tenpin.model;

import com.adp.bowlinggame.core.ExceedLimitException;
import com.adp.bowlinggame.core.GameInCompletedException;
import com.adp.bowlinggame.model.Frame;

/**
 *
 * @author alison
 */
public class TenPinFrame implements Frame {

    private final int num;
    private Integer firstRoll;
    private Integer secondRoll;
    private Integer extraRoll;
    private Frame nextFrame;
    private Frame prevFrame;
    private int score;

    /**
     * Constructor to initialize with Frame #
     * @param num
     */
    public TenPinFrame(int num) {
        validateNumberOfFrames();
        this.num = num;
    }

    /**
     * Constructor to initialize with Frame # and firstRoll
     * @param num
     * @param firstRoll
     */
    public TenPinFrame(int num, int firstRoll) {
        validateNumberOfFrames();
        this.num = num;
        this.firstRoll = firstRoll;
    }

    @Override
    public Integer getNum() {
        return num;
    }

    @Override
    public Integer getFirstRoll() {
        return firstRoll;
    }

    @Override
    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    @Override
    public Integer getSecondRoll() {
        return secondRoll;
    }

    @Override
    public void setSecondRoll(int secondRoll) {
        if (!isLast() && !isStrike() && !isSpare()) {
            if ((getFirstRoll() + secondRoll) > 10) {
                throw new RuntimeException("Invalid file format");
            }
        }

        this.secondRoll = secondRoll;
    }

    @Override
    public Frame getNextFrame() {
        return nextFrame;
    }

    @Override
    public void setNextFrame(Frame frame) {
        this.nextFrame = frame;
    }

    @Override
    public Frame getPrevFrame() {
        return prevFrame;
    }

    @Override
    public void setPrevFrame(Frame frame) {
        this.prevFrame = frame;
    }

    @Override
    public Integer getExtraRoll() {
        return extraRoll;
    }

    @Override
    public void setExtraRoll(int extraRoll) {
        this.extraRoll = extraRoll;
    }

    /**
     *
     * @return true if the number of this Frame is equals to 10
     */
    @Override
    public boolean isLast() {
        return num == 10;
    }

    /**
     *
     * @return the calculated score of this Frame, if Game is not complete this method will throw GameIncompletedException
     */
    @Override
    public int getScore() {
        if (getFirstRoll() == null || getSecondRoll() == null) {
            throw new GameInCompletedException();
        }

        if (isLast()) {
            if (isStrike() || isSpare()) {
                
                if (getExtraRoll() == null) {
                    throw new GameInCompletedException("Missing Extra Roll. Game is not completed yet.");
                }
                
                score = getFirstRoll() + getSecondRoll() + getExtraRoll();
            } else {
                score = getFirstRoll() + getSecondRoll();
            }
        } else {
            if (getNextFrame() == null || getNextFrame().getFirstRoll() == null) {
                throw new GameInCompletedException();
            }
            if (isStrike()) {
                if (getNextFrame().isStrike()) {
                    if (getNextFrame().getNextFrame() != null) {
                        score = getFirstRoll() + getNextFrame().getFirstRoll() + getNextFrame().getNextFrame().getFirstRoll();
                    } else {
                        score = getFirstRoll() + getNextFrame().getFirstRoll() + getNextFrame().getSecondRoll();
                    }
                } else {
                    score = getFirstRoll() + getNextFrame().getFirstRoll() + getNextFrame().getSecondRoll();
                }
            } else if (isSpare()) {
                score = getFirstRoll() + getSecondRoll() + getNextFrame().getFirstRoll();
            } else {
                score = getFirstRoll() + getSecondRoll();
            }
        }

        return score;
    }

    private void validateNumberOfFrames() {
        if (num > 10) {
            throw new ExceedLimitException("Can't have more than 10 Frames for TenPinGame");
        }
    }

}

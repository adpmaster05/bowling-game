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
public final class PlayerEntry {
    private final Player player;
    private final Frame firstFrame;

    public PlayerEntry(Player player, Frame firstFrame) {
        this.player = player;
        this.firstFrame = firstFrame;
    }

    public Player getPlayer() {
        return player;
    }

    public Frame getFirstFrame() {
        return firstFrame;
    }
}

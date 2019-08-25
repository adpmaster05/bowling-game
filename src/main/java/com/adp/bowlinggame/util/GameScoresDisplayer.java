/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.util;

import com.adp.bowlinggame.model.Frame;
import com.adp.bowlinggame.model.Player;
import com.adp.bowlinggame.model.PlayerEntry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alison
 */
public class GameScoresDisplayer {

    /**
     * Print out the score of each player
     * @param entries
     */
    public static final void displayScores(List<PlayerEntry> entries) {

        for (PlayerEntry entry : entries) {
            System.out.println("\n\nPlayer: " + entry.getPlayer().getName());
            Frame f = entry.getFirstFrame();
            Player p = entry.getPlayer();
            
            System.out.print("Frame \t");
            for (int i = 1; i <= 10; i++) {
                System.out.printf("\t %s ", i);
            }

            List<Integer> scores = new ArrayList();
            System.out.print("\nPinfalls");
            
            do {
                System.out.printf("\t %s %s %s", f.getFirstRoll(), f.getSecondRoll(), f.getExtraRoll() != null ? f.getExtraRoll() : "");
                
                p.setScore(p.getScore() + f.getScore());
                scores.add(p.getScore());
                f = f.getNextFrame();
            } while (f != null);

            System.out.print("\nScore\t");
            for (Integer score : scores) {
                System.out.printf("\t %d", score);
            }
        }
    }
}

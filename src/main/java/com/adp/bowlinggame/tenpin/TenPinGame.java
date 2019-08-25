/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.tenpin;

import com.adp.bowlinggame.model.BowlingGame;
import com.adp.bowlinggame.model.Frame;
import com.adp.bowlinggame.model.Player;
import com.adp.bowlinggame.model.PlayerEntry;
import com.adp.bowlinggame.tenpin.util.parser.impl.TenPinParser;
import com.adp.bowlinggame.util.GameScoresDisplayer;
import com.adp.bowlinggame.util.LineSeparator;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author alison
 */
public final class TenPinGame implements BowlingGame {
    
    private final String file;
    private TenPinParser parser;

    public TenPinGame(String file) {
        this.file = file;
        
        if(!Files.exists(Paths.get(file))) {
            throw new RuntimeException("File does not exist");
        }
        
        parser = new TenPinParser(LineSeparator.TAB);
    }
    
    @Override
    public int getNumbersOfFrames() {
        return 10;
    }
    
    public void start() {
        List<PlayerEntry> entries = parser.parse(file);
        
        GameScoresDisplayer.displayScores(entries);
    }
    
}

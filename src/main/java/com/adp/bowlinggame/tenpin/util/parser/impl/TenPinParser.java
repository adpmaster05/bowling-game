/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.tenpin.util.parser.impl;

import com.adp.bowlinggame.core.InvalidFileFormatException;
import com.adp.bowlinggame.model.Frame;
import com.adp.bowlinggame.model.Player;
import com.adp.bowlinggame.model.PlayerEntry;
import com.adp.bowlinggame.tenpin.model.TenPinFrame;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import com.adp.bowlinggame.util.parser.FileParser;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alison
 */
public class TenPinParser implements FileParser {

    private final String separator;
    private int lineCounter = 0;
    private List<PlayerEntry> mappedResults = null;

    /**
     * Constructor to initialize with Line Separator
     * @param separator
     */
    public TenPinParser(String separator) {
        this.separator = separator;
    }

    /**
     * Parse Game file and throws InvalidFileFormatException is the file has not the valid format
     * @param s
     * @return List of PlayerEntry
     */
    @Override
    public List<PlayerEntry> parse(String s) {

        try (Stream<String> stream = Files.lines(Paths.get(s))) {

            Map<String, Frame> map = new HashMap();

            stream.forEach(line -> {

                lineCounter++;

                String[] splitted = getInputValues(line);
                String player = splitted[0];
                int score = parseInt(splitted[1]);

                if (map.containsKey(player)) {
                    Frame f = map.get(player);

                    if(f.isLast() && f.getExtraRoll() != null){
                        throw new InvalidFileFormatException(lineCounter);
                    }
                    else if (f.isLast() && (f.isStrike() || f.isSpare()) && f.getSecondRoll() != null) {
                        f.setExtraRoll(score);
                    } else if (f.getFirstRoll() == null) {
                        f.setFirstRoll(score);
                        if(f.isStrike()) {
                            if(!f.isLast()) {
                                f.setSecondRoll(0);
                                createNextFrame(f, map, player);
                            }
                        }
                    } else if (f.getSecondRoll() == null) {
                        f.setSecondRoll(score);
                        if (!f.isLast()) {
                            createNextFrame(f, map, player);
                        }
                    } else {
                        throw new InvalidFileFormatException(lineCounter);
                    }

                } else {
                    Frame f = new TenPinFrame(1, score);
                    map.put(player, f);

                    if (mappedResults == null) {
                        mappedResults = new ArrayList();
                    }

                    Player p = new Player(player);
                    mappedResults.add(new PlayerEntry(p, f));

                    if (f.isStrike()) {
                        f.setSecondRoll(0);
                        createNextFrame(f, map, player);
                    }
                    
                }
            });

        } catch(InvalidFileFormatException ex) {
            throw ex;
        } catch (IOException ex) {
            throw new FileSystemNotFoundException();
        } catch (Exception ex) {
            throw new InvalidFileFormatException();
        }

        return mappedResults;
    }

    private void createNextFrame(Frame f, Map<String, Frame> map, String player) {
        Frame next = new TenPinFrame(f.getNum() + 1);
        f.setNextFrame(next);
        map.put(player, next);
    }

    private static int parseInt(String score) throws NumberFormatException {
        return Integer.parseInt(score);
    }

    /**
     * Throws InvalidFileFormatException if file has not valid format
     * @param line
     * @return Array of String where position 0 is the name of the player and position 1 is the score of that Roll/Pinfall
     */
    public String[] getInputValues(String line) {
        String[] splitted = line.split(separator);
        String name = splitted[0];
        String score = null;

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidFileFormatException(lineCounter);
        }

        if (splitted[1] == null || splitted[1].trim().isEmpty()) {
            throw new InvalidFileFormatException(lineCounter);
        }

        else if ("10".equals(splitted[1])) {
            score = splitted[1];
        } else if (splitted[1].matches("[1-9]")) {
            score = splitted[1];
        } else if ("F".equalsIgnoreCase(splitted[1]) || "0".equalsIgnoreCase(splitted[1])) {
            score = "0";
            splitted[1] = score;
        }

        if (score == null) {
            throw new InvalidFileFormatException(lineCounter);
        }

        return splitted;
    }

}

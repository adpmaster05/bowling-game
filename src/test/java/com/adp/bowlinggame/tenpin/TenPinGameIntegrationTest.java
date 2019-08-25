/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.tenpin;

import com.adp.bowlinggame.core.InvalidFileFormatException;
import com.adp.bowlinggame.tenpin.util.parser.impl.TenPinParser;
import com.adp.bowlinggame.util.LineSeparator;
import com.adp.bowlinggame.util.parser.FileParser;
import java.nio.file.FileSystemNotFoundException;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author alison
 */
public class TenPinGameIntegrationTest {
    
    public TenPinGameIntegrationTest() {
    }
    
    @BeforeAll
    public static void setUp() {
    }
    
    @AfterAll
    public static void tearDown() {
    }
    
    @DisplayName("FileDoesNotExist")
    @Test
    public void fileDoesNotExist() {
        assertThrows(FileSystemNotFoundException.class, () -> {
            TenPinGame game = new TenPinGame("life.txt");
        }, "This will throw a FileSystemNotFoundException");
    }
    
    @DisplayName("FileExist")
    @Test
    public void fileExist() {
        TenPinGame game = new TenPinGame("invalid-format.txt");
    }
    
    /**
     * Test of parse method, of class TenPinParser.
     */
    @DisplayName("parseInvalidFile")
    @Test
    public void parseFramesWillThrowException() {
        FileParser parser = new TenPinParser(LineSeparator.TAB);
        
        assertThrows(InvalidFileFormatException.class, () -> {
            parser.parse("invalid-format.txt");
        }, "Should throw InvalidFileFormatException");
    }
    
    /**
     * Test of parse method, of class TenPinParser.
     */
    @DisplayName("parseValidFile")
    @Test
    public void parseValidFile() {
        FileParser parser = new TenPinParser(LineSeparator.TAB);
        
        parser.parse("perfect-game.txt");
    }
}
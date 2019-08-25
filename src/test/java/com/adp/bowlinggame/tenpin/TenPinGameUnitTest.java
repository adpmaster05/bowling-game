/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.tenpin;

import com.adp.bowlinggame.core.InvalidFileFormatException;
import com.adp.bowlinggame.tenpin.util.parser.impl.TenPinParser;
import com.adp.bowlinggame.util.LineSeparator;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author alison
 */
public class TenPinGameUnitTest {
    
    private TenPinParser parser;
    
    @DisplayName("TestOneValidFileLineScore10")
    @Test
    public void testOneValidFileLineScore10() {
        parser = new TenPinParser(LineSeparator.TAB);
        assertEquals(parser.getInputValues("Alison	10")[1], "10", () -> "Test for row-tab separated");
    }
    
    @DisplayName("TestOneValidFileLineScoreF")
    @Test
    public void testOneValidFileLineScoreF() {
        parser = new TenPinParser(LineSeparator.TAB);
        assertEquals(parser.getInputValues("Alison	F")[1], "0", () -> "Test for F value");
    }
    
    @DisplayName("TestOneInValidFileLineScore11")
    @Test
    public void testOneInValidFileLineScore11() {
        parser = new TenPinParser(LineSeparator.TAB);
        assertThrows(InvalidFileFormatException.class, () -> {
            parser.getInputValues("Alison	11");
        }, () -> "Throws InvalidFileFormatException");
    }
}

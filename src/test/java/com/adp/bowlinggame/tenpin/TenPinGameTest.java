/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame.tenpin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author alison
 */
public class TenPinGameTest {
    
    public TenPinGameTest() {
    }
    
    @BeforeAll
    public static void setUp() {
    }
    
    @AfterAll
    public static void tearDown() {
    }

    /**
     * Test of getNumbersOfFrames method, of class TenPinGame.
     */
    @DisplayName("GetNumberOfGame")
    @Test
    public void testGetNumbersOfFrames() {
    }

    /**
     * Test of start method, of class TenPinGame.
     */
    @DisplayName("StartTenPinGame")
    @Test
    public void testStart() {
        assertEquals("sdf" ,"eee", () -> "Testing will fail");
    }
    
    @DisplayName("FileDoesNotExist")
    @Test
    public void fileExist() {
    }
    
}

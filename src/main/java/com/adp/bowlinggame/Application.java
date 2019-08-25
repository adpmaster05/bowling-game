/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adp.bowlinggame;

import com.adp.bowlinggame.core.BowlingGameException;
import com.adp.bowlinggame.tenpin.TenPinGame;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

/**
 *
 * @author alison
 */
public class Application {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Insert a file path: ");
            String input = sc.next();

            TenPinGame tenPinGame = new TenPinGame(input);
            tenPinGame.start();
        } catch (BowlingGameException | FileSystemNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println("Something escaped me out, I'm so sorry");
            e.printStackTrace();
        }
    }
}

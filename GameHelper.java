package com.war;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (Exception e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];
        String temp = null;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1) {
            incr = gridLength;
        }
        while (!success & attempts++ < 200) {             // main search loop  (32)
            location = (int) (Math.random() * gridSize);      // get random starting point
            //System.out.print(" try " + location);
            int x = 0;                                        // nth position in dotcom to place
            success = true;                                 // assume success
            while (success && x < comSize) {                // look for adjacent unused spots
                if (grid[location] == 0) {                    // if not already used
                    coords[x++] = location;                    // save location
                    location += incr;                          // try 'next' adjacent
                    if (location >= gridSize) {                 // out of bounds - 'bottom'
                        success = false;                         // failure
                    }
                    if (x > 0 & (location % gridLength == 0)) {  // out of bounds - right edge
                        success = false;                         // failure
                    }
                } else {                                      // found already used location
                    // System.out.print(" used " + location);
                    success = false;                          // failure
                }
            }
        }                                                   // end while

        int x = 0;                                          // turn good location into alpha coords
        int row = 0;
        int column = 0;
        // System.out.println("\n");
        while (x < comSize) {
            grid[coords[x]] = 1;                              // mark master grid pts. as 'used'
            row = (int) (coords[x] / gridLength);             // get row value
            column = coords[x] % gridLength;                  // get numeric column value
            temp = String.valueOf(alphabet.charAt(column));   // convert to alpha

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;

            // System.out.print("  coord "+x+" = " + alphaCells.get(x-1));

        }
        // System.out.println("\n");
        return alphaCells;
    }
}

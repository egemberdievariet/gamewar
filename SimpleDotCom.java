package com.javarush.task.task17.task1708;

public class SimpleDotCom {
    int [] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs){
        locationCells = locs;
    }

    String checkYourself(String strinGuess) {
        int guess = Integer.parseInt(strinGuess);
        String result = "Mimo";

        for (int cell : locationCells){
            if (guess == cell){
                result = "Popal";
                numOfHits++;
                break;
            }
        }
        if (numOfHits == locationCells.length){
            result = "Potopil";
        }
        System.out.println(result);
        return result;


    }
}

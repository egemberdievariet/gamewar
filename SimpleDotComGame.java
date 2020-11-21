package com.javarush.task.task17.task1708;

/*
Заметки для всех
*/

import java.io.BufferedReader;

public class SimpleDotComGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        SimpleDotCom theDotCom = new SimpleDotCom();

        int random = (int) (Math.random() * 5);

        int[] locations = {random, random+1, random+2};

        theDotCom.setLocationCells(locations);

        boolean isAlive = true;

        while (isAlive == true){
            String guess = helper.getUserInput("Vvedite chislo");

            String result = theDotCom.checkYourself(guess);

            numOfGuesses++;

            if (result.equals("Potopil")){
                isAlive = false;
                System.out.println("Vam potrbovalos " +numOfGuesses+ " popytok" );
            }
        }
    }
}

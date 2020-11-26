package com.war;

/*
Заметки для всех
*/

import java.util.ArrayList;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");

        DotCom two = new DotCom();
        two.setName("Namba.kg");

        DotCom three = new DotCom();
        three.setName("Google.com");

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Vasha sel potopit tri sayta");
        System.out.println("Pets.com, Namba.kg, Google.kg");
        System.out.println("Popytaytes ih za minimalnoe kolichestvo hodov potopit");

        for (DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);

            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPaying(){
        while (!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Sdelayte hod");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;

        String result = "Mimo";

        for (DotCom dotComToSet : dotComsList){
            result = dotComToSet.checkYourself(userGuess);

            if (result.equals("Popal")){
                break;
            }
            if (result.equals("Potopil")){
                dotComsList.remove(dotComToSet);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("Vse sayti ushli ko dnu! Vashi aksii teper nechego ne stoyat");
        if (numOfGuesses <= 18){
            System.out.println("Eto zanyalo u vas bsego " + numOfGuesses + " popytok.");
        } else {
            System.out.println("Eto zanyalo u vas mnogo vremeni " + numOfGuesses + " popytok" );
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPaying();
//        game.finishGame();
    }

}

package com.war;

import java.util.ArrayList;

public class DotCom {
    private String name;
    private ArrayList<String> locationCells;
//    int [] locationCells;
//    int numOfHits = 0;

    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }

    public void setName(String names){
        name = names;

    }

    String checkYourself(String userInput) {
//        int guess = Integer.parseInt(strinGuess);
        String result = "Mimo";
        int index = locationCells.indexOf(userInput);
        if (index >= 0){
            locationCells.remove(index);

            if (locationCells.isEmpty()){
                result = "Potopil";
                System.out.println("Oy vy potopili " + name + " .");
            } else {
                result = "Popal";
            }

        }
        return result;
    }
}

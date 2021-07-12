package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static ArrayList<String> line1 = new ArrayList<>();

    public static void main(String[] args) {

        FillInitial();
            Opening();

    }

    public static void Opening(){
        Scanner player = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Do you want to be X or O?");
        String playersMark = player.nextLine();
        playersMark=playersMark.toUpperCase();

        Board();
        System.out.println(" You can go first.");
        Start(playersMark);
    }

    public static void Start(String playersMark){
        Scanner choice = new Scanner(System.in);
        System.out.println("What is your move? (1-9)");
        String playersChoice = choice.nextLine();
        ProcessChoice(playersChoice,playersMark);
    }

    public static void FillInitial(){
        line1.add(" ");
        line1.add("|");
        line1.add(" ");
        line1.add("|");
        line1.add(" ");
        line1.add(" ");
        line1.add("|");
        line1.add(" ");
        line1.add("|");
        line1.add(" ");
        line1.add(" ");
        line1.add("|");
        line1.add(" ");
        line1.add("|");
        line1.add(" ");
    }

    public static void Reset(){
            line1.set(0," ");
            line1.set(1,"|");
            line1.set(2," ");
            line1.set(3,"|");
            line1.set(4," ");
            line1.set(5," ");
            line1.set(6,"|");
            line1.set(7," ");
            line1.set(8,"|");
            line1.set(9," ");
            line1.set(10," ");
            line1.set(11,"|");
            line1.set(12," ");
            line1.set(13,"|");
            line1.set(14," ");
    }





    public static void Board(){

//        print board by looping through arrayList line1
        for (int i = 0; i < 15; i++){
            if(i == 5 ||i ==10){
                System.out.println();
                System.out.println("_______________");
                System.out.print(" "+line1.get(i));
            }else {
                System.out.print(" "+line1.get(i));
            }
        }
        System.out.println();
    }


    public static void ProcessChoice(String playersChoice,String playersMark){
        Scanner replay = new Scanner(System.in);

        boolean isEmptySpace = false;
        String computersMark;
        HashMap<String,Integer> choiceOnBoard = new HashMap<>();
        choiceOnBoard.put("1",0);
        choiceOnBoard.put("2",2);
        choiceOnBoard.put("3",4);
        choiceOnBoard.put("4",5);
        choiceOnBoard.put("5",7);
        choiceOnBoard.put("6",9);
        choiceOnBoard.put("7",10);
        choiceOnBoard.put("8",12);
        choiceOnBoard.put("9",14);
        if (playersMark.equals("X")){
            computersMark="O";
        }else{
            computersMark="X";
        }

        int index = choiceOnBoard.get(playersChoice);

        if(line1.get(index).equals(" ")==false){
            System.out.println("That position has already been taken");
            System.out.println();
            Start(playersMark);
        }

        else {

            line1.set(index, playersMark);

            if(WinnerCheck(playersMark)==false){



                if(line1.contains(" ")==true) {


                    String compuChoice = ComputerChoice(playersChoice);
                    int compuIndex = choiceOnBoard.get(compuChoice);

                    if (line1.get(compuIndex).equals(" ")) {
                        line1.set(compuIndex, computersMark);

                    } else {
                        while (isEmptySpace == false) {
                            int randomNum = (int) (Math.random() * (10 - 1)) + 1;
                            String compuRandom = String.valueOf(randomNum);
                            compuIndex = choiceOnBoard.get(compuRandom);

                            if (line1.get(compuIndex).equals(" ")) {

                                line1.set(compuIndex, "O");
                                isEmptySpace = true;
                            }

                        }
                    }

                    if (WinnerCheck(computersMark) == false) {

                        Board();
                        Start(playersMark);

                    } else {
                        Board();
                        System.out.println("Game over" + computersMark + "Wins!");
                        Reset();
                        System.out.println("Would you like to try again?");
                        System.out.println("Choose Y or N");
                        String playAgain = replay.nextLine();
                        if (playAgain.toUpperCase().equals("Y")) {
                            Opening();
                        }

                    }
                }else{
                    Board();
                    System.out.println("Game Over No Winner all spaces Filled");
                    Reset();
                    System.out.println("Would you like to try again?");
                    System.out.println("Choose Y or N");
                    String playAgain = replay.nextLine();
                    if(playAgain.toUpperCase().equals("Y")){
                        Opening();

                    }

                }
            }else{
                Board();
                System.out.println("Game over"+playersMark+"Wins!" );
                Reset();
                System.out.println("Would you like to try again?");
                System.out.println("Choose Y or N");
                String playAgain = replay.nextLine();
                if(playAgain.toUpperCase().equals("Y")) {
                    Opening();
                }
            }



        }

    }

    public static String ComputerChoice(String playersChoice){
        HashMap<String,String> computerBrain =new HashMap<>();
        computerBrain.put("1","9");
        computerBrain.put("2","8");
        computerBrain.put("3","7");
        computerBrain.put("4","5");
        computerBrain.put("5","6");
        computerBrain.put("6","5");
        computerBrain.put("7","3");
        computerBrain.put("8","2");
        computerBrain.put("9","1");

        String compuChoice= computerBrain.get(playersChoice);

        return compuChoice;

    }

    public static boolean WinnerCheck(String playersMark){
        boolean winner=false;
        if(line1.get(0).equals(playersMark) && line1.get(2).equals(playersMark)&&line1.get(4).equals(playersMark)){
            winner=true;
        }else if(line1.get(5)
                .equals(playersMark) && line1.get(7).equals(playersMark)&&line1.get(9).equals(playersMark)){
            winner=true;
        }else  if(line1.get(10).equals(playersMark) && line1.get(12).equals(playersMark)&&line1.get(14).equals(playersMark)){
            winner = true;

        }else  if(line1.get(0).equals(playersMark) && line1.get(5).equals(playersMark)&&line1.get(10).equals(playersMark)){
            winner=true;
        }else if(line1.get(2).equals(playersMark) && line1.get(7).equals(playersMark)&&line1.get(12).equals(playersMark)){
            winner=true;
        }else  if(line1.get(4).equals(playersMark) && line1.get(9).equals(playersMark)&&line1.get(14).equals(playersMark)){
            winner = true;

        }else  if(line1.get(0).equals(playersMark) && line1.get(7).equals(playersMark)&&line1.get(14).equals(playersMark)){
            winner=true;
        }else if(line1.get(4).equals(playersMark) && line1.get(7).equals(playersMark)&&line1.get(10).equals(playersMark)){
            winner=true;
        }
        else{
            winner = false;
        }
        return winner;
    }
}

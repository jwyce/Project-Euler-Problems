package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Problem_084 {

    static String monopolyOdds() {
        String modelString = "";
        int[] gameBoard = simulateGames(10000000, 4);
        int[] sortedProbs = gameBoard.clone();
        Arrays.sort(sortedProbs);
        
        for (int i = gameBoard.length-1; i >= 0; i--) {
            modelString += String.format("%02d", indexOf(gameBoard, sortedProbs[i]));
        }
        
        return modelString.substring(0, 6);
    }
    
    private static int indexOf(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }
    
    private static int[] simulateGames(int numRolls, int diceSides) {
        Random rand = new Random();
        int[] board = new int[40];
        board[0] = 1;
        int position = 0;
        int doublesCount = 0;
        Integer[] communityChest = { 0, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        Integer[] chance = { 0, 10, 11, 24, 39, 5, -3, -2, -2, -4, -1, -1, -1, -1, -1, -1 }; // -2 = next R; -4 = next U
        ArrayList<Integer> cc = new ArrayList<Integer>(Arrays.asList(communityChest));
        ArrayList<Integer> ch = new ArrayList<Integer>(Arrays.asList(chance));
        Collections.shuffle(cc);
        Collections.shuffle(ch);
        
        for (int i = 0; i < numRolls; i++) {
            int dice1 = rand.nextInt(diceSides)+1, dice2 = rand.nextInt(diceSides)+1;
            if (dice1 == dice2) doublesCount++;
            else doublesCount = 0;
            if (doublesCount == 3) {
                // go to jail
                position = 10;
                doublesCount = 0;
            } else {
                int roll = dice1 + dice2;
                position = (position + roll) % board.length;
            }
            if (position == 30) position = 10;
            board[position]++;
            
            
            if (position == 2 || position == 17 || position == 33) { // community chest
                int draw = cc.get(0);
                cc.remove(0);
                if (draw != -1) {
                    position = draw;
                    board[position]++;
                }
                cc.add(draw);
            } else if (position == 7 || position == 22 || position == 36) { // chance
                int draw = ch.get(0);
                ch.remove(0);
                if (draw >= 0) {
                    position = draw;
                } else {
                    switch (draw) {
                    case -3:
                        position -= 3;  // go back 3 spaces
                        break;
                    case -2:
                        // next rail road
                        int[] r = { 5, 15, 25, 35 };
                        for (int j = 0; j < r.length; j++) {
                            if (position % 35 < r[j]) {
                                position = r[j];
                                break;
                            }
                        }
                        break;
                    case -4:
                        // next utility
                        if (position < 12 || position >= 28) position = 12;
                        else position = 28;
                        break;
                    }
                }
                if (draw != -1) board[position]++;
                ch.add(draw);
            }
        }
        
        return board;
    }
}

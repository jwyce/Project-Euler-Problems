package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem_054 {

    static int countPlayerOneWins() {
        int count = 0;

        for (String hand : getHands()) {
            String player1 = hand.substring(0, 14);
            String player2 = hand.substring(15, 29);
            if (getRank(player1) > getRank(player2)) count++;
        }
        
        return count;
    }
    
    /* a rank is an integer representing the "goodness" of a particular hand
     * base rank:
     * high card - 00000000
     * one pair - 10000000
     * two pair - 20000000
     * three of a kind - 30000000
     * straight - 40000000
     * flush - 50000000
     * full house - 60000000
     * four of a kind - 70000000
     * straight flush - 80000000
     * royal flush - 90000000
     * first high card adds 10000 * val
     * second high card adds 1000 * val
     * third high card adds 100 * val
     * fourth high card adds 10 * val
     * fifth high card adds val
     */
    private static long getRank(String hand) {
        long rank = 0;
        String match = null, match2 = null;
        String flush = "H,S,D,C";
        String cards = "2,3,4,5,6,7,8,9,T,J,Q,K,A";
        
        if (matches(flush, hand, 5) != null) { 
            if (hand.replaceAll("[TJQKA]", "").length() == hand.length() - 5) {
                //System.out.print("Royal Flush");
                rank = 90000000;
            } else if (isStraight(hand)) {
                //System.out.print("Straight Flush");
                rank = 80000000;
            } else { 
                //System.out.print("Flush");
                rank = 50000000;
            }
        } else if ((match = matches(cards, hand, 4)) != null) {  
            //System.out.print("4 of a Kind");
            rank = 70000000 + (100000*getCardValue(match));
        } else if ((match = matches(cards, hand, 3)) != null && 
                (match2 = matches(cards.replace(match, ""), hand, 2)) != null) {          
            //System.out.print("Full House");
            rank = 60000000 + (100000*getCardValue(match) + (1000*getCardValue(match2)));
        } else if (isStraight(hand)) {
            //System.out.print("Straight");
            rank = 40000000;
        } else if ((match = matches(cards, hand, 3)) != null) {     
            //System.out.print("3 of a Kind");
            rank = 30000000 + (100000*getCardValue(match));
        } else if ((match = matches(cards, hand, 2)) != null && 
                (match2 = matches(cards.replace(match, ""), hand, 2)) != null) {      
            //System.out.print("2 pair");
            rank = 20000000 + (100000*getCardValue(match) + (100000*getCardValue(match2)));        
        } else if ((match = matches(cards, hand, 2)) != null) {
            //System.out.print("1 pair");
            rank = 10000000 + (100000*getCardValue(match));
        } else {
            //System.out.print("high card");
        }
        
        String[] handAr = hand.split(" ");
        Arrays.sort(handAr, (a, b) -> getCardValue(a.substring(0,1)) - getCardValue(b.substring(0,1)));
        for (int i = 0; i < handAr.length; i++) {
            rank += Math.pow(10, i)*getCardValue(handAr[i].substring(0, 1));
        }
        
        //System.out.println(": " + rank);
        return rank;
    }
    
    /* regexes are comma separated
     * returns regex that matched or null
     */
    private static String matches(String regexes, String str, int numMatches) {
        String[] regexAr = regexes.split(",");
        for (int i = 0; i < regexAr.length; i++) {
            if (str.replaceAll(regexAr[i], "").length() == str.length() - numMatches)
                return regexAr[i];
        }
        return null;
    }
    
    private static boolean isStraight(String hand) {
        String[] handAr = hand.split(" ");
        Arrays.sort(handAr, (a, b) -> getCardValue(a.substring(0,1)) - getCardValue(b.substring(0,1)));
        String order = "23456789TJQKA";
        String possibleStraight = Arrays.toString(handAr).replaceAll("[\\[HSCD\\], ]", ""); 
        return order.replace(possibleStraight, "").length() == order.length() - 5;
    }
    
    private static int getCardValue(String card) {
        switch (card) {
        case "2":
        case "3":
        case "4":
        case "5":
        case "6":
        case "7":
        case "8":
        case "9":
            return Integer.parseInt(card);
        case "T":
            return 10;
        case "J":
            return 11;
        case "Q":
            return 12;
        case "K":
            return 13;
        case "A":
            return 14;
        default:
            return 0;
        }
    }
    
    private static ArrayList<String> getHands() {
        ArrayList<String> hands = new ArrayList<String>(1000);
        String hand = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("p054_poker.txt")))) {
            while((hand = reader.readLine()) != null) {
                hands.add(hand);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return hands;
    }
}

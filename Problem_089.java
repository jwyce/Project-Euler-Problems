package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem_089 {

    static int charactersSaved() {
        ArrayList<String> romanNums = getRomanNumerals("p089_roman.txt");
        int savedCount = 0;
        
        for (String num : romanNums) {
            int n = romanToInt(num);
            String minNumeral = intToRoman(n);
            int charsSaved = num.length() - minNumeral.length();
            savedCount += charsSaved;
        }
        
        return savedCount;
    }
    
    private static String intToRoman(int num) {
        String romanNum = "";
        HashMap<Integer, Character> romanNums = new HashMap<Integer, Character>();
        romanNums.put(1000, 'M');
        romanNums.put(500, 'D');
        romanNums.put(100, 'C');
        romanNums.put(50, 'L');
        romanNums.put(10, 'X');
        romanNums.put(5, 'V');
        romanNums.put(1, 'I');
        
        for(int p = 3; p >= 0; p--) {
            
            if (num < 4000) {
                if(num - (num % Math.pow(10, p)) == 5 * Math.pow(10, p) - Math.pow(10, p)) {
                    num -= (int) (5 * Math.pow(10, p) - Math.pow(10, p));
                    romanNum += romanNums.get((int) Math.pow(10, p));
                    romanNum += romanNums.get((int) (5 * Math.pow(10, p)));
                }
                
                if(num - (num % Math.pow(10, p)) == Math.pow(10, p + 1) - Math.pow(10, p)) {
                    num -= (int) (Math.pow(10, p + 1) - Math.pow(10, p));
                    romanNum += romanNums.get((int) Math.pow(10, p));
                    romanNum += romanNums.get((int) Math.pow(10, p + 1));
                }
                
                while(num - 5 * Math.pow(10, p) >= 0) {
                    num -= 5 * Math.pow(10, p);
                    romanNum += romanNums.get(5 * (int) Math.pow(10, p));
                }
            }
            
            while(num - Math.pow(10, p) >= 0) {
                num -= Math.pow(10, p);
                romanNum += romanNums.get((int) Math.pow(10, p));
            }
        }
        
        return romanNum;
    }
    
    private static int romanToInt(String s) {
        s = s.toUpperCase();
        int arabicNum = 0;
        HashMap<Character, Integer> romanNums = new HashMap<Character, Integer>();
        romanNums.put('M', 1000);
        romanNums.put('D', 500);
        romanNums.put('C', 100);
        romanNums.put('L', 50);
        romanNums.put('X', 10);
        romanNums.put('V', 5);
        romanNums.put('I', 1);
        
        for(int i = 0; i < s.length(); i++) {
            if(i != s.length() - 1 && romanNums.get(s.charAt(i)) < romanNums.get(s.charAt(i + 1))) {
                arabicNum -= romanNums.get(s.charAt(i));
            } else {
                arabicNum += romanNums.get(s.charAt(i));
            }
        }
        
        return arabicNum;
    }
    
    private static ArrayList<String> getRomanNumerals(String fileName) {
        ArrayList<String> romanNumerals = new ArrayList<String>();
        String line = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            while ((line = reader.readLine()) != null) {
                romanNumerals.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return romanNumerals;
    }
}

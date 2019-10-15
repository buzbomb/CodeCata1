package com.and.test;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    /**
     * The following is the method where the solution shall be written
     */

    public static String solution(String input) throws NumberFormatException {
        char[] theParts = input.toCharArray();
        ArrayList<Integer> theInts = new ArrayList<>();
        ArrayList<String> theCombinations = new ArrayList<>();
        ArrayList<Integer> theCombinationsAsInts = new ArrayList<>();
        String suffix = "", prefix = "";
        int i = 1;

        //Pull the integers out of input string to create suffix from said integers
        for(char part : theParts){
            try{
                int tempDigit = Integer.parseInt(Character.toString(part));
                theInts.add(tempDigit);
            } catch (NumberFormatException e){
                if(i == theParts.length && theInts.isEmpty()){
                    e.printStackTrace();
                }
            }
            i++;
        }

        for(int tempDigit : theInts){
            suffix = suffix + tempDigit;
        }

        //Create combinations from suffix and add them to theCombinations
        Solution.permutations(prefix, suffix, theCombinations);

        //Convert the Strings in theCombinations to ints and add them to theCombinationsAsInt
        for(String tempCombination : theCombinations){
            int tempCombinationAsInt = Integer.parseInt(tempCombination);
            theCombinationsAsInts.add(tempCombinationAsInt);
        }
        //Sort theCombinationsAsInt into descending order
        Collections.sort(theCombinationsAsInts, Collections.reverseOrder());

        System.out.println(theCombinationsAsInts);
        return theCombinationsAsInts.toString();
    }

    private static void permutations(String prefix, String suffix, ArrayList<String> theCombinations){
        if(suffix.length() == 0){
            theCombinations.add(prefix);
        } else {
            for(int x = 0; x < suffix.length(); x++){
                permutations(prefix + suffix.charAt(x), suffix.substring(0, x) + suffix.substring(x+1), theCombinations);
            }
        }
    }

    public static void main(String args[]) {
        solution("A 2B 9C5");
    }

}

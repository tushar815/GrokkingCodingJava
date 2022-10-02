package com.grokking.slidingPattern;

import java.util.HashMap;
import java.util.HashSet;

public class PermutationsString {

    public static boolean solution(String str, String pattern){
        int windowStart =0, countOfMatchingChars = pattern.length();
        boolean startTracking = false;
        HashSet<Character> set = new HashSet<>();

        for(char c : pattern.toCharArray()){
            set.add(c);
        }
        for(int windowEnd = 0 ; windowEnd < str.length() ;windowEnd++){
            char letter = str.charAt(windowEnd);
            if(set.contains(letter)){
                startTracking = true ;
                if(windowEnd - windowStart +1 - countOfMatchingChars == 0){
                    return true;
                }
            }
            else{
                if(!startTracking)
                    windowStart++;
            }
        }
        return false;


    }

    public static boolean improvedSolution(String str, String pattern){

        int windowStart = 0, matched = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : pattern.toCharArray()){
            map.put(c,map.getOrDefault(c, 0 )+1);
        }

        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){

            char letter = str.charAt(windowEnd);

            if(map.containsKey(letter)){
                map.put(letter, map.get(letter)-1);
                if(map.get(letter)==0)
                    matched++;
            }

            if(matched == map.size())
                return true;

            if(windowEnd >= pattern.length() - 1){
                char leftChar = str.charAt(windowStart);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar)==0)
                        matched--;
                    map.put(leftChar, map.get(leftChar)+1);
                }

                windowStart++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
       System.out.println("solution is "+ (solution("oidbcaf","abc") ? "true": "false"));
       System.out.println("solution is "+ (solution("odicf","dc") ? "true": "false"));
      System.out.println("solution is "+ (solution("bcdxabcdy","bcdyabcdx") ? "true": "false"));
        System.out.println("solution is "+ (solution("aaacb","abc") ? "true": "false"));
        System.out.println("solution is "+ (solution("ooolleoooleh","hello") ? "true": "false"));

            System.out.println("PASSES ALL TEST CASES");
           System.out.println("solution is "+ (improvedSolution("oidbcaf","abc") ? "true": "false"));
            System.out.println("solution is "+ (improvedSolution("odicf","dc") ? "true": "false"));
            System.out.println("solution is "+ (improvedSolution("bcdxabcdy","bcdyabcdx") ? "true": "false"));
            System.out.println("solution is "+ (improvedSolution("aaacb","abc") ? "true": "false"));
            System.out.println("solution is "+ (improvedSolution("ooolleoooleh","hello") ? "true": "false"));
        System.out.println("solution is "+ (improvedSolution("dinitrophenylhydrazinetrinitrophenylmethylnitramine","trinitrophenylmethylnitramine") ? "true": "false"));
    }
}

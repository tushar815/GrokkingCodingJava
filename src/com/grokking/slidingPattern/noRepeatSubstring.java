package com.grokking.slidingPattern;

import java.util.HashMap;
import java.util.HashSet;

public class noRepeatSubstring {

    public  int sol(String str){
        int maxLength = 0, windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int windowEnd = 0 ;windowEnd < str.length() ; windowEnd++){

            char letter = str.charAt(windowEnd);

            if(map.containsKey(letter)){
                //check notion for this line
                windowStart = Math.max(windowStart, map.get(letter)+ 1);

            }else{
                map.put(letter,windowEnd);
                maxLength = Math.max(maxLength, windowEnd -windowStart + 1);
            }
        }


        return maxLength;

    }

    public static void main(String[] args) {
        noRepeatSubstring n = new noRepeatSubstring();
   System.out.println(n.sol("aabccb"));
        System.out.println(n.sol("abbbb"));
        System.out.println(n.sol("abccde"));
        System.out.println(n.sol("pwwkew"));
    }
}

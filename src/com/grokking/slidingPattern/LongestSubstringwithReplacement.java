package com.grokking.slidingPattern;

import java.util.HashMap;

public class LongestSubstringwithReplacement {

    public int solution(String str, int K) {
        int windowStart = 0, maxLength = 0, maxRepeatingCharCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int windowEnd= 0; windowEnd< str.length(); windowEnd++){

            char letter= str.charAt(windowEnd);
            map.put(letter, map.getOrDefault(letter,0)+1);
            maxRepeatingCharCount = Math.max(maxRepeatingCharCount, map.get(letter));

            if(windowEnd - windowStart + 1  - maxRepeatingCharCount > K){
                char leftLetter = str.charAt(windowStart);
                map.put(leftLetter,map.get(leftLetter)-1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd-windowStart +1);
        }

return maxLength;

    }


    public static void main(String[] args) {
        LongestSubstringwithReplacement l = new LongestSubstringwithReplacement();
        System.out.println("solution is" + l.solution("aabccbb", 2));
        System.out.println("solution is" + l.solution("abbcb", 1));
        System.out.println("solution is" + l.solution("abccde", 1));
        System.out.println("solution is " + l.solution("AABABBA", 1));



    }
}
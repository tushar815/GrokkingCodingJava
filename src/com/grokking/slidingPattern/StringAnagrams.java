package com.grokking.slidingPattern;

import java.util.HashMap;

public class StringAnagrams {

    public static void solution(String str, String pattern){
        int windowStart = 0, matched = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : pattern.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int windowEnd=0; windowEnd< str.length(); windowEnd++){

            char letter = str.charAt(windowEnd);

            if(map.containsKey(letter)){
                map.put(letter, map.get(letter)-1);
                if(map.get(letter)== 0){
                    matched++;
                }
            }

            if(matched == map.size()){
                System.out.print(windowStart+", ");
            }


            if(windowEnd>= pattern.length() - 1){
                char firstLetter = str.charAt(windowStart);
                if(map.containsKey(firstLetter)){
                    if(map.get(firstLetter)== 0){
                        matched--;
                    }
                    map.put(firstLetter,map.get(firstLetter)+1);
                }
                windowStart++;
            }




        }


    }

    public static void main(String[] args) {
       // solution("ppqp","pq");
        solution("abbcabc","abc");
    }

}

package com.grokking.slidingPattern;

import java.util.HashMap;

public class longestSubStringInarray {


    public int solution(String str, int K) {
        //variable to track current window length,max length, and start of window
        int currentMaxLength = 0, currentWindowLength = 0, windowStart = 0;
        //hashMap to track letters and their count
        HashMap<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            Character currentLetter = str.charAt(windowEnd);
            currentWindowLength++;
            if (map.containsKey(currentLetter)) {
                map.put(currentLetter, map.get(currentLetter) + 1);
            }
            map.putIfAbsent(currentLetter, 1);

            if (map.size() <= K) {
                    // find the current max
                currentMaxLength = Math.max(currentWindowLength, currentMaxLength);

            } else {
                /*
                 loop while size is greater than k and
                 last condition is to skip additional calls when we reach end of string
                 for example  for string  araaci we are looping for letter i which is at end
                 so even if we remove elements from front of window we will get length smaller than currentMax.

                 */
                while (map.size() > K && (windowEnd + windowStart) < str.length()) {
                    Character firstLetterOfWindow = str.charAt(windowStart);
                    if (map.containsKey(firstLetterOfWindow)) {
                        if (map.get(firstLetterOfWindow) == 1) {
                            map.remove(firstLetterOfWindow);
                        } else {
                            map.put(firstLetterOfWindow, map.get(firstLetterOfWindow) - 1);
                        }
                    }
                    currentWindowLength--;
                    windowStart++;
                }
            }
        }
      return currentMaxLength;
    }

    public int improvedSolution(String str, int K) {
        //variable to track ,max length, and start of window
        int currentMaxLength = 0, windowStart = 0;
        //hashMap to track letters and their count
        HashMap<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            Character currentLetter = str.charAt(windowEnd);
            map.put(currentLetter, map.getOrDefault(currentLetter,0) + 1);

            while (map.size() > K){
                Character firstLetterOfWindow = str.charAt(windowStart);
                map.put(firstLetterOfWindow, map.get(firstLetterOfWindow)-1);
                if(map.get(firstLetterOfWindow)==0){
                    map.remove(firstLetterOfWindow);
                }
                windowStart++;
            }
            currentMaxLength = Math.max(windowEnd - windowStart + 1, currentMaxLength);


        }
        return currentMaxLength;
    }

    public static void main(String[] args) {
        longestSubStringInarray s = new longestSubStringInarray();
       System.out.println("solution is "+ s.solution("araaci",2));
        System.out.println("solution is "+ s.solution("araaci",1));
        System.out.println("solution is "+ s.solution("cbbebi",3));

        System.out.println("solution is "+ s.improvedSolution("araaci",2));
        System.out.println("solution is "+ s.improvedSolution("araaci",1));
        System.out.println("solution is "+ s.improvedSolution("cbbebi",3));
    }


}
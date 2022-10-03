package grokking.slidingPattern;

import java.util.HashMap;

public class smallestWindowSubstring {

    public static String sol(String str, String pattern){
        int windowStart = 0, matched=0, minLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> mapOfPattern = new HashMap<>();
        for(char c : pattern.toCharArray()){
            mapOfPattern.put(c, mapOfPattern.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> mapOfStrValuesPosition = new HashMap<>();

        for(int windowEnd = 0; windowEnd< str.length(); windowEnd++){

            char c = str.charAt(windowEnd);

            mapOfStrValuesPosition.put(c, windowEnd);

            if (mapOfPattern.containsKey(c)) {
                mapOfPattern.put(c, mapOfPattern.get(c)-1);
                if(mapOfPattern.get(c)== 0){
                    matched++;
                }
                if(mapOfPattern.get(c)< 0 ){
                    mapOfPattern.put(c, 0);
                    windowStart = Math.max(windowStart, mapOfStrValuesPosition.get(c));
                }

            }
            if(matched == mapOfPattern.size()){
                if((windowEnd - windowStart + 1) > minLength)
                     minLength = Math.max(minLength,windowStart);
            }


        }

        return minLength!=Integer.MIN_VALUE ? str.substring(minLength) : "";

    }

        public static String correctSolution(String str, String pattern){

        int windowStart =0, minLength =str.length()+1, matched = 0,substrStart = 0;

        HashMap<Character,Integer>map = new HashMap<>();

            for(char c : pattern.toCharArray()){
                map.put(c, map.getOrDefault(c,0)+1);
            }

        for(int windowEnd = 0; windowEnd< str.length();windowEnd++){

            char letter = str.charAt(windowEnd);

            if(map.containsKey(letter)){
                map.put(letter,map.get(letter)-1);

                if(map.get(letter)>=0){
                    matched++;
                }
            }

            while (matched == pattern.length()){
                if(minLength > windowEnd-windowStart +1){
                    minLength =windowEnd-windowStart +1;
                    substrStart = windowStart;
                }

                char firstLetter = str.charAt(windowStart);
                if(map.containsKey(firstLetter)){
                    if(map.get(firstLetter)== 0)
                        matched--;
                    map.put(firstLetter, map.get(firstLetter)+1);
                }
                windowStart++;
            }


        }
return minLength > str.length() ? "": str.substring(substrStart,substrStart+minLength);
        }


    public static void main(String[] args) {
  /* System.out.println("sol is "+ sol("aabdec","abc"));
       System.out.println("sol is "+ sol("adcad","abc"));
       System.out.println("sol is "+ sol("abdabca","abc"));
       System.out.println("sol is "+ sol("ADOBECODEBANC","ABC"));
        System.out.println("sol is "+ sol("a","aa"));
        System.out.println("sol is "+ sol("ab","a"));
*/
        System.out.println(" Correct solution ");

        System.out.println("sol is "+ correctSolution("aabdec","abc"));
        System.out.println("sol is "+ correctSolution("adcad","abc"));
        System.out.println("sol is "+ correctSolution("abdabca","abc"));
        System.out.println("sol is "+ correctSolution("ADOBECODEBANC","ABC"));
        System.out.println("sol is "+ correctSolution("a","aa"));
        System.out.println("sol is "+ correctSolution("ab","a"));

    }
}

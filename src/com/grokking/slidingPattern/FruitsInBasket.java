package com.grokking.slidingPattern;

import java.util.HashMap;

public class FruitsInBasket {

    public int sol(char[] array){

        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int windowEnd = 0; windowEnd < array.length ;windowEnd++){

            char letter =array[windowEnd];
            map.put(letter, map.getOrDefault(letter, 0)+1);
            while (map.size() > 2){
                map.put(array[windowStart], map.get(array[windowStart])-1);
                if(map.get(array[windowStart]) == 0){
                    map.remove(array[windowStart]);

                }

                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }


return maxLength;


    }

    public static void main(String[] args) {

        FruitsInBasket f = new FruitsInBasket();
    System.out.println(f.sol(new char[]{'A', 'B', 'C', 'A', 'C'}));
    }
}




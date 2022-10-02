package com.grokking.slidingPattern;

public class LongestSubArrayReplacement {

    public static int solution(int[] array, int K){
        int windowStart =0, maxLength = 0, countOfZeros = 0;

        for(int windowEnd = 0; windowEnd < array.length; windowEnd++){

            int number = array[windowEnd];
            if(number == 0)
                countOfZeros++;

            while (countOfZeros > K){
                int leftNumber = array[windowStart];
                if(leftNumber == 0)
                    countOfZeros--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart +1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("solution is"+solution(new int[] {0,1,1,0,0,0,1,1,0,1,1},2));
        System.out.println("solution is"+solution(new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1},3));



    }



}

package com.grokking.slidingPattern;

public class smallestSubArrayOfGivenSum {


    public int solution(int S, int[] array){

        //variables to track the start of the window , minimum sum of window and current sum of window
        int windowStart = 0, minimumWindowSum = Integer.MAX_VALUE , currentSumOfWindow = 0;

        for(int windowEnd = 0; windowEnd < array.length; windowEnd++){
            //keep adding to the window
            currentSumOfWindow += array[windowEnd];

            // loop while sum = S
            while(currentSumOfWindow >= S){
                // compare the size of window and minimum size found.
                minimumWindowSum = Math.min(minimumWindowSum, (windowEnd - windowStart)+1);
                //remove the element from front of window
                currentSumOfWindow -= array[windowStart];
                //increment size of window.
                windowStart++;

            }
        }
        //case for 0
    return minimumWindowSum != Integer.MAX_VALUE ? minimumWindowSum : 0;

    }


    public static void main(String[] args) {
        smallestSubArrayOfGivenSum s = new smallestSubArrayOfGivenSum();
        System.out.println("smallest SubArray of given sum is " + s.solution(7, new int[] {2, 1, 5, 2, 3, 2}));
        System.out.println("smallest SubArray of given sum is " + s.solution(7, new int[] {2, 1, 5, 2, 8}));
        System.out.println("smallest SubArray of given sum is " + s.solution(8, new int[] {3, 4, 1, 1, 6}));
        System.out.println("smallest SubArray of given sum is " + s.solution(100, new int[] {3, 4, 1, 1, 6}));
    }
}

package com.grokking.slidingPattern;

public class MaximumSumSubArray {

    public int getMaximumSumSubArraySlidingPattern(int[] array, int K){
        //variables to store current sum of window and current max sum found.
        int currentSumOfWindow =0, currentMaxSum = 0;
        //variable for window to maintain front element of window
        int windowStart = 0;
        for(int windowEnd = 0 ; windowEnd < array.length; windowEnd++){
                //add element to window
            currentSumOfWindow += array[windowEnd];
                // if window size is reached then save the sum and remove the element from front.
            if(windowEnd >= K -1 ){
                currentMaxSum = Math.max(currentSumOfWindow, currentMaxSum);
                currentSumOfWindow -= array[windowStart];
                windowStart++;
            }
        }
        return currentMaxSum;
    }

    public static void main(String[] args) {
        MaximumSumSubArray s = new MaximumSumSubArray();
        System.out.println("The Maximum sum of subarray of size K is ="+ s.getMaximumSumSubArraySlidingPattern(new int[]{2, 1, 5, 1, 3, 2}, 3));
        System.out.println("The Maximum sum of subarray of size K is ="+ s.getMaximumSumSubArraySlidingPattern(new int[]{2, 3, 4, 1, 5, 2},2));
    }
}

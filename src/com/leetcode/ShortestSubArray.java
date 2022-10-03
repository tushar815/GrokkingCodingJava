package com.leetcode;
/*
https://www.lintcode.com/problem/1611/?_from=problem_tag&fromId=435
 */
public class ShortestSubArray {

    public static int solution(int[] nums, int k){

            int windowStart = 0, minLength = Integer.MAX_VALUE, currentSum =0;

            for(int windowEnd=0;windowEnd<nums.length;windowEnd++){

                    currentSum += nums[windowEnd];

                    while(currentSum >= k){
                        minLength = Math.min(minLength, windowEnd-windowStart +1);
                        currentSum-=nums[windowStart];
                        windowStart++;
                    }



            }

return minLength!=Integer.MAX_VALUE ? minLength : -1;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 1, 2, 4, 3},7));
        System.out.println(solution(new int[]{1,1,1,1,1,1,1,1},5));

    }
}

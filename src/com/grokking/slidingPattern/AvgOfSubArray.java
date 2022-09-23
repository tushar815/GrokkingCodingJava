package com.grokking.slidingPattern;

import java.util.Arrays;

public class AvgOfSubArray {


    public double[] find_avg_of_sub_array_brute_force(int K, int[] array){
    double[] result = new double[array.length - K + 1];

    for(int i=0 ; i <= array.length - K; i++){
        double sum = 0.0;

        for(int j= i; j < i +K ; j++){
            sum+=array[j];
        }
        result[i] = sum / K;
    }
return  result;
    }

    public double[] find_avg_of_sub_array_pattern(int K, int[] array){
        double result[] = new double[array.length - K +1];
        int windowStart = 0;
        double windowSum = 0;

        for(int windowEnd = 0; windowEnd < array.length ; windowEnd++){
            windowSum += array[windowEnd];

            if(windowEnd > K - 1){
                result[windowStart]= windowSum / 7;
                windowSum -= array[windowStart];
                windowStart++;
            }
        }
    return  result;
    }

    public static void main(String[] args) {

        AvgOfSubArray s = new AvgOfSubArray();
        System.out.println("The average of subarray of size K is ="+ Arrays.toString(s.find_avg_of_sub_array_brute_force(3, new int[]{2, 1, 5, 1, 3, 2})));
        System.out.println("The average of subarray of size K is ="+ Arrays.toString(s.find_avg_of_sub_array_pattern(2, new int[]{2, 3, 4, 1, 5, 2})));
    }
    }


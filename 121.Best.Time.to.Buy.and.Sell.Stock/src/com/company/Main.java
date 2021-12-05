package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxProfit(arr));;
    }

    public static int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
            profit = Math.max(profit, prices[i] - minSoFar);
        }
        return profit;
    }
}

package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfTwo(1));
        System.out.println(s.isPowerOfTwo(16));
        System.out.println(s.isPowerOfTwo(23));
        System.out.println(s.isPowerOfTwo(2147483646));
        System.out.println(s.isPowerOfTwo(-16));
        System.out.println(s.isPowerOfTwo(-2147483648));

        System.out.println("..........");

        System.out.println(s.isPowerOfTwoV2(1));
        System.out.println(s.isPowerOfTwoV2(16));
        System.out.println(s.isPowerOfTwoV2(23));
        System.out.println(s.isPowerOfTwoV2(2147483646));
        System.out.println(s.isPowerOfTwoV2(-16));
        System.out.println(s.isPowerOfTwoV2(-2147483648));

    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        long temp = 2;
        while (temp < n) {
            temp = temp * 2;
        }
        if (temp == n) {
            return true;
        }
        return false;
    }

    // read about bit manipulation method here: https://stackoverflow.com/a/32385656
    public boolean isPowerOfTwoV2(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}
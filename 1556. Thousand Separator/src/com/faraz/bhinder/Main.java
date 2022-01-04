package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.thousandSeparator(987));
        System.out.println(solution.thousandSeparator(1234));
    }
}

class Solution {
    public String thousandSeparator(int n) {
        String numString = String.valueOf(n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = numString.length()-1, j = 0; i >=0 ; i--) {
            if (j % 3 == 0) {
                stringBuilder.append(".");
            }
            stringBuilder.append(numString.charAt(i));
            j = (j + 1) % 3;
        }
        return stringBuilder.reverse().toString().substring(0,stringBuilder.length()-1);
    }
}
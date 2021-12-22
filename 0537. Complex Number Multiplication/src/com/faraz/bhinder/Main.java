package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(s.complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(s.complexNumberMultiply("1+-1i", "0+0i"));
    }
}

class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] num1splitted = num1.split("\\+", 2);
        num1splitted[1] = num1splitted[1].substring(0, num1splitted[1].length()-1);
        String[] num2splitted = num2.split("\\+", 2);
        num2splitted[1] = num2splitted[1].substring(0, num2splitted[1].length()-1);

        String real = String.valueOf(Integer.valueOf(num1splitted[0]) * Integer.valueOf(num2splitted[0]) - Integer.valueOf(num1splitted[1]) * Integer.valueOf(num2splitted[1]));
        String imag = String.valueOf(Integer.valueOf(num1splitted[0]) * Integer.valueOf(num2splitted[1]) + Integer.valueOf(num1splitted[1]) * Integer.valueOf(num2splitted[0]));

        return real + "+" + imag + "i";
    }
}
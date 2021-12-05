package com.company;

public class Main {

    public static void main(String[] args) {
//        int a = myAtoi("   -42");
//        System.out.println(a);
        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("0032 "));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi(""));
//        System.out.println(myAtoi("3.14159"));
//        System.out.println(myAtoi("+1"));
//        System.out.println(myAtoi("+-12"));
//        System.out.println(myAtoi("21474836460"));
//        System.out.println(myAtoi("00000-42a1234"));
//        System.out.println(myAtoi("20000000000000000000"));
//        System.out.println(myAtoi("-91283472332"));
//        System.out.println(myAtoi("  0000000000012345678"));
//        System.out.println(myAtoi("21474836460"));
//        System.out.println(myAtoi("  +  413"));

    }

    public static int myAtoi(String s) {
        boolean startingSpacesSkipped = false;
        boolean encounteredDigits = false;
        boolean encounteredSign = false;
        int sign = +1;
        int startingIdx = s.length();
        int endingIdx = -1;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ' && startingSpacesSkipped == false && encounteredSign == false){
                continue;
            }
            if (s.charAt(i) == '-' && encounteredSign == false){
                sign = sign * -1;
                encounteredSign = true;
                continue;
            }
            else if (s.charAt(i) == '+' && encounteredSign == false){
                encounteredSign = true;
                continue;
            } else if (encounteredSign == true && !Character.isDigit(s.charAt(i)) && encounteredDigits == false) {
                return 0;
            }
            if (Character.isDigit(s.charAt(i))){
                startingSpacesSkipped = true;
                encounteredSign = true;
                encounteredDigits = true;
                if(i < startingIdx){
                    startingIdx = i;
                }
                if(i > endingIdx){
                    endingIdx = i;
                }
            }
            else{
                break;
            }
        }
        for (int i = startingIdx; i <= endingIdx; i++) {
            if (s.charAt(i) == '0') {
                startingIdx = startingIdx + 1;
            } else {
                break;
            }
        }

        long number = 0;
        if (startingIdx > endingIdx ) {
            return 0;
        } else if (endingIdx - startingIdx <= 9) {

            int ten = 10;
            int power = 0;
            int temp = 0;
            for (int i = endingIdx; i>= startingIdx; i--) {
                if(Character.isDigit(s.charAt(i))) {
                    temp = Character.getNumericValue(s.charAt(i));
                    number = number + temp * (long) Math.pow(ten, power);
                    power = power + 1;
                }
            }
            number =  number * sign;
        } else {
            if (sign == +1){
                return Integer.MAX_VALUE;
            }
            else {
                return Integer.MIN_VALUE;
            }
        }

        if(number < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(number > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int) number;
    }
}

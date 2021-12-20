package com.faraz.bhinder;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("((({[]})))"));
    }
}

class Solution {

    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        int processedCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                processedCount = processedCount + 1;
            } else if(stack.size() > 0 && ((s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == '}' && stack.peek() == '{') || (s.charAt(i) == ']' && stack.peek() == '['))) {
                stack.pop();
                processedCount = processedCount + 1;
            }
        }
        if (stack.size() == 0 && processedCount == s.length()) {
            stack.clear();
            return true;
        } else {
            stack.clear();
            return false;
        }
    }
}
package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> elems = new HashSet<Integer>();
        for (int num : nums) {
            if (elems.contains(num)){
                return true;
            }
            elems.add(num);
        }
        return false;
    }
}

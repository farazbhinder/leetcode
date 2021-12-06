package com.faraz.bhinder;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        runTests();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int mCount = m;
        while (i < mCount && j < n) {
            if (nums1[i] <= nums2[j]) {
                i = i + 1;
            } else {
                // move all elements of nums1 arr from idx i+1 one place to right
                for (int k = nums1.length-1; k > i ; k--) {
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                i = i + 1;
                j = j + 1;
                mCount = mCount + 1; // also increase this as we have shifted elems in nums1[] one to the right
            }
        }
        // as we have exhausted nums1 arr, we now just add on nums2 arr after that
        if (j < n) {
            for (int k = j; k < n; k++) {
                nums1[nums1.length - n + k] = nums2[k];
            }
        }
    }

    private static void runTests() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println();

        nums1 = new int[]{4,0,0,0,0,0};
        m = 1;
        nums2 = new int[]{1,2,3,5,6};
        n = 5;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println();

        nums1 = new int[]{4,5,6,0,0,0};
        m = 3;
        nums2 = new int[]{1,2,3};
        n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println();


        nums1 = new int[]{1,2,4,5,6,0};
        m = 5;
        nums2 = new int[]{3};
        n = 1;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ", ");
        }
        System.out.println();
    }
}

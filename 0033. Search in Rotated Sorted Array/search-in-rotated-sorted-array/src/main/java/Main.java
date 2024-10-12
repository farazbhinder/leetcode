public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(s.search(arr, 6));

        int[] arr2 = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(s.search(arr2, 0));

        int[] arr3 = new int[] {4,5,6,7,0,1,2};
        System.out.println(s.search(arr3, 3));
    }
}

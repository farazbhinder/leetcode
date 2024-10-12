public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] arr = new int[] {1,2,3,4};
        int[] sums = s.runningSum(arr);
        for (int i = 0; i < sums.length; i++) {
            System.out.println(sums[i]);
        }
    }
}

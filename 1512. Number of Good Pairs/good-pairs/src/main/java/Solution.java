import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numIdenticalPairsCombination(int[] nums) {
        /**
         * i<j condition in question means it is asking for unique pairs
         * we can use nCk (n choose k) nC2 in this case to get the unique pairs frequency counts of digits and sum it all
         * nC2 is simplified to (n * (n-1)) /2
         */
        AtomicInteger count = new AtomicInteger();
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countsMap.put(nums[i], countsMap.getOrDefault(nums[i], 0) + 1);
        }
        countsMap.forEach((key, val) -> {
            count.addAndGet(val * (val - 1) / 2);
        });
        return count.get();
    }
}

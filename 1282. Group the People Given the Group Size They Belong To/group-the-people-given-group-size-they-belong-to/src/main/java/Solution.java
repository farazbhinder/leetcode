import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int i;
        for (i = 0; i < groupSizes.length; i++) {
            map.put(groupSizes[i], map.getOrDefault(groupSizes[i], new ArrayList<>()));
            map.get(groupSizes[i]).add(i);

            if (map.get(groupSizes[i]) != null && map.get(groupSizes[i]).size() == groupSizes[i]) {
                result.add(map.get(groupSizes[i]));
                map.remove(groupSizes[i]);
            }
        }
        return result;
    }
}
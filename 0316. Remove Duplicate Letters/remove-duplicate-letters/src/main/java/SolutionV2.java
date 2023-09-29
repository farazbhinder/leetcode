import java.util.HashMap;
import java.util.Map;

/**
 * idea from: https://www.youtube.com/watch?v=rU5p0MRm5zU&ab_channel=codestorywithMIK
 */
public class SolutionV2 {

    public static String removeDuplicateLetters(String s) {

        Map<Character, Integer> lastIdx = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIdx.put(s.charAt(i), i);
        }

        String result = "";
        Map<Character, Boolean> visited = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            boolean canAdd = true;
            if (result == "" || (result.length() > 0 && s.charAt(i) > result.charAt(result.length() - 1))) {
                if (!visited.getOrDefault(s.charAt(i), false)) {
                    result = result + s.charAt(i);
                    visited.put(s.charAt(i), true);
                }
            } else if (s.charAt(i) < result.charAt(result.length() - 1) && !visited.getOrDefault(s.charAt(i), false)) {
                for (int j = result.length() - 1; j >= 0; j--) {
                    if (lastIdx.get(result.charAt(j)) < i) {
                        // cannot remove this from res, as it doesn't comes later
                        if (!visited.getOrDefault(s.charAt(i), false)) {
                            result = result + s.charAt(i);
                            visited.put(s.charAt(i), true);
                        }
                        canAdd = false;
                        break;
                    } else if (result.charAt(j) < s.charAt(i)) {
                        if (!visited.getOrDefault(s.charAt(i), false)) {
                            result = result + s.charAt(i);
                            visited.put(s.charAt(i), true);
                            canAdd = false;
                            break;
                        }
                    }
                    else {
                        visited.put(result.charAt(j), false);
                        result = result.substring(0, j);
                    }
                }
                if (canAdd) {
                    if (!visited.getOrDefault(s.charAt(i), false)) {
                        result = result + s.charAt(i);
                        visited.put(s.charAt(i), true);
                    }
                }
            }
        }

        return result;
    }
}

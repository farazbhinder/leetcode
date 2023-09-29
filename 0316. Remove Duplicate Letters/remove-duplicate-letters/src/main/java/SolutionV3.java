
// optimized
public class SolutionV3 {

    public static String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] lastIdxs = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastIdxs[s.charAt(i) - 'a'] = i;
        }

        String result = "";
        for (int i = 0; i < s.length(); i++) {

            int j = result.length();

            while (result.length() > 0 && result.charAt(j-1) > s.charAt(i) && lastIdxs[result.charAt(j-1) - 'a'] > i && visited[s.charAt(i) - 'a'] == false) {
                visited[result.charAt(j-1) - 'a'] = false;
                result = result.substring(0, j-1);
                j = j - 1;
            }
            if (visited[s.charAt(i) - 'a'] == false) {
                result = result + s.charAt(i);
                visited[s.charAt(i) - 'a'] = true;
            }
        }

        return result;
    }
}

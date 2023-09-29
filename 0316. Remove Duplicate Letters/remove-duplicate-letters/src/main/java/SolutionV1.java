import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * uses recursion
 * time limit exceeds for longer strings...
 */
public class SolutionV1 {

    public static String removeDuplicateLetters(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            uniqueChars.add(s.charAt(i));
        }
        Set<String> results = new HashSet<>();
        fun("", s, uniqueChars.size(), results);
        List<String> resultsList = results.stream().collect(Collectors.toList());
        resultsList.sort(String::compareTo);
        int a = 10;
        return resultsList.get(0);
    }

    public static void fun(String first, String second, int maxLength, Set<String> results) {
        for (int i = 0; i < second.length(); i++) {
            String newFirst = first + second.charAt(i);
            String newSecond = second.substring(i+1);
            if (newFirst.length() == maxLength && uniqueChars(newFirst) == maxLength) {
                results.add(newFirst);
            }
            if (uniqueChars(newFirst) != newFirst.length()) {
                continue;
            }
            fun(newFirst, newSecond, maxLength, results);
        }
    }

    public static int uniqueChars(String str) {

        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            unique.add(str.charAt(i));
        }
        return unique.size();
    }
}

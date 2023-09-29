import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % 10);
            x = x / 10;
        }

        int i = 0;
        int j = digits.size() - 1;
        while (i < j) {
            if (digits.get(i) != digits.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

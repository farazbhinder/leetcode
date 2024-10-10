public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return rle(countAndSay(n-1));
        }
    }

    private String rle(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char pick = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == pick) {
                count = count + 1;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(pick);
                count = 1;
                pick = str.charAt(i);
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(pick);
        return stringBuilder.toString();
    }
}

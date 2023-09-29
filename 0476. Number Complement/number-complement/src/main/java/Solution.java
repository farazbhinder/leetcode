public class Solution {

    public int findComplement(int num) {

        String binaryStr = Integer.toBinaryString(num);
        int length = binaryStr.length();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (binaryStr.charAt(i) == '1') {
                stringBuilder.append('0');
            } else {
                stringBuilder.append('1');
            }
        }

        int result = 0;
        String complement = stringBuilder.toString();
        for (int i = 0; i < complement.length(); i++) {
            if (complement.charAt(i) == '1') {
                result = result + (int) Math.pow(2, length-i-1);
            }
        }

        return result;
    }
}

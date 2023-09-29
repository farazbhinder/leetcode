class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int i = 0;
        int pow = 0;
        while (i <= n) {
            i = (int) Math.pow(2, pow);
            pow = pow + 1;
        }
        return i - 1 - n;
    }
}
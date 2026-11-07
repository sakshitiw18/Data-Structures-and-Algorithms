
class Solution {
    public int bitwiseComplement(int n) {

        if (n == 0) {
            return 1;
        }

        int mask = 0;
        int temp = n;

        // Create a mask of all 1s
        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp = temp >> 1;
        }

        // XOR flips all bits
        return n ^ mask;
    }
}


class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert to long to avoid integer overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        // Determine the sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long result = 0;

        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Find the largest doubled divisor
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract and add to quotient
            a -= temp;
            result += multiple;
        }

        if (negative) {
            result = -result;
        }

        return (int) result;
    }
}

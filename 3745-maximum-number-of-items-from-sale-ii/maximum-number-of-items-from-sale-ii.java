import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        int[] total = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            total[i] = freq[i];

            for (int j = i * 2; j <= n; j += i) {
                total[i] += freq[j];
            }
        }

        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long answer = 0;
        long remaining = budget;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            if ((long) price >= 2L * minPrice) {
                break;
            }

            int freeItems = total[factor] - 1;

            if (freeItems <= 0) {
                continue;
            }

            long buy = Math.min(freeItems, remaining / price);

            answer += buy * 2;
            remaining -= buy * price;
        }

        answer += remaining / minPrice;

        return (int) answer;
    }
}
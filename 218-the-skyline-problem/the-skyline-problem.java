
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> ans = new ArrayList<>();

        // Store all building start and end points
        List<int[]> points = new ArrayList<>();

        for (int[] b : buildings) {
            points.add(new int[]{b[0], -b[2]});
            points.add(new int[]{b[1], b[2]});
        }

        // Sort by x-coordinate
        // For same x, process taller buildings first
        Collections.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Max heap: stores building heights
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        pq.add(0);

        int prevHeight = 0;

        for (int[] p : points) {

            int x = p[0];
            int h = p[1];

            if (h < 0) {
                // Building starts
                pq.add(-h);
            } else {
                // Building ends
                pq.remove(h);
            }

            int currHeight = pq.peek();

            // Height changed
            if (currHeight != prevHeight) {

                ans.add(Arrays.asList(x, currHeight));

                prevHeight = currHeight;
            }
        }

        return ans;
    }
}

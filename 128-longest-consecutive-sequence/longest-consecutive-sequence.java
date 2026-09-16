class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int ans =0;
        for(int n : set)
        if(!set.contains(n-1)){
            int x =n ;
            while(set.contains(x)) x++;
            ans = Math.max(ans,x -n);
        }

        
        return ans;
    }
}
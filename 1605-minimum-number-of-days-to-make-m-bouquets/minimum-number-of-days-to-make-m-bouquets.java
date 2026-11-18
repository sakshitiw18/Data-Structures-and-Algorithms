class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         if((long) m*k > bloomDay.length){
            return -1;
         }
         int low = Integer.MAX_VALUE;
         int high = Integer.MIN_VALUE;

         for(int i = 0 ; i< bloomDay.length ; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
            }
            int ans = -1;

            while(low <= high){
                int mid = low + (high - low)/2;

                int count = 0;
                int bouquets = 0;

                for(int i = 0; i< bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    count++;

                    if(count == k){
                        bouquets++;
                        count =0;
                }
                }
                else{
                    count = 0;
                }
                }
                if(bouquets >= m){
                    ans = mid;
                    high = mid -1;
                }
                else{
                    low = mid +1;
                }
            }
         
         return ans;

        
    }
}
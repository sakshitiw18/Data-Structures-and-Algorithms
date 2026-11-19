class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high= 0;

        for(int i = 0 ; i< weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        int ans = high;

        while(low <= high){
            int mid = low + (high - low)/2;
            int requiredDays= 1;
            int currentWeight = 0;
           for(int i= 0; i< weights.length ; i++ ){
            if(currentWeight + weights[i] <= mid){
                currentWeight += weights[i];

            }
            else{
                requiredDays ++;
                currentWeight = weights[i];
            }
            }
            if(requiredDays <= days){
                ans = mid ;
                high = mid -1;
            }
            else{
                low = mid +1;
            }


        }
        return ans ;
        
    }
}
class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;

        for(int i = 0; i< nums.length ; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        int ans = high;

        while(low <= high){
            int mid = low + (high - low)/2;
            int subArrays =1;
            int currentSum = 0;

            for(int i = 0 ; i< nums.length ; i++){
                if(currentSum+ nums[i] <= mid){
                    currentSum += nums[i];
                }
                else{
                    subArrays++;
                    currentSum = nums[i];
                }
            }
            if(subArrays <= k){
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
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0 ;
        int high = nums.length -1;

        while(low <high){
            int mid = low + (high - low)/2;

            if(mid %2 == 1){
                mid--;         // to make mid even
            }
            if(nums[mid] == nums[mid+1]){
                low = mid +2;
            }
            else{
                high = mid; //present on left side
            }
        }
        return nums[low];
    }
}
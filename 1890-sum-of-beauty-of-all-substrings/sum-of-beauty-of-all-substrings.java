class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int total = 0 ;

        for(int i = 0 ; i< n ; i++){  //start index of substring
            int[] freq = new int[26];

            for(int j = i ; j< n; j++){ //end index of substring
                freq[s.charAt(j) - 'a']++;

                int maxFreq= 0;
                int minFreq =Integer.MAX_VALUE; //intially smallest value int value(21..)

                for(int  k = 0 ; k < 26 ; k++){
                    if(freq[k]> 0){
                        maxFreq = Math.max(maxFreq , freq[k]);
                        minFreq = Math.min(minFreq , freq[k]);
                    }
                }
                total += maxFreq - minFreq;
            }
        }
        return total;
        
    }
}
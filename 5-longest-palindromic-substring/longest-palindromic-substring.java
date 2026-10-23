class Solution {
    public String longestPalindrome(String s) {
        int start = 0 ;
        int max = 0 ;

        for(int i = 0 ; i< s.length() ; i++){
            for(int j = 0 ; j< 2 ; j++){
                int l = i;
                int r = i+j;
            
            while(l>= 0 && r< s.length() && s.charAt(l)== s.charAt(r)){
                l--;
                r++;
            }
            if(r-l-1> max){
                start = l+1;
                max= r-l-1;
            }
        }
        }
        return s.substring(start,start+max);
        
    }
}
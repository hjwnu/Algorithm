class Solution {
   public static int[] solution(int brown, int yellow){
        int total = brown+yellow;
        int[] ans = new int[2];
        
       for(int i = total-1; i >0; i--){
            if(total%i==0&& total/i >= i){
                    ans[0] = total / i;
                    ans[1] = i;
                if(yellow==(ans[0]-2)*(ans[1]-2)) {break;}
            }
        }
         return ans;
    }
}
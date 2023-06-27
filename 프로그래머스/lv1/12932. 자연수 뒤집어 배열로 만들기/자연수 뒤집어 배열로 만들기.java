import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] ans = new int[String.valueOf(n).length()];
        for(int i =0 ; i <ans.length;i++){
            ans[i] = (int)(n%10); n /=10;
        }
        return ans;
    }
}
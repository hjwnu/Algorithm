import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if(n>s) { return new int[]{-1};}
        
        int[] ans = new int[n];
        int idx =0;
        while(n>0){
            int ele = s/n;
            ans[idx++] = ele;
            s -= ele; n--;
        }
        
        Arrays.sort(ans);
        return ans;
    }
}
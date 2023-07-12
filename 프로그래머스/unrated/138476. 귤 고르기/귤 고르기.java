import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int max = Integer.MIN_VALUE;
        for(int i : tangerine){ max = Math.max(max,i);}
        int[] tang = new int[max+1];
        for(int i =0; i < tangerine.length;i++){
            tang[tangerine[i]]++;
        }
        Arrays.sort(tang);
        
        int cnt=0; int temp=0;
        for(int i = tang.length-1;i >=1;i--){
            if(tang[i]>=k){cnt =1; break;}
            else{ temp += tang[i]; cnt++;}
            
            if(temp>=k){break;}
        }
        return cnt;
    }
}
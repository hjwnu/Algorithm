import java.util.*;
class Solution {

    public static int[] solution(int[] prices) {
        List<Integer> ansLi = new ArrayList<>();
        int[] ans = new int[prices.length];
        int cnt = 0;
        int idx =0;
        // 작아지는 순간 리스트 추가 후 다음꺼 진행 
        for(int i= 1; i < prices.length;i++){
            int stand = prices[idx];
            cnt++;
            if(stand>prices[i]){ansLi.add(cnt);  cnt=0; idx++; i = idx;}
            if(i==prices.length-1){ansLi.add(cnt); cnt=0; idx++; i = idx;}
        }
        
        //List To Array
        for(int i =0 ; i < ansLi.size();i++){
            ans[i] = ansLi.get(i);
        }
        
        return ans;
    }
}
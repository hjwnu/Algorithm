import java.util.*;
class Solution {

    public static int[] solution(int[] prices) {
        List<Integer> ansLi = new ArrayList<>();
        int[] ans = new int[prices.length];
        int cnt = 0;
        int idx =0;
        // 작아지는 순간 리스트 추가 후 다음꺼 진행 
        for(int i= 1; i < prices.length;i++){
            cnt++;
            if(prices[idx]>prices[i]){ansLi.add(cnt);  cnt=0; idx++; i = idx;}
            if(i==prices.length-1){ansLi.add(cnt); cnt=0; idx++; i = idx;}
        }
        
        //List To Array
        for(int i =0 ; i < ansLi.size();i++){
            ans[i] = ansLi.get(i);
        }
        
        return ans;
    }
    // 나중에 참고...
     // int[] ans = new int[prices.length];
     //    for (int i = 0; i < prices.length; i++) {
     //        for (int j = i + 1; j < prices.length; j++) {
     //            answer[i]++;
     //            if (prices[i] > prices[j])
     //                break;
     //        }
     //    }
     //    return ans;
}
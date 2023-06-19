package Programmers.lv2;

import java.util.*;

public class StockPrice {
    public static void main(String[] args) {
    int[] a  = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution(a)));
    }
    public static int[] solution(int[] prices) {
        List<Integer> ansLi = new ArrayList<>();
        int[] ans = new int[prices.length];
        int cnt = 0;
        int idx =0;
        for(int i= 1; i < prices.length;i++){
            int stand = prices[idx];
            cnt++;
            if(stand>prices[i]){ansLi.add(cnt);  cnt=0; idx++; i = idx;}
            if(i==prices.length-1){ansLi.add(cnt); cnt=0; idx++; i = idx;}
        }
        for(int i =0 ; i < ansLi.size();i++){
            ans[i] = ansLi.get(i);
        }
        return ans;
    }
}

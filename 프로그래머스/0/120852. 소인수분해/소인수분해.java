import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(n%i==0){
                ans.add(i);
                while(n % i == 0) n /= i;
            }
        }
        int[] answer = new int[ans.size()];
        for(int i = 0 ; i < ans.size(); i++){
           answer[i] = ans.get(i); 
        }
        return answer;
    }
}
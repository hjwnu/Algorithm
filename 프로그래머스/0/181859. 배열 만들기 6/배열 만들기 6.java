import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(stk.isEmpty()){
                stk.add(arr[i]); continue;
            }
            if(arr[i] == stk.get(stk.size()-1)){
                stk.remove(stk.size()-1);
            } else {
                stk.add(arr[i]);
            }
        }
        
        if (stk.isEmpty()) return new int[]{-1};
        int[] answer = new int[stk.size()];
        for(int i = 0; i < stk.size();i++){
            answer[i] = stk.get(i);
        }
        return answer;
    }
}
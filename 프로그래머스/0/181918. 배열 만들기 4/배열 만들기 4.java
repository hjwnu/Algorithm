import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        for(int i = 0; i < arr.length;i++){
            if(stk.isEmpty()){
                stk.add(arr[i]); continue;
            }
            
            if(stk.getLast() < arr[i]){
                stk.add(arr[i]);
            } else{
                stk.pollLast();
                i--;
            }
        }
        int[] answer = new int[stk.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = stk.pollFirst();
        }
        return answer;
    }
}
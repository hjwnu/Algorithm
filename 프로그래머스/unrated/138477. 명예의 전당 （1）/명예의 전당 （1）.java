import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        if(k>score.length){
            int[] answer = new int[score.length];
            int min =2000;
            for(int i=0; i < score.length;i++){
                min = Math.min(min,score[i]);
                answer[i] = min;
            }
        return answer;
        }
       PriorityQueue<Integer> hallOfFame = new PriorityQueue<>();
        int[] ans = new int[score.length];
        for(int i =0; i < k; i++){
            hallOfFame.add(score[i]);
            ans[i] = hallOfFame.peek();
        }
        for(int i =k; i < score.length;i++){
            if(score[i]>=hallOfFame.peek()) {
                hallOfFame.add(score[i]); hallOfFame.poll();}
            ans[i] = hallOfFame.peek();
        }
        return ans;
    }
}
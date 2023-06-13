package Programmers.lv1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HallOfFame {
    public static void main(String[] args) {
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(solution(10,score)));

    }

    public static int[] solution(int k, int[] score) {
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

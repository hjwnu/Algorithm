import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        //제곱이 최소화돼야하므로, 남은 작업량 중 Max값을 찾아 줄여야 함.
        Queue<Integer> prior = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : works){prior.add(i);}
        
        long answer = 0;
        while(n>0&&prior.peek()!=0){
            prior.add(prior.poll()-1);
            n--;
        }
        for(int i : prior){
            answer += i*i;
        }
        return answer;
    }
}
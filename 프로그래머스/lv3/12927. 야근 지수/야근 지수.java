import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
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
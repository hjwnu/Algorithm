import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int i : scoville){
            q.add(i);
        }
        int cnt=0;
        while(q.peek()<K){
            q.add(q.poll()+q.poll()*2); cnt++;
            
            if(q.size()<=1){break;}
        }
        return q.peek()<K? -1:cnt;
    }
}
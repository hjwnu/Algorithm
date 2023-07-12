import java.util.*;
class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 =0;
        Queue<Integer> q1 = new LinkedList<>(); for(int i : queue1){ q1.add(i); sum1 += i;}
        Queue<Integer> q2 = new LinkedList<>(); for(int i : queue2){ q2.add(i); sum2 += i;}
        
        if((sum1+sum2)%2==1){return -1;}
        
        int cnt=0;
        while(sum1!=sum2){ //합이 큰쪽에서 작은쪽으로 하나씩 보내면서 계산
            cnt++;
            if(sum1>sum2){
                int poll = q1.poll();
                sum1 -= poll; sum2 += poll;
                q2.add(poll);
            }
            else{
                int poll = q2.poll();
                sum1 += poll; sum2 -= poll;
                q1.add(poll);
            }
            if(q1.isEmpty()||q2.isEmpty()){break;}
            if(cnt>queue1.length*4){break;}
        }
        return sum1==sum2? cnt:-1;
        
    }    
}
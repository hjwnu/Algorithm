import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int inTheTruck =0;
        int idx =0;
        for(int box =1 ; box <= order.length;box++){
            if(order[idx]!=box) { sub.push(box); continue; }
            
            inTheTruck++; idx++;
            
            while(!sub.isEmpty()&&sub.peek()==order[idx]) { sub.pop(); inTheTruck++; idx++; }

        }
            
        return inTheTruck;
    }
}

//컨베이어벨트 1 -> n 큐
//보조 스택

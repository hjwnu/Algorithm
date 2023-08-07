import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> sub = new Stack<>();
        int inTheTruck =0;
        int idx =0;
        for(int box =1 ; box <= order.length;box++){ // 반복문 자체가 메인 컨테이너 박스.
            if(order[idx]!=box) { sub.push(box); continue; } // 맨 앞 박스를 못 넣으면, 보조 컨테이너로 보내고 다음 박스.
            inTheTruck++; idx++; // 같으면, 트럭에 싣고(inTheTruck++) 다음에 실어야 할 박스로(idx++)
            
            // 보조 컨테이너에 그 다음 박스도 바로 실어야 할 수 있으므로 while
            while(!sub.isEmpty()&&sub.peek()==order[idx]) { sub.pop(); inTheTruck++; idx++; }   // 보조 컨테이너 맨 앞이 다음에 실을 박스라면, 트럭에 싣고 다음 박스로. 

        }
            
        return inTheTruck;
    }
}

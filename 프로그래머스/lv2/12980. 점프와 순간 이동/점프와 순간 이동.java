import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1; // 0->n 과 n->0으로 가는 횟수는 동일하다. 아래 반복문은 항상 1에서 멈추므로, 0->1만큼의 이동횟수를 추가해 시작한다.
        while(n>1){
            if(n%2==0){n /= 2;}
            else { n --; ans++;}
        }
        return ans; 
    }
}
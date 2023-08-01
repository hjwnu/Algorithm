import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n>1){
            if(n%2==0){n /= 2;}
            else { n --; ans++;}
        }
        return ans+1; // 위 반복문은 항상 1에서 멈추므로, 1만큼 이동한다.
    }
}
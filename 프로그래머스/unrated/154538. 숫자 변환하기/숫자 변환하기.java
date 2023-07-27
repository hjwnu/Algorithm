import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1]; // 인덱스 = 연산 과정에 거쳐가는 숫자
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for (int i = x; i <= y; i++) {
            if (dp[i] == Integer.MAX_VALUE) {continue;} // 관련없는 수 패스
            
            int x2 = i*2; int x3 = i*3; int nPlus = i+n;
            
            if( x2<=y || x3<=y || nPlus<=y ){
            // 기존 연산 횟수 +1 하여 저장. 이미 더 적게 연산하여 해당 숫자에 도달한 적이 있다면, 더 적은 숫자로 저장
                if (x2 <= y) {dp[x2] = Math.min(dp[i] + 1, dp[x2]);}                
                if (x3 <= y) {dp[x3] = Math.min(dp[i] + 1, dp[x3]);}
                if (nPlus <= y) {dp[nPlus] = Math.min(dp[i] + 1, dp[nPlus]);}
            }
            else{break;} // 세 가지 연산 모두 y값을 넘는다면 더이상의 연산 불필요
            
            if (dp[y] != Integer.MAX_VALUE) {break;} // y값이 바뀌었다면 연산을 거쳐 최소 횟수로 도달했음을 의미
        }
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}
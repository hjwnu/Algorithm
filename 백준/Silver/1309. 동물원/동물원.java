import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N == 1) {
            System.out.println(3); return;
        }
        int[][] dp = new int[N][3];
        
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        
        for(int i = 1; i < N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }
        
        int[] answer = dp[N-1];
        System.out.println((answer[0] + answer[1] + answer[2]) % 9901);
        
    }
}
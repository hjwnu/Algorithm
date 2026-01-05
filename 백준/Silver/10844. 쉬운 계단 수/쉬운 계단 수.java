import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[][] dp = new long[n][10];
        Arrays.fill(dp[0],1);
        dp[0][0] = 0;
        for(int i = 1; i < n;i++){
            for(int j = 0 ; j < 10; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][1]; continue;
                } else if(j==9){
                    dp[i][j] = dp[i-1][8]; continue;
                }
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1_000_000_000L;
            }
        }
        
        long answer = 0;
        for(int i = 0; i < 10;i++) answer += dp[n-1][i];
        System.out.println(answer % 1_000_000_000L);
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] wine = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Long.parseLong(br.readLine());
        }

        long[] dp = new long[n + 1];

        if (n >= 1) dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];
        if (n >= 3) dp[3] = Math.max(dp[2], Math.max(wine[1] + wine[3], wine[2] + wine[3]));

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    Math.max(
                            dp[i - 2] + wine[i],
                            dp[i - 3] + wine[i - 1] + wine[i]
                    )
            );
        }

        System.out.println(dp[n]);
    }
}

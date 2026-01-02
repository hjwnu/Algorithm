import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long ans = 1;
        long MOD = 1_000_000_000_000L; // 10^12 (여유 있게)

        for (int i = 2; i <= n; i++) {
            ans *= i;

            while (ans % 10 == 0) ans /= 10; // 뒤 0 제거

            ans %= MOD; // 크기 제한 (정보 손실 줄이기 위해 크게)
        }

        long last5 = ans % 100000;
        System.out.printf("%05d\n", last5);
    }
}

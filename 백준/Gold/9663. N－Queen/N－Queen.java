import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int ans = 0;
    static int[] queens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queens = new int[n]; // 각 행의 퀸 위치를 저장
        dfs(0);
        System.out.println(ans);
    }

    public static void dfs (int row) {
        if (row == n) {
            ans++; // 모든 행에 퀸 배치 완료
            return;
        }

        for (int col = 0; col < n; col++) {
            queens[row] = col;
            if (isSafe(row, col)) {
                dfs(row+1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            if(Math.abs(queens[i] - col) == Math.abs(i - row))  return false;
        }
        return true;
    }
}

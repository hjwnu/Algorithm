import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int row = Integer.parseInt(temp[0]);
        int col = Integer.parseInt(temp[1]);

        char[][] chess = new char[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                chess[i][j] = line.charAt(j);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {

                int cnt = 0;
                char expected = chess[i][j];

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (k == i && l == j) continue;

                        expected = (expected == 'W') ? 'B' : 'W';

                        if (chess[k][l] != expected) {
                            cnt++; 
                        }
                    }

                    expected = (expected == 'W') ? 'B' : 'W';
                }

                int localMin = Math.min(cnt, 64 - cnt);
                ans = Math.min(ans, localMin);

                if (ans == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(ans);
    }
}

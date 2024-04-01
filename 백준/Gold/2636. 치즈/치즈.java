import java.util.*;
import java.io.*;

class Main {
    static int[][] matrix;
    static int[] dx = {- 1, 1, 0, 0};
    static int[] dy = {0, 0, 1, - 1};
    static int h, v, cheeze, time, ans;
    static boolean[][] visited;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        matrix = new int[h][v];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < v; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    matrix[i][j] = temp;
                    cheeze++;
                }
            }
        }
        while (cheeze != 0) {
            time++;
            ans = cheeze;
            meltingCheese();
        }
        System.out.println(time);
        System.out.println(ans);
    }


    public static void meltingCheese () {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited = new boolean[h][v];
        visited[0][0] = true;

        while (! q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = cur[0] + dx[i];
                int moveY = cur[1] + dy[i];
                if (moveX < 0 || moveX >= h || moveY < 0 || moveY >= v || visited[moveX][moveY]) continue;
                if (matrix[moveX][moveY] == 1) {
                    cheeze--;
                    matrix[moveX][moveY] = 0;
                } else {
                    q.add(new int[]{moveX, moveY});
                }
                visited[moveX][moveY] = true;
            }
        }
    }
}
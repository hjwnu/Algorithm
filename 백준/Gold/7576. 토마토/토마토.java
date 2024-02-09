import java.io.*;
import java.util.*;

public class Main {
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] matrix;
    static boolean[][] visited;
    static int day = 0 ;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> unripe = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]==1) {
                    unripe.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        ripen(unripe);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 0 && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day-1);
    }
    public static void ripen(Queue<int[]> unripe){
        if(unripe.isEmpty()) return;

        day++;
        Queue<int[]> other = new LinkedList<>();
        while(!unripe.isEmpty()) {
            int[] cur = unripe.poll();
            for (int[] d : direction) {
                int curX = cur[0] + d[0];
                int curY = cur[1] + d[1];
                if (curX >= 0 && curX < n
                        && curY >= 0 && curY < m
                        && matrix[curX][curY] > -1 && !visited[curX][curY]) {
                    visited[curX][curY] = true;
                    matrix[curX][curY] = 1;
                    other.add(new int[]{curX, curY});
                }
            }
        }
        ripen(other);
    }
}

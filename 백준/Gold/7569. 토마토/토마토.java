import java.io.*;
import java.util.*;

public class Main {
    static int[][] direction = {{1,0,0},{0,1,0},{-1,0,0},{0,-1,0},{0,0,1},{0,0,-1}};
    static int[][][] matrix;
    static boolean[][][] visited;
    static int day = 0 ;
    static int n,m,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        matrix = new int[n][m][h];
        visited = new boolean[n][m][h];
        Queue<int[]> unripe = new LinkedList<>();
        for(int k = 0; k < h; k++){
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[i][j][k] = Integer.parseInt(st.nextToken());
                    if(matrix[i][j][k]==1) {
                        unripe.add(new int[]{i,j,k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        ripen(unripe);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for(int k = 0; k < h; k++){
                    if(matrix[i][j][k] == 0 && !visited[i][j][k]) {
                        System.out.println(-1);
                        return;
                    }
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
                int curZ = cur[2] + d[2];
                if (curX >= 0 && curX < n
                        && curY >= 0 && curY < m
                        && curZ >= 0 && curZ < h
                        && matrix[curX][curY][curZ] > -1 && !visited[curX][curY][curZ]) {
                    visited[curX][curY][curZ] = true;
                    matrix[curX][curY][curZ] = 1;
                    other.add(new int[]{curX, curY,curZ});
                }
            }
        }
        ripen(other);
    }
}

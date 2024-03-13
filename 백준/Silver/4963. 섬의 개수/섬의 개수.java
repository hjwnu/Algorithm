import java.util.*;
import java.io.*;

class Main {
    static int[][] matrix;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int count;
    static int w,h;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            count = 0;
            String input = br.readLine();
            if(input.equals("0 0")) break;
            st = new StringTokenizer(input);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            matrix = new int[h][w];
            visited = new boolean[h][w];
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0 ; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(matrix[i][j] == 1
                            && !visited[i][j]) {
                        bfs(i,j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];
            for (int i = 0; i < 8; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];
                if (moveX >= 0 && moveX < h
                        && moveY >= 0 && moveY < w
                        && ! visited[moveX][moveY]
                        && matrix[moveX][moveY] == 1) {
                    visited[moveX][moveY] = true;
                    q.add(new int[]{moveX, moveY});
                }
            }
        }
        count++;
    }
}
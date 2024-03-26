import java.util.*;
import java.io.*;

class Main {
   static int[][] matrix;
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static int M,N;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++){
            count = 0;
            //getMatrix(br);
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            matrix = new int[N][M];
            visited = new boolean[N][M];
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                matrix[n][m] = 1;
            }
            for(int x = 0; x < N; x++){
                for(int y = 0; y <M; y++){
                    if(matrix[x][y] == 1
                      && !visited[x][y]) bfs(x,y);
                }
            }
            
            System.out.println(count);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            if(visited[curX][curY]) continue;
            visited[curX][curY] = true;
            
            for(int[] d : direction){
                int moveX = curX + d[0];
                int moveY = curY + d[1];
                if(moveX >= 0 && moveX < N
                        && moveY >= 0 && moveY < M
                        && matrix[moveX][moveY] == 1
                        && !visited[moveX][moveY]){
                    q.add(new int[]{moveX,moveY});
                }
            }
        }
        count++;
    }

    public static void getMatrix(BufferedReader br) throws IOException {
        
    }
}
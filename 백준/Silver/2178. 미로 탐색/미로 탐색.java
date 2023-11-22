import java.util.*;
import java.io.*;

public class Main {
    static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] maze;    static boolean[][] visited; static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        n = nm[0]; m = nm[1];
        maze = new int[n][m]; visited = new boolean[n][m];
        for(int i =0;i < n;i++){
            maze[i] = inputToIntArr(br.readLine());
        }
        visited[0][0] = true;
        bfs(0,0);
        System.out.println(maze[n-1][m-1]);
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0]; int curY = cur[1];

            for(int[] d : direction){
                int moveX = curX + d[0];
                int moveY = curY + d[1];
                if(moveX>=0 && moveX<n && moveY>=0 && moveY<m) {
                    if(maze[moveX][moveY]==1 && !visited[moveX][moveY]) {
                        q.add(new int[] {moveX, moveY});
                        visited[moveX][moveY]=true;
                        maze[moveX][moveY] = maze[curX][curY]+1;
                    }
                }
            }
        }
    }

    public static int[] inputToIntArr(String input){
        String[] temp = input.split("");
        int[] arr = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        return arr;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] visitedB;
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static int color = 0, colorBlind = 0 ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        map = new char[len][len];
        visited = new boolean[len][len];
        visitedB= new boolean[len][len];
        for(int i =0; i < len;i++){
            map[i] = br.readLine().toCharArray();
        }
        for (int i =0; i < len; i++){
            for(int j =0 ; j < len;j++) {
                if (!visited[i][j]) {visited[i][j]= true; bfs(i, j);}
                if(!visitedB[i][j]){visitedB[i][j]=true; blindBfs(i,j);}
            }
        }
        System.out.println(color+" "+colorBlind);
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur =  q.poll();
            int curX = cur[0]; int curY = cur[1];

            for(int[] d : direction) {
                int moveX = curX + d[0];
                int moveY = curY + d[1];
                if (moveX >= 0 && moveX < map.length && moveY >= 0 && moveY < map[0].length
                && map[moveX][moveY] == map[curX][curY] && !visited[moveX][moveY]) {
                        q.add(new int[]{moveX, moveY});
                        visited[moveX][moveY] = true;
                }
            }
        }
        color++;
    }
    public static void blindBfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int[] d : direction) {
                int moveX = curX + d[0];
                int moveY = curY + d[1];
                if (moveX >= 0 && moveX < map.length && moveY >= 0 && moveY < map[0].length
                        && !visitedB[moveX][moveY]) {
                    if (map[curX][curY]=='R'||map[curX][curY]=='G') {
                        if (map[moveX][moveY] == 'R'||map[moveX][moveY] == 'G'){
                            q.add(new int[]{moveX, moveY});
                            visitedB[moveX][moveY] = true;
                        }
                    } else{
                        if (map[moveX][moveY] == map[curX][curY] ) {
                            q.add(new int[]{moveX, moveY});
                            visitedB[moveX][moveY] = true;
                        }
                    }
                }
            }
        }
        colorBlind++;
    }
}

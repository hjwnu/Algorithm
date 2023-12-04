import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] len = inputToIntArr(br.readLine());
        map = new int[len[0]][len[1]];
        visited = new boolean[len[0]][len[1]];
        for(int i =0; i < len[0];i++){
            map[i] = inputToIntArr(br.readLine());
        }
        int x  =-1; int y = -1;
        for(int i =0; i < len[0];i++){
            for(int j =0; j < len[1];j++){
                if(map[i][j]==2){
                    x = i; y = j;
                    break;
                }
            }
        }
        map[x][y]= 0;
        visited[x][y]= true;
        bfs(x,y);
        for(int i =0; i < len[0];i++){
            StringBuilder sb = new StringBuilder();
            for(int j =0; j < len[1];j++){
                if(!visited[i][j]&&map[i][j]==1){map[i][j]= -1;}
                sb.append(map[i][j]).append(" ");
            }
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
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
                if(moveX>=0&&moveX<map.length&&moveY>=0&&moveY<map[0].length
                        &&map[moveX][moveY]==1&&!visited[moveX][moveY]){
                    q.add(new int[]{moveX,moveY});
                    map[moveX][moveY] = map[curX][curY]+1;
                    visited[moveX][moveY] = true;
                }
            }
        }
    }
    public static int[] inputToIntArr(String input){
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        return arr;
    }
}

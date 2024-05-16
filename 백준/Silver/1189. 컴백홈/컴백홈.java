import java.util.*;
import java.io.*;

class Main {
  static int R;
  static int C;
  static int K;
  static String[] map;
  static int ans = 0;
  static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new String[R];
    for(int i = 0 ; i < R ; i++) map[i] = br.readLine();
    visited = new boolean[R][C];
    visited[R-1][0] = true;
      dfs(R - 1, 0, 1);
      System.out.println(ans);
  }

  public static void dfs(int x, int y, int length){
    if(x == 0 && y == C-1 && length == K){
      ans++;
      return;
    }

      for(int[] d : direction){
        int moveX = x + d[0];
        int moveY = y + d[1];
        if(moveX < 0 || moveX >= R
            || moveY < 0 || moveY >= C) continue;
        if(map[moveX].charAt(moveY) == '.' && !visited[moveX][moveY]) {
          visited[moveX][moveY] = true;
          dfs(moveX,moveY, length+1);
          visited[moveX][moveY] = false;
        }
      }
    }
  }
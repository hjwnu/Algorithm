import java.io.*;
import java.util.*;

public class Main {
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static char[][] board;
    static boolean[] visited = new boolean[26];
    static int ans =1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] temp = toIntArr(br.readLine());
        board = new char[temp[0]][temp[1]];
        for(int i =0; i < temp[0];i++){
            board[i] = getBoard(br.readLine());
        }
        dfs(0,0,0);
        System.out.println(ans);
    }
    public static void dfs(int x, int y, int cnt){
        if(visited[board[x][y]-'A']){
            ans = Math.max(ans,cnt);
            return;
        }
        visited[board[x][y]-'A'] = true;
        for(int[] d : direction){
            int moveX = x + d[0];
            int moveY = y + d[1];
            if(moveX>=0&&moveX<board.length && moveY>=0&&moveY<board[0].length){
                dfs(moveX, moveY,cnt+1);
            }
        }
        visited[board[x][y]-'A'] = false;


    }

    public static char[] getBoard(String input){
        char[] temp = new char[input.length()];
        for(int i = 0 ; i < temp.length;i++){
            temp[i] = input.charAt(i);
        }
        return temp;
    }
    public static int[] toIntArr(String input){
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        return arr;
    }
}

import java.io.*;
import java.util.*;

class Main {
    static int total,n;
    static boolean[] visited;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        total = Integer.parseInt(temp[1]);
        
        seq = new int[total];
        visited = new boolean[n+1];
        dfs(0);

        System.out.println(sb);
    }
    
    
    static void dfs(int depth){
        if(depth == total) {
            for(int i = 0; i < total; i++){
                sb.append(seq[i]);
                if(i+1 < total) sb.append(' '); 
            }
            sb.append('\n');
            return;
        }
        
        for(int i =1; i <= n;i++){
            if(visited[i]) continue;
            visited[i] = true;
            seq[depth] = i;
            dfs(depth+1);
            visited[i] = false;
        }
        
    }
}
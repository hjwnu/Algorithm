import java.util.*;
import java.io.*;

class Main {
    static int[][] matrix;
    static boolean[]visited;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        matrix = new int[n+1][n+1];


        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrix[from][to] = matrix[to][from] = 1;
        }
        visited = new boolean[n+1];
        sb = new StringBuilder();

        dfs(v);
        System.out.println(sb);
        bfs(v);
    }
    public static void dfs(int start){
        sb.append(start).append(" ");
        if(visited[start]) return;
        visited[start] = true;

        for(int i = 1; i < matrix.length;i++){
            if(!visited[i]){
                if(matrix[start][i] == 1) {
                    dfs(i);
                }
            }
        }
    }

    public static void bfs(int start){
        visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            visited[cur] = true;

            for(int i = 1; i < matrix.length;i++){
                if(!visited[i]){
                    if(matrix[cur][i]==1){
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}
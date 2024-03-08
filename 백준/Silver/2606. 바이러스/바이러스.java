import java.util.*;
import java.io.*;

class Main {
    static int[][] matrix;
    static boolean[] visited;
    static int total;
    static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        int tc = Integer.parseInt(br.readLine());
        matrix = new int[total+1][total+1];
        visited = new boolean[total+1];

        StringTokenizer st;
        for(int i = 0 ; i < tc ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrix[from][to] = matrix[to][from] = 1;
        }

        bfs(1);
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList();
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            if(visited[cur]) continue;
            visited[cur] = true;
            count++;

            for(int i = 1; i <= total; i++){
                if(!visited[i] && matrix[cur][i] == 1){
                    q.add(i);
                }
            }
        }
        System.out.println(count);
    }
}
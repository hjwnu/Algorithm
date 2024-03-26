import java.util.*;
import java.io.*;

class Main {
    static int[][] matrix;
    static int n,m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        int max = 0;
        for(int i = 0; i < list.size(); i++){
            max = Math.max(max, list.get(i));
        }
        System.out.println(max);
    }
    public static void dfs(int wall){
        if(wall == 3){
            spreadVirus();
            return;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][j] = 1;
                    dfs(wall+1);
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void spreadVirus(){
        Queue<int[]> q = new LinkedList<>();
        int[][] tempMatrix = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                tempMatrix[i][j] = matrix[i][j];
                if(matrix[i][j]==2) q.add(new int[]{i,j});
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int i = 0; i < 4;i++){
                int moveX = curX + dx[i];
                int moveY = curY + dy[i];
                if(moveX < 0 || moveX >= n || moveY < 0 || moveY >= m) continue;
                if(tempMatrix[moveX][moveY] == 0){
                    tempMatrix[moveX][moveY] = 2;
                    q.add(new int[]{moveX,moveY});
                }
            }
        }
        countSafe(tempMatrix);
    }

    public static void countSafe(int[][] copy){
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copy[i][j] == 0) count++;
            }
        }
        list.add(count);
    }
}
import java.util.Scanner;

public class Main{
    static int a,b;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] direction = {{0,1},{0,-1},{-1,0},{1,0}};
    static boolean check = false;
    
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        
        graph = new int[a][b];
        visited = new boolean[a][b];
        
        for (int i =0 ; i < a;i++){
            String str= sc.next();
            for (int j =0; j < b; j++){
                graph[i][j] = str.charAt(j)-'0';
            }
        }
        for (int i =0; i < b; i++){
            if(graph[0][i]==0){ //위에서 진입 가능여부 판단, 진입가능하다면
                dfs(0,i); // dfs 탐색 시작
            }
        }
        
        System.out.println(check?"YES":"NO"); // dfs 탐색 후, 마지막 줄 0까지 도달했다면 check ==true
    }
    
    
    public static void dfs(int row, int col){
        visited[row][col] = true; // 최초 방문 시, 방문 지점 확인
        if(row == a-1 &&graph[row][col]==0){ // 만약 행이 마지막행이고, 방문한 해당 칸이 0이라면 check=true후 반환.
            check = true;
            return;
        }
        
        for(int i =0 ; i < direction.length;i++){
            int x = row + direction[i][0];
            int y = col + direction[i][1];
            
            if(x >= 0 && y >=0 && x < a && y < b && !visited[x][y]&&graph[x][y]==0){ // 주어진 그래프 범위 내에서 & 방문하지 않았고 & 이동 시 해당 칸이 이동가능(0)하다면, 해당 칸 기준으로 dfs 재귀.
                dfs(x,y);
            }
        }
    }
}
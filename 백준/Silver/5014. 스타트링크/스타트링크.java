import java.util.*;

public class Main {
    static int f,s,g,u,d;
    static boolean[] visited;
    static int[] move;
    static int[] direction = new int[2]; // u,d
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        f = sc.nextInt(); // 총 F층
        s = sc.nextInt(); // 현재 s층
        g = sc.nextInt(); // 목표 g층
        direction[0] = sc.nextInt(); //위로
        direction[1] = sc.nextInt()*-1; //아래로
        
        move = new int[f+1];
        visited = new boolean[f+1];
        bfs(s);
    }
    
    static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        
        q.add(s);
        visited[s] = true;
        move[s] = 0;
        
        while(!q.isEmpty()){
            int now = q.poll();
            if( now == g){
                System.out.println(move[now]);
                return;
            }
            
            for (int i =0 ; i < 2; i++){
                int next = now + direction[i];
                if(next<=f && next >=1 && !visited[next]){
                    visited[next] = true;
                    q.add(next);
                    move[next] = move[now] +1;
                }
            }
            
        }
        System.out.println("use the stairs"); // while문을 나왔다는 것 => 반환되지 못하고 q가 비어버림 -> 해당 층 갈 수 없음
    }
}
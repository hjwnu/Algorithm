import java.util.*;
class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int i = 0 ; i < n; i++){
            if(!visited[i]) {
                bfs(computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(int[][] computers, int from){
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            for(int i = 0; i < computers.length; i++){
                if(computers[cur][i] == 1 && !visited[i]) q.add(i);
            }
        }
    }
}
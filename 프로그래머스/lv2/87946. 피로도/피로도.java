class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited =new boolean[dungeons.length];
            dfs(k, dungeons,visited);
        return max;
        
    }
    
    int max = Integer.MIN_VALUE;
    
    public void dfs(int k, int[][] dungeons, boolean[] visited){
        int cnt =0;
        for(int i =0; i < dungeons.length;i++){
            if(visited[i]){cnt++;} if(cnt>max){max = cnt;}
            if(!visited[i]){
                if(k >= dungeons[i][0]){
                    visited[i] = true; k -= dungeons[i][1];
                    dfs(k, dungeons,visited);
                    k+= dungeons[i][1]; visited[i] = false;
                    
                }
            }
        }  
    }
}
import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
       
        int[] ans = new int[commands.length];
        for(int a = 0; a < commands.length; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            
            int[][] answer = new int[commands.length][j-i+1]; // j-i+1 == 자른 이후의 배열 길이
            for(int b = 0; b < j-i+1;b++){
                answer[a][b] = array[i-1+b];    
            }
            Arrays.sort(answer[a]); // 자른 배열 정렬
            ans[a] = answer[a][commands[a][2]-1]; 
        }
        return ans;
    }
}
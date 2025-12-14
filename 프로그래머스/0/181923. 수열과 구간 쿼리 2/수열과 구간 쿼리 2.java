import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.setAll(answer, i -> -1);
        for(int i = 0; i < answer.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int k = queries[i][2];
            for(int j = start; j <= end; j++){
                if(arr[j] > k){
                    answer[i] = answer[i] == -1 ? arr[j] : Math.min(answer[i], arr[j]);
                }
            }
        }
        return answer;
    }
}
class Solution {
    int answer =0;
    public int solution(int[] numbers, int target) {
    dfs(0,0,numbers,target);
    return answer;
    }
    void dfs(int n, int sum, int[] numbers, int target){
        if(n==numbers.length){
            if(sum==target) 
            answer++;
            return;
        }
        
        dfs(n+1, sum + numbers[n], numbers,target);
        dfs(n+1, sum - numbers[n], numbers,target);
    }
}
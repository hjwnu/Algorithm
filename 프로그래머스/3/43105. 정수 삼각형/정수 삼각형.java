class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        for(int i =1; i < n;i++){
            triangle[i][0] += triangle[i-1][0];
            for(int j = 1; j < i;j++){
                triangle[i][j] += Math.max(triangle[i - 1][j-1], triangle[i - 1][j]);
            }
            triangle[i][i] += triangle[i-1][i-1];
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i : triangle[n-1]){
            ans = Math.max(i, ans);
        }
        return ans;
    }        
}




/*
7
38
810
2744
45265
*/
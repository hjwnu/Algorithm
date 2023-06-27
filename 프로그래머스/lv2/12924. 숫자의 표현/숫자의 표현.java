class Solution {
    public int solution(int n) {
    int ans =0;
    for ( int i =1 ; i <= n;i+=2){
    if(n%i==0) ans++;
    }
        return ans;
    }
}
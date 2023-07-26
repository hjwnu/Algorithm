class Solution {
    public int solution(int n) {
        for(int i =1; i <=n;i++){
            if(i%3==0||i%10==3||i/10==3||i/10==13){n++;}
        }
        return n;
    }
}
class Solution {
    public long solution(int n) {
      int[] fibo = new int[n+1];
    for(int i= 0 ; i < n+1; i++){
        if(i<4){fibo[i] = i;}
    else{ fibo[i] = (fibo[i-2]+fibo[i-1])%1234567;}
    }
      return fibo[n];
    }
}
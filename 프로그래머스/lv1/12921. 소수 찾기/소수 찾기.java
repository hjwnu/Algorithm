class Solution {
    public int solution(int n) {
        boolean[] isPrime = new boolean[n+1];
        isPrime[0] = true; isPrime[1] = true; isPrime[2] = false;
        int cnt=0;    

        for(int i=2; i*i<=n; i++){
            if(!isPrime[i]){
            	for(int j=i*i; j<=n; j+=i) isPrime[j]=true;                
            }        
        }    
        
        for( boolean a : isPrime){
            if(!a) {cnt++;}
        }
        return cnt;
    }
}
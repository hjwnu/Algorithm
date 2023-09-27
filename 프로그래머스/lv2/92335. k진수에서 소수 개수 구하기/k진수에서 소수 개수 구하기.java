import java.util.*;
class Solution {
    public int solution(int n, int k) {
        long[] num = ConvertBase(n,k);    
    
        int ans =0;

        for(long i : num){if(isPrime(i)){ans++;}}

        return ans;
    }

    public long[] ConvertBase(int n, int k){
        String str = Long.toString(n,k).replaceAll("0"," ").replaceAll("\\s+"," ");
        String[] isPrimeArr  = str.split(" ");
        
        long[] isPrime = new long[isPrimeArr.length];
        
        for(int i =0 ; i < isPrimeArr.length;i++){
            
            if(!isPrimeArr[i].equals("")){
                isPrime[i] = Long.parseLong(isPrimeArr[i]);}
        }
        
        return isPrime;
    }
    
    public boolean isPrime(long n) {
    if(n <=1){return false;}
	for (int i = 2; i<=(long)Math.sqrt(n); i++) {
      if (n % i == 0) {
          return false;
      }
	}
	return true;
}
}

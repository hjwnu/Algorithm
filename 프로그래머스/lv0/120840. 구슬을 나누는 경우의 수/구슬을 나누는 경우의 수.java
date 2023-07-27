import java.math.*;
class Solution {
    public int solution(int balls, int share) {
        
        BigInteger mol = factorial(balls);
        
        BigInteger denom1 = factorial(balls-share);
        BigInteger denom2 = factorial(share);
        
        BigInteger denom = denom1.multiply(denom2);
        
        BigInteger ans = mol.divide(denom);
        
        return ans.intValue();
    }
    
    BigInteger factorial(int num){
        BigInteger a= new BigInteger("1");
        for(int i = 1; i <= num; i++){
            BigInteger b = new BigInteger(String.valueOf(i));
            a = a.multiply(b);
        }
        return a;
    }
}
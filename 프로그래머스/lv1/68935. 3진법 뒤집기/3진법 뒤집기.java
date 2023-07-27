import java.util.*;
class Solution {
    public long solution(long n) {
        StringBuilder a = new StringBuilder();
        while(n!=0){
            a.append(n%3+""); n /= 3;
        }
        long b = Long.parseLong(a.toString()); long ans =0;
        for( long i =0; i < a.length();i++){
            ans += b%10*Math.pow(3,i);  b /= 10; 
        }
        
        return ans;
    }
}
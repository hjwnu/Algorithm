import java.util.*;
class Solution {
    public int solution(int[] arr) {
        if(arr.length==1) return arr[0];
        
        int GCD = GCD(arr[0],arr[1]);
        int LCM = arr[0]*arr[1]/GCD;
        
        if(arr.length>2){
        for(int i =2; i < arr.length;i++){
            GCD = GCD(LCM,arr[i]);
            LCM = (LCM * arr[i])/GCD;
            }
        }
        return LCM;
    }
    public int GCD(int m, int n){
        if(m%n==0) return n;
        else return GCD(n,m%n);
    }
}
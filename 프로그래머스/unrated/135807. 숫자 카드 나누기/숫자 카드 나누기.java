import java.util.*;
class Solution {      
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA); Arrays.sort(arrayB);
        int gcdA = findGCD(arrayA);
        int gcdB = findGCD(arrayB);
        boolean AisDivided = isDivide(arrayA, gcdB);
        boolean BisDivided = isDivide(arrayB, gcdA);
        
        // 둘다 true면, 0
        // 둘다 false면, 둘 중 최댓값
        // 한쪽만 false라면, false인 쪽의 gcd 반환
        if(AisDivided&&BisDivided){
            return 0;
        }
        else if(!AisDivided&&!BisDivided){return gcdA >= gcdB? gcdA:gcdB;}
        else {
            return AisDivided? gcdA:gcdB;
        }
    }
    
    public int findGCD(int[] arr){
        int gcd =arr[0];
        for(int i = 1; i < arr.length;i++){
            gcd = GCD(arr[i],gcd);
        }
        return gcd;
    }
    
    public boolean isDivide(int[] arr, int gcd){
        for(int i =0; i < arr.length;i++){
            if(arr[i]%gcd==0){return true;}
        }
        return false;
    }
    
    public int GCD(int M, int N){
        if(M%N==0) {return N;}
        else {return GCD(N, M%N);}
    }
}
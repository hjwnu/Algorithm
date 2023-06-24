class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int nu, de;
        if(denom1==denom2){nu = numer1+numer2;}
        
        // 통분하기 위한 분모의 최소공배수 구하기.
        int deGCD = GCD(denom1,denom2);
        int deLCM = (denom1*denom2)/deGCD;
        
        // 통분하기
        int t1 = deLCM/denom1; int t2 = deLCM/denom2;
        
        nu = numer1*t1 + numer2*t2;
        de = denom1*t1;
        
        int GCD = GCD(nu,de);
        
        return new int[]{nu/GCD,de/GCD};
    }
    public static int GCD(int M, int N){
        if(M%N==0){return N;}
        return GCD(N, M%N);
    }
}
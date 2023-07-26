class Solution {
    public int solution(int a, int b) {
        if(a%b==0) return 1; // 정수는 유한소수
        
        b /= GCD(a,b);
        
        if(b%2!=0&&b%5!=0) return 2; // 2 or 5가 소인수로 없다면 무한소수
        
        for(int i =3; i <= b/2; i++){
            boolean pf = i%2==0||i%5==0; // i가 2 or 5의 배수인지 체크
            
            if(b%i==0&&!pf) return 2;  // 2 or 5의 배수가 아닌 수로 나눠떨어진다면 무한소수
        }
        
        return 1;
    }
    
    public int GCD(int m,int n){
        if(m < n){ int tmp = n; n = m; m = tmp;}
        if(m%n==0) return n;
        return GCD(n, m%n);
    }
}
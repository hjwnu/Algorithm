class Solution {
    public int solution(int a, int b) {
        if(a%b==0) return 1; // 정수는 유한소수
        
        int gcd = GCD(a,b); b /= gcd;
        
        if(b%2!=0&&b%5!=0) return 2; // 2와 5가 소인수로 없다면 무한소수
        
        for(int i =3; i <= b/2; i++){
            if(b%i==0&&(i%2!=0&&i%5!=0)) return 2;  // 2와 5 이외의 소인수가 있다면 무한소수
        }
        
        return 1;
    }
    
    public int GCD(int m,int n){
        if(m < n){ int tmp = n; n = m; m = tmp;}
        if(m%n==0) return n;
        return GCD(n, m%n);
    }
}
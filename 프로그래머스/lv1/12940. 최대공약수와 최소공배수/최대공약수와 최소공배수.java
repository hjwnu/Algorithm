class Solution {
    public int[] solution(int n, int m) {
        if(n<m){int temp =n; n = m; m = temp;} // 무조건 n이 큰 수로.

        return new int[]{gcd(n,m), n*m/gcd(n,m)};
    }
    
    public int gcd(int n, int m){   
        if(m == 0 ) return n;
        return gcd(m, n%m);
    }
}
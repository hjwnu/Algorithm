class Solution {
    public int solution(int a, int b, int n) {
        int ans = 0;

        while (n/a>0) {
            ans += (n/a) * b;
            n = (n/a)*b + n%a;
        }
        return ans;
    }
}

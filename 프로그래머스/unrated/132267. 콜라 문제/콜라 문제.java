class Solution {
    public int solution(int a, int b, int n) {
        int emptyBottles = n;
        int ans = 0;

        while (emptyBottles >= a) {
            int takeBack = emptyBottles / a;
            emptyBottles %= a;
            emptyBottles += takeBack * b;
            ans += takeBack * b;
        }

        return ans;
}
  }

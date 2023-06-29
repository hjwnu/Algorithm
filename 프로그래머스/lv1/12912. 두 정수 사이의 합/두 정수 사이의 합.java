class Solution {
    public long solution(int a, int b) {
        long ans =0;
        int start = a>b? b:a;
        int end = a>=b? a:b;
        for(long i = start; i <=end; i++)
        {
            ans += i;
        }
           return ans;
    }
    }
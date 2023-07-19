class Solution {
    public int solution(int left, int right) {
        int ans =0;
        for (int i = left; i <= right;i++){
            if((int)Math.sqrt(i)*(int)Math.sqrt(i)==i){ans -= i;} // 제곱수의 약수만이 홀수.
            else{ans += i;}
        }
        return ans;
    }
}
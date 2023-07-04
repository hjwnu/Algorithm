class Solution {
    public String solution(int n) {
        String ans = "수박";
        return n%2==0? ans.repeat(n/2):ans.repeat(n/2)+"수";
    }
}
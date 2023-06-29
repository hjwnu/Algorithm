class Solution {
    public boolean solution(int x) {
        String str = x + "";
        int a= 0;
        for (int i =0; i < str.length();i++){
            a += str.charAt(i)-'0';
        }
        return x%a==0;
    }
}
class Solution {
    public String solution(String phone_number) {
     int len = phone_number.length();
     String ans = "*".repeat(len-4);
     ans += phone_number.substring(len-4,len);
        return ans;
    }
}
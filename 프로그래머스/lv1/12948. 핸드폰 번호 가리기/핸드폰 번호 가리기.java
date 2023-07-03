class Solution {
    public String solution(String phone_number) {
     String ans = "";
        for(int i =0; i< phone_number.length();i++){
            if(i < phone_number.length()-4){ans += "*";}
            else {ans += phone_number.charAt(i);}
        }
        return ans;
    }
}
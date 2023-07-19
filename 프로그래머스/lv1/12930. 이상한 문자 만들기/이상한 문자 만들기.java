class Solution {
public String solution(String s) {
    s = s.toLowerCase();
    char[] temp = s.toCharArray();
    String ans = ""; int idx = 0;
    for(int i =0; i < temp.length;i++){
        if(temp[i]==' ') {ans += temp[i]; idx =0;}
        else {
            if(idx%2==0) {ans += (temp[i]+"").toUpperCase(); idx++;}
            else {ans += temp[i]+""; idx++;}
        }   
    }
    return ans;
}
}
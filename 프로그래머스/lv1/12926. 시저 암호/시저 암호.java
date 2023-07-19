import java.util.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] temp = s.toCharArray();
        for (char c : s.toCharArray()) {
            char newC = (char) (c + n);
            if (c == ' ') {sb.append(c);} 
            else if (c <= 90) {
                if (newC > 90) {newC = (char) (newC - 26);}
                 sb.append(newC);
            }
            else {
                if (newC > 122) {newC = (char) (newC - 26);}
                 sb.append(newC);
                }
           
            }
        return sb.toString();
    }
}
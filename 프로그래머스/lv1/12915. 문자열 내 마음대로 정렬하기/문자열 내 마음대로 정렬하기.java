import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
   String[] temp = new String[strings.length];
        for (int i =0 ; i < strings.length;i++){
            temp[i] = strings[i].substring(n,n+1)+strings[i];
        }
        Arrays.sort(temp);
        for (int i =0 ; i < strings.length;i++){
            temp[i] = temp[i].substring(1);
        }
        return temp;
}
}
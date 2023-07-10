import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        Map<Integer, Character> idx = new HashMap<>();
        for (int i =0; i < my_string.length();i++){
            idx.put(i,my_string.charAt(i));
        }
        for(int i =0 ; i < indices.length;i++){
            idx.remove(indices[i]);
        }
        
        String ans = "";
        for (int key : idx.keySet()) {
             ans += idx.get(key);
        }
        
        return ans;
    }
}
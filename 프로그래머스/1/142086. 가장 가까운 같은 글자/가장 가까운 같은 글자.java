import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] tmp = s.toCharArray();
        int[] ans = new int[s.length()];
        for(int i =0 ; i < tmp.length;i++){
            if(!map.containsKey(tmp[i])){
                map.put(tmp[i],i);
                ans[i] = -1;
            }
            else{
                ans[i]=i-map.get(tmp[i]);
                map.put(tmp[i],i);
            }
        }      
        return ans;
    }
}
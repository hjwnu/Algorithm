import java.util.*;
class Solution {
    static Map<Character, Integer> idx = new HashMap<>();
    
    public int[] solution(String[] keymap, String[] targets) {
        
        mappingMinIdx(keymap);
        
        return typingMinOrNot(targets);
    }
    
    static void mappingMinIdx(String[] keymap){
        for(int i =0 ; i < keymap.length;i++){
            for(int j = 0; j < keymap[i].length();j++){
                char ch = keymap[i].charAt(j);
                if(idx.containsKey(ch)){
                    if(idx.get(ch)>j+1){idx.put(ch, j+1);}
                }
                else{idx.put(ch, j+1);}  
            }
        }
    }
  
    static int[] typingMinOrNot(String[] targets){
        int[] ans = new int[targets.length];
        for(int i =0 ; i < targets.length;i++){
            for(int j = 0; j < targets[i].length();j++){
                char ch = targets[i].charAt(j);
                if(idx.containsKey(ch)){ans[i] += idx.get(ch);}
                else{ans[i] = -1;break;} // 키맵에 타겟문자열이 없을 경우 -1 반환
            }
        }
        return ans;
    }
    
}
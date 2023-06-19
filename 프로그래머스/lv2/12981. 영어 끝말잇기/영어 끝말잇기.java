import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        List<String> used = new ArrayList<>();
        int turn = 1; int person = 0;
        used.add(words[0]);
        for(int i =1 ; i < words.length; i++){
          if(i%n ==0){ turn++;}
          String last = words[i-1].substring(words[i-1].length()-1); 
            if(words[i].startsWith(last)){ 
               if(used.contains(words[i])){  // 중복단어 말한 경우
                   person = i%n+1; break;}
                   used.add(words[i]);
            }
            
            else if(!words[i].startsWith(last)){    // 틀린단어 말한 경우
                person = i%n+1;break; 
            }
            if(i==words.length-1){ person = 0; turn =0;} // 끝까지 잘한 경우
        }
        
        int[] ans = new int[]{person,turn};
        return ans;
    }
}
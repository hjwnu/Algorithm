import java.util.*;
class Solution {
    public int solution(String s) {
        
        int tcnt=1; int acnt=0; int cnt=0; int idx=1; 
        int len = s.length();
        List<Character> tmp = new ArrayList<>();
        for(char ch: s.toCharArray()){
            tmp.add(ch);
        }
        while(tmp.size()>1){
            char target = tmp.get(0);
            if(target==tmp.get(1)){
                tcnt++; idx++; tmp.remove(1);
            }
            else{ acnt++; idx++; tmp.remove(1);}
            
            if(tcnt==acnt){cnt++; tcnt=1; acnt=0; tmp.remove(0);}
        }
        
        return tmp.size()==1?cnt+1:cnt;
    }
}
import java.util.*;
class Solution {
    
    static List<String> dict = new ArrayList<>();
    static String[] vowel = {"A","E","I","O","U"};
    
    public int solution(String word) {
        for(int i =0 ; i < vowel.length;i++){
            addWord(dict, vowel[i],word); // 각 모음으로 시작하는 모든 문자 탐색
        }    
        return dict.indexOf(word)+1;
    }
    
    void addWord(List<String> dict, String str, String target){
        if(dict.contains(target)){return;}
        if(str.length() > vowel.length) {return;}
        
        if(!dict.contains(str)) dict.add(str);
    
        for(int i=0; i<vowel.length; i++){
            addWord(dict, str+vowel[i],target);
        }
    }
}
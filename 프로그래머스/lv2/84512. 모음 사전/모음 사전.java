import java.util.*;
class Solution {
    
    static List<String> dict = new ArrayList<>();
    static String[] vowel = {"A","E","I","O","U"};
    
    public int solution(String word) {
        for(int i =0 ; i < vowel.length;i++){
            addWord(dict, vowel[i], word);
        }    
        return dict.indexOf(word)+1;
    }
    
    void addWord(List<String> dict, String str, String word){
        if(dict.contains(word)){return;}
        if(str.length() > vowel.length) {return;}
        
        if(!dict.contains(str)) dict.add(str);
    
        for(int i=0; i<vowel.length; i++){
            addWord(dict, str+vowel[i], word);
        }
    }
}
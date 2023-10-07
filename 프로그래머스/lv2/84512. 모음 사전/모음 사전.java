import java.util.*;
class Solution {
    
    static List<String> dict = new ArrayList<>();
    static String[] vowel = {"A","E","I","O","U"};
    
    public int solution(String word) {
        for(int i =0 ; i < vowel.length;i++){
            addWord(vowel[i], word); // 시작 문자 지정
        }    
        return dict.size();
    }
    
    private void addWord(String str, String word){
        if(dict.contains(word)){return;} // 목표 문자열이 사전에 들어왔다면 종료
        if(str.length() > vowel.length) {return;} // 더해진 문자열이 5글자를 넘었다면 종료
        
        if(!dict.contains(str)) dict.add(str); // 사전에 없는 문자면 추가
    
        for(int i=0; i<vowel.length; i++){
            addWord(str+vowel[i], word); // 기존 문자열에 한글자씩 순회하며 추가
        }
    }
}
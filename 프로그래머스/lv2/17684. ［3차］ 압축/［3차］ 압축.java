import java.util.*;
class Solution {
    static List<String> dict = new ArrayList<>();
    public int[] solution(String msg) {
        InitDict(); // 길이가 1인 모든 단어를 포함하는 사전
        
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(msg);
        StringBuilder temp;    
        
        while(sb.length()>0){
            temp = new StringBuilder(sb);
            StringBuilder w = FindDict(temp);// 현재 입력과 일치하는 가장 긴 문자열 w 찾기
            ans.add(dict.indexOf(w.toString())); // w에 해당하는 사전 색인 번호 출력
            sb = sb.delete(0,w.length()); // 입력에서 w 제거
            AddLongerWord(w,sb); // 입력에서 처리되지 않은 다음 글자가 있다면, w+c에 해당하는 단어를 사전에 등록
        }
        
        return ListToArray(ans) ;
    }

    public void InitDict(){
        dict.add("색인번호 통일을 위해 0번 인덱스 비워두기");
        for(int i =65; i <= 90; i++){dict.add(String.valueOf((char)i));}  
    }
    
    public StringBuilder FindDict(StringBuilder sb){
        while(!dict.contains(sb.toString())){
            sb.setLength(sb.length()-1);
        }
        return sb;
    }
    public void AddLongerWord(StringBuilder w, StringBuilder sb){
        if(sb.length()==0){return;}
        else{
            StringBuilder wc = new StringBuilder(w);
            wc.append(sb.charAt(0));
            dict.add(wc.toString());
        }
    }
    public int[] ListToArray(List<Integer> ans){
        int[] answer = new int[ans.size()];
        int idx =0;
        for(int i : ans){answer[idx++] = i;}
        return answer;
    }
}
import java.util.*;
class Solution {
    List<String> split = new ArrayList<>();
    public int solution(String dartResult) {
        int answer = 0; 
        makeScoreList(dartResult);
        
        List<Integer> scoreBonus = new ArrayList<>();
        for(int i =0; i < split.size();i++){
            String temp = split.get(i);
            
            if(temp.length()>=2){  // 점수 입력 및 보너스 반영
                int score = temp.charAt(0)-'0'; char bonus = temp.charAt(1);
                if(temp.length()==3){score =10; bonus = temp.charAt(2);}
                
                switch(bonus){
                    case 'S' : scoreBonus.add(score); break;
                    case 'D' : scoreBonus.add(score*score); break;
                    case 'T' : scoreBonus.add(score*score*score); break;
                }
            }
            
            else { // [옵션] 아차상 및 스타상 반영
                if(temp.equals("#")){ // 아차상일 경우 마지막 요소 -1
                    int targetIdx = scoreBonus.size()-1;
                    scoreBonus.set(targetIdx, scoreBonus.get(targetIdx)*(-1));
                }
                else{ // 스타상일 경우 길이 반영하여 점수 2배 반영
                    if(scoreBonus.size()>=2){ 
                        int targetIdx1 = scoreBonus.size()-1;
                        int targetIdx2 = scoreBonus.size()-2;
                        scoreBonus.set(targetIdx1, scoreBonus.get(targetIdx1)*2);
                        scoreBonus.set(targetIdx2, scoreBonus.get(targetIdx2)*2);
                    }
                    else{
                        int targetIdx1 = scoreBonus.size()-1;
                        scoreBonus.set(targetIdx1, scoreBonus.get(targetIdx1)*2);
                    }
                }
            }
        }
        for(int i : scoreBonus){
            answer += i;
        }
        return answer;
    }
    
    public void makeScoreList(String dartResult){
        StringBuilder sb;
        for(int i=0; i < dartResult.length();i++){
            char ch = dartResult.charAt(i); sb = new StringBuilder();
            
            if(Character.isDigit(ch)){
                sb.append(ch);
                sb.append(dartResult.charAt(i+1));
                if(sb.toString().equals("10")){sb.append(dartResult.charAt(i+2)); i++;}
                split.add(sb.toString());
            }
            else if((ch=='*')||(ch=='#')){
                sb.append(ch);
                split.add(sb.toString());
            }
        }
    }
}
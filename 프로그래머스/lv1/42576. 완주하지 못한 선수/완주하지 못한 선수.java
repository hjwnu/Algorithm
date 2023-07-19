import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String comple : completion){
            map.put(comple, map.getOrDefault(comple,0)+1); // 동명이인 고려하여 완주 선수 명단 재구성
        }
        
        for(String name :  participant){
            if(!map.containsKey(name)){ answer = name; break;} // 완주 못한 선수 있으면 바로 반환.
            else{
                if(map.get(name)==1){map.remove(name);} // 동명이인이 없다면, 참가자 = 완주선수 체크
                else{map.put(name, map.get(name)-1);} // 동명이인이 있다면, 참가자에서 한 명만 체크
            }
        }
        return answer;
    }
}
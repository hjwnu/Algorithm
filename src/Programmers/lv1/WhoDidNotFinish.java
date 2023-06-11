package Programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class WhoDidNotFinish {
    public static void main(String[] args) {
        String[] all = new String[]{"mislav", "stanko", "mislav", "ana","ana"};
        String[] finish = new String[]{"stanko", "ana", "mislav", "mislav"};
        System.out.println(solution(all,finish));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(String comple : completion){
            map.put(comple, map.getOrDefault(comple,0)+1);
        }
        for(String name :  participant){
            if(map.containsKey(name)){
                if(map.get(name)==1){
                    map.remove(name);
                }
                else{map.put(name, map.get(name)-1);}
            }
            else{ answer = name; }
        }
        return answer;
    }
}

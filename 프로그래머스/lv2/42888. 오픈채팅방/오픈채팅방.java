import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[][] split = new String[record.length][3];
        for(int i =0; i < record.length;i++){
            split[i] = record[i].split(" "); // ["Enter","uid1234","Muzi"] 형태로 쪼개기
        }
        
        Map<String, String> map = new HashMap<>();// Map("uid1234", "Muzi") 형태로 저장
        for(int i=0; i < split.length;i++){ // 변경된 아이디는 맨 마지막 아이디로 대체하여 저장
            if(split[i].length==3){map.put(split[i][1],split[i][2]);}
        }
        
        // 맵에서 아이디(키값)으로 닉네임을 뽑아와 Enter, Leave만 필터링하여 저장
        List<String> answer = new ArrayList<>(); 
        for(int i =0 ; i < split.length;i++){
            if(split[i][0].equals("Enter")){
                answer.add(String.format("%s님이 들어왔습니다.", map.get(split[i][1])));
            }
            else if(split[i][0].equals("Leave")){
                answer.add(String.format("%s님이 나갔습니다.", map.get(split[i][1])));
            }
        }
        
        // List to Array
        String[] ans = new String[answer.size()];
        for(int i =0; i< answer.size();i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
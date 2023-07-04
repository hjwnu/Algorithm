import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[][] split = new String[record.length][3];
        for(int i =0; i < record.length;i++){
            split[i] = record[i].split(" ");
        }
        
        Map<String, String> map = new HashMap<>();
        for(int i=0; i < split.length;i++){
            if(split[i].length==3){map.put(split[i][1],split[i][2]);}
        }
        
        List<String> answer = new ArrayList<>();
        
        for(int i =0 ; i < split.length;i++){
            if(split[i][0].equals("Enter")){
                answer.add(String.format("%s님이 들어왔습니다.", map.get(split[i][1])));
            }
            else if(split[i][0].equals("Leave")){
                answer.add(String.format("%s님이 나갔습니다.", map.get(split[i][1])));
            }
        }
        
        String[] ans = new String[answer.size()];
        for(int i =0; i< answer.size();i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
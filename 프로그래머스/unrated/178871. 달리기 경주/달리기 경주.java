import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
       int idx; String temp;
        Map<String, Integer> map = new HashMap<>();
        for (int i =0 ; i < players.length;i++){
            map.put(players[i],i);
        }
        for(int i =0 ; i < callings.length;i++ ){
            idx = map.get(callings[i]);
            temp = players[idx];
            players[idx] = players[idx-1];
            players[idx-1] = temp;
            for (int j =idx-1 ; j <= idx;j++){
            map.put(players[j],j);
        }
        }
        
        return players;
    }
}
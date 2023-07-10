import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        Map<Integer, Integer> idx = new HashMap<>();
        int[] temp = Arrays.copyOfRange(emergency,0,emergency.length);
        Arrays.sort(temp);
        int rank = emergency.length;
        for(int i =0 ; i < emergency.length;i++){
            idx.put(temp[i],rank--);
        }
        
        
        int[] answer = new int[emergency.length];
        for(int i =0;i < emergency.length;i++){
            answer[i] = idx.get(emergency[i]);
        }
        
        return answer;
    }
}
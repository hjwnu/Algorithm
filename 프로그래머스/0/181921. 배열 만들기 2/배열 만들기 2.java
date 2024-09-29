import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        while(l%5 != 0){
            l++;
        }
        while(r%5 != 0){
            r--;
        }
        
        for(int i = l; i <= r; i+=5){
            String str = String.valueOf(i);
            boolean canAdd = true;
            for(int j = 0; j < str.length();j++){
                if(str.charAt(j) != '0' && str.charAt(j) != '5'){
                    canAdd = false;
                    break;
                }
            }
            if(canAdd){
                result.add(i);
            }
        }
        
        if(result.size()==0){
            return new int[]{-1};
        }
        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
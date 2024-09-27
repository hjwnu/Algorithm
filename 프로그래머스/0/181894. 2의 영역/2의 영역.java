import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> tempList = new ArrayList<>();
        for(int i : arr){
            tempList.add(i);
        }
        
        int start = tempList.indexOf(2);
        int end = tempList.lastIndexOf(2);
        
        if(start == -1){
            return new int[]{-1};
        }
        
        int len = end-start+1;
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++){
            answer[i] = arr[i+start];
        }
        return answer;
    }
}
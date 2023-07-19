import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
    
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0; i<numbers.length;i++){
            for (int j = 0; j <numbers.length;j++){
                if(temp.contains(numbers[i]+numbers[j])) {continue;}
                if(i!=j) {temp.add(numbers[i]+numbers[j]);}
            }
        }
        
        int[] ans = new int[temp.size()]; int idx=0;
        for(int k : temp){ans[idx] = k; idx++;}
        Arrays.sort(ans); 
        
        return ans;
    }
}
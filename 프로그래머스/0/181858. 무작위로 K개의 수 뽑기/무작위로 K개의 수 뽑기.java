import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(!list.contains(i)){
                list.add(i);
            }
            if(list.size() == k) {
                break;
            }
        }
        while(list.size() < k){
            list.add(-1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
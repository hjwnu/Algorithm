import java.util.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = new int[]{};
        switch(n){
            case 1: return Arrays.copyOfRange(num_list, 0, slicer[1]+1);
            case 2: return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
            case 3: return Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1);
            case 4: 
                List<Integer> tmp = new ArrayList<>();
                int idx =0;
                for(int i = slicer[0]; i < slicer[1]+1;i+=slicer[2]){
                    tmp.add(num_list[i]);
                }
                answer = new int[tmp.size()];
                for (int i = 0 ; i < tmp.size();i++){
                    answer[i] = tmp.get(i);
                }
                break;
        }
        return answer;
    }
}
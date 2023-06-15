import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] rest = new int[speeds.length+1];
        for(int i =0 ; i < speeds.length;i++){
            double a = 100-progresses[i];
            double b = speeds[i];
            rest[i] = (int)Math.ceil(a/b);
        }
        rest[rest.length-1] = 100;
        List<Integer> ansLi = new ArrayList<>();
        for(int i =1 ; i < rest.length;i++){
            if(rest[0]<rest[i]){
                ansLi.add(i);
                rest = Arrays.copyOfRange(rest, i,rest.length);
                i=0;
            }       
        }
        int[] ans = new int[ansLi.size()];
        for(int i =0; i<ansLi.size();i++){
            ans[i] = ansLi.get(i);
        }
        return ans;
    }
}
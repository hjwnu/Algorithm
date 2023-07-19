import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int idx =0;
        for(int i : d){
            budget -= i; idx++;
            if(budget < 0) {idx--; break;}
        }
        return idx;
    }
}
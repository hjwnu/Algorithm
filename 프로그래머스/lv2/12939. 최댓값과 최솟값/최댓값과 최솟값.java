import java.util.stream.*;
import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] S = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String str : S){
            int i = Integer.valueOf(str);
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        return min + " " + max;
    }
}
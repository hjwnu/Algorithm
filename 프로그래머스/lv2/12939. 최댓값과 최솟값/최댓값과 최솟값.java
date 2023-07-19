import java.util.stream.*;
import java.util.Arrays;
class Solution {
    public String solution(String s) {
        String[] S = s.split(" ");
        
        int max = Arrays.stream(S).mapToInt(Integer::parseInt).max().getAsInt();
        int min = Arrays.stream(S).mapToInt(Integer::parseInt).min().getAsInt();
        return min + " " + max;
    }
}
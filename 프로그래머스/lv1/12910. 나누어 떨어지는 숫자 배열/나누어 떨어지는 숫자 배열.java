import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] ans = Arrays.stream(arr).filter(a -> a%divisor==0).sorted().toArray();
        return ans.length==0? new int[]{-1}:ans;
    }
}
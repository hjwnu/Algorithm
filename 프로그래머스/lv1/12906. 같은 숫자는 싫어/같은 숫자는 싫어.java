import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> ans = new LinkedList<Integer>();
        ans.add(arr[0]);
        for ( int i = 1 ; i< arr.length;i++){
            if(arr[i-1]!=arr[i]){ans.add(arr[i]);}
        }
        int[] result = new int[ans.size()];
        int idx = 0;
        for (int num : ans) {result[idx++] = num;}
        return result;
    }
}
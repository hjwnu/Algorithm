import java.util.*;
class Solution {
    public int solution(int[] nums) {
        List<Integer> distinct = new ArrayList<>();
        for(int i : nums){
            if(!distinct.contains(i)) { distinct.add(i); } // 중복되지 않은 폰켓몬 저장
        }
        int ans = nums.length; // 모든 경우의 수를 포함한 최댓값
        return ans/2 >= distinct.size() ? distinct.size(): ans/2; // 고를 수 있는 최댓값을 넘지 않도록.
    }
}
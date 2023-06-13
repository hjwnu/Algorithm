import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // 문자열을 길이에 따라 그룹화하고 개수를 카운트
        for (String str : strArr) {
            int length = str.length();
            countMap.put(length, countMap.getOrDefault(length, 0) + 1);
        }
        
        // 가장 개수가 많은 그룹의 크기 찾기
        int maxCount = 0;
        for (int count : countMap.values()) {
            maxCount = Math.max(maxCount,count);
        }
        
        return maxCount;
    }
}
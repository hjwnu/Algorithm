import java.util.*;
class Solution {
     public static int solution(int[] citations) {
        HashMap<Integer, Integer> h = new HashMap<>();
        Arrays.sort(citations);
        for(int i=0 ; i < citations.length;i++) {
            int min = citations[i];
            if(!h.containsKey(min)){
                int cnt = 0;
                for (int j = 0; j < citations.length; j++) {
                    if (citations[j] >= min) {cnt++;}
                    h.put(min, cnt);
                }
            }
        }
        List<Integer> max =new ArrayList<>();
        for(int key : h.keySet()) {
            if (key <= h.get(key)) { max.add(key);} 
            else {max.add(h.get(key));}
        }
         
        int answer = max.get(0);
        for( int i : max){answer = Math.max(answer,i);}

        return answer;
    }
}
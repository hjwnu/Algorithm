import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> score = new HashMap<>();
        String[] arr = {"RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA"};

        for (int i = 0; i < survey.length; i++) { 
            int idx = Arrays.asList(arr).indexOf(survey[i]);
            if (idx % 2 == 0) {
                score.put(survey[i], score.getOrDefault(survey[i], 0) + (choices[i] - 4)); // 1~7점이 아닌 -3~3점. 마이너스일 경우 왼쪽 글자.
            } else {
                score.put(arr[idx - 1], score.getOrDefault(arr[idx-1], 0) - (choices[i] - 4)); // 사전순서가 반대일 경우 올바른 사전순서로 바꾸고, 점수도 뒤집어서. ("TR" -> "RT"), (7(R에 3점) -> -7(R에 3점))
            }
        }
        
        String[] ans = {"R","C","J","A"};
        for(Map.Entry<String, Integer> key : score.entrySet()){ // 저장된 맵 키에 따라 변환
            if(key.getKey().startsWith("R")){ ans[0] = key.getValue() > 0? "T":"R"; }
            if(key.getKey().startsWith("C")){ ans[1] = key.getValue() > 0? "F":"C"; }
            if(key.getKey().startsWith("J")){ ans[2] = key.getValue() > 0? "M":"J"; }
            if(key.getKey().startsWith("A")){ ans[3] = key.getValue() > 0? "N":"A"; }
        }
        return String.join("",ans);
}
}
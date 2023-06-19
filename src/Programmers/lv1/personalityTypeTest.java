package Programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class personalityTypeTest {
    public static void main(String[] args) {
       String[] a= {"TR", "RT", "TR"};
       int[] b = {7, 1, 3};
        System.out.println(solution(a,b));
    }

    public static String solution(String[] survey, int[] choices) {
        double start = System.nanoTime();
        Map<String, Integer> score = new HashMap<>();
        String[] arr = {"RT", "TR", "CF", "FC", "JM", "MJ", "AN", "NA"};

        for (int i = 0; i < survey.length; i++) { // 사전순서대로 짜인 성격배열만 맵으로.
            int idx = Arrays.asList(arr).indexOf(survey[i]);
            if (idx % 2 == 0) {
                score.put(survey[i],score.getOrDefault(survey[i], 0) + (choices[i] - 4));
            } else {
                score.put(arr[idx - 1],score.getOrDefault(arr[idx-1], 0) - (choices[i] - 4));
            }
        }
        String[] ans = {"R","C","J","A"};
        for(Map.Entry<String, Integer> key : score.entrySet()){ // 저장된 맵 키에 따라 변환
            if(key.getKey().startsWith("R")){ ans[0] = key.getValue() > 0? "T":"R"; }
            if(key.getKey().startsWith("C")){ ans[1] = key.getValue() > 0? "F":"C"; }
            if(key.getKey().startsWith("J")){ ans[2] = key.getValue() > 0? "M":"J"; }
            if(key.getKey().startsWith("A")){ ans[3] = key.getValue() >0? "N":"A"; }
        }
        double end = System.nanoTime();
        System.out.println((end-start)/1000);
        return String.join("",ans);
    }
}

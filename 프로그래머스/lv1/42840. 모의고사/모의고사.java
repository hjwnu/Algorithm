import java.util.*;
class Solution {
    public static int[] solution(int[] answers) {
        int[] su1 = {1,2,3,4,5};
        int[] su2 = {2,1,2,3,2,4,2,5};
        int[] su3 = {3,3,1,1,2,2,4,4,5,5};
        int[] ans = new int[3];
        
        //각각 번호 찍는 방식으로 맞춘 정답 갯수 count
        for(int i = 0; i < answers.length;i++){
            if(answers[i]==su1[i%su1.length]){ans[0]++;}
            if(answers[i]==su2[i%su2.length]){ans[1]++;}
            if(answers[i]==su3[i%su3.length]){ans[2]++;}
        }
        
        // 가장 많이 맞춘 갯수
        int max = Math.max(Math.max(ans[1],ans[2]),ans[0]);
        
        // 가장 많이 맞춘 사람이 여러 명일 경우, 배열 길이 지정은 어려움.
        List<Integer> li = new ArrayList<>();
        for(int j = 0 ; j <ans.length ; j++){
            if(ans[j]==max){ li.add(j+1);}
        }
        
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);

        }

        return result;
    }
}

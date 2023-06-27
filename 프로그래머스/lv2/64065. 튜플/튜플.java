import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] tmp = s.split("\\},\\{"); // 집합 기호 정리 1

        tmp[0]=tmp[0].replaceAll("[{}]",""); // 집합 기호 정리 2
        tmp[tmp.length-1]=tmp[tmp.length-1].replaceAll("[{}]",""); // 집합기호 정리 3

        String[][] temp = new String[tmp.length][]; 
        for(int i =0 ; i < temp.length;i++){
            String[] len = tmp[i].split(","); 
            temp[len.length-1] = len;      // 임시배열에 담긴 길이 순서대로 정렬하면서 2차원배열에 저장
        }
        
        String[] ans = new String[temp.length]; // 중복 제외 저장
        for(int i =0 ; i < temp.length;i++){
            for(int j = 0; j < temp[i].length;j++){
                if(!Arrays.asList(ans).contains(temp[i][j]))
                ans[i] = temp[i][j];
            }
        }
        
        int[] answer = new int[ans.length]; // int배열 변환
        for(int i =0 ; i < ans.length;i++){
            answer[i] = Integer.parseInt(ans[i]);
        }
            
        
        return answer;
        
        
        
//return new int[]{Integer.parseInt(s.substring(2,s.length()-2))}; // 집합원소 1개일때 출력
    }
}
package Programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GetReportResults {
    public static void main(String[] args) {

        String[] a = {"muzi", "frodo", "apeach", "neo"};
        String[] b = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi", "frodo neo"};
        int k = 2;

        System.out.println(Arrays.toString(solution(a,b,k)));
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        String[][] temp = new String[report.length][2];
        Map<String, Integer> ans = new HashMap<>();
        for( int i =0; i < report.length;i++){
            temp[i] = report[i].split(" ");
        }
        for(String str : id_list){
            ans.put(str, 0);
        }
        for(int i =0; i < temp.length;i++){
            ans.put(temp[i][1], ans.get(temp[i][1])+1);
        }
        int[] answer = new int[ans.size()];
        int idx=0;
        for( Map.Entry<String, Integer> entry : ans.entrySet()){
            answer[idx] = entry.getValue(); idx++;
        }
        return answer;
    }
}

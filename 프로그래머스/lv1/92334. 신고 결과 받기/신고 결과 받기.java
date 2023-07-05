import java.util.*;
class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        report = Arrays.stream(report).distinct().toArray(String[]::new); // 한 사람이 같은 사람 반복신고 X
        Map<String, Integer> index = new HashMap<>();
        for(int i =0; i <id_list.length;i++){ // id_list 인덱스 저장
            index.put(id_list[i],i);
        }

        String[][] split = new String[report.length][2];

        for( int i =0; i < report.length;i++){
            split[i] = report[i].split(" ");
        }

        Map<String, Integer> reported = new HashMap<>();  // 신고한 사람과 신고받은 사람 구분
        for(int i =0; i < split.length;i++){
            reported.put(split[i][1], reported.getOrDefault(split[i][1],0)+1);  // 신고 받은 사람 + 횟수
        }

        int[] answer = new int[id_list.length]; // 결과메일 수신횟수 배열

        for( Map.Entry<String, Integer> entry : reported.entrySet()){
            int reportNum = entry.getValue(); // 신고받은 횟수
            
            if(reportNum >= k){ // 
                String theReported = entry.getKey(); // k번 이상 신고받은 사람.  entry.getKey() == split[i][1].
                
                for(int i =0; i < split.length;i++){
                    if(split[i][1].equals(theReported)){
                        answer[index.get(split[i][0])]++; // index.get(split[i][0]) == 신고자 인덱스
                    }
                }
            }
        }

        return answer;
    }
    }

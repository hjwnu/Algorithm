import java.util.*;
class Solution {
    public static int solution(int[] prior, int loca) {
        //리스트 역순 정렬
        List<Integer> order = new ArrayList<>(); 
                for(int i : prior){order.add(i);}
        Collections.sort(order,Collections.reverseOrder());
        
        Queue<Integer> ans = new LinkedList<>();  // 실행순서 큐 = 실제 실행되는 순서
        for(int i : order){ans.add(i);}
        
        //각 인덱스에 실행순서대로 숫자매기기
        int pri = 1;
        int[] answer = new int[prior.length];
        for(int i =0; i < prior.length;i++){
            if(ans.peek()==prior[i]){ 
                answer[i] = pri; pri++; ans.poll(); 
                if(ans.isEmpty()) break;
            }
            if(i == prior.length-1){ i = -1;}
        }
        return answer[loca];
    }
}
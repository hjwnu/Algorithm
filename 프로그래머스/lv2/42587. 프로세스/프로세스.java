import java.util.*;
class Solution {
    public static int solution(int[] prior, int loca) {
        Queue<Integer> ans = new LinkedList<>();  // 실행순서 큐 = 실제 실행되는 순서
        
        //Queue를 이용한 역순정렬 큐        
        Queue<Integer> order = new LinkedList<>();        
        for(int i : prior){order.add(i);}
        int max =0;
        while(!order.isEmpty()){
            for(int i : order){max = Math.max(i,max);}
            if(order.peek()!=max){order.add(order.poll());}
            else{ ans.add(order.poll()); max =0; }
        }
        
        //리스트 역순 정렬
//         List<Integer> order = new ArrayList<>(); 
//                 for(int i : prior){order.add(i);}
//         Collections.sort(order,Collections.reverseOrder());
//         for(int i : order){ans.add(i);}
        

        
        
        
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
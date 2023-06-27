import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minq = new PriorityQueue<>();
        Queue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0 ; i < operations.length;i++){
            String[] tmp = operations[i].split(" ");
            String guide = tmp[0]; int value = Integer.parseInt(tmp[1]);
            switch(guide){
                case "I": minq.add(value);maxq.add(value); break;
                case "D":   // 큐가 비어있으면 연산 무시, 한쪽이 비어있으면 다른쪽도 비어있음
                    if(!minq.isEmpty()){ 
                        if(value<0){int min = minq.poll(); maxq.remove(min);} // 최솟값 삭제
                        else{int max = maxq.poll(); minq.remove(max);} // 최댓값 삭제
                    }
            }
        }
        return minq.size()>0?new int[]{maxq.poll(),minq.poll()}:new int[2];
    }
}
// deque를 이용하려 했으나, 매 순간 삽입되는 수가 현재 큐의 요소와 비교하여 최소||최대 값이 아닐 경우 오류가 발생하게 됨.
// 제출 시 테스트6 실패.

//         Deque<Integer> q = new ArrayDeque<>();
//         String[][] tmp = new String[operations.length][2];
//         for(int i =0 ; i < operations.length;i++){
//             tmp[i] = operations[i].split(" ");            
//                 if(tmp[i][0].equals("I")){
//                     if(q.isEmpty()){q.addFirst(Integer.parseInt(tmp[i][1]));}
//                     else if(Integer.parseInt(tmp[i][1])>q.peekFirst()) { // 크면 뒤에서
//                         q.addLast(Integer.parseInt(tmp[i][1]));
                        
//                     } else {q.addFirst(Integer.parseInt(tmp[i][1]));} // 작으면 앞에서
//                 }
//                 else{
//                     if(!q.isEmpty()){
//                     if(Integer.parseInt(tmp[i][1])<0){q.pollFirst();} // 최솟값 삭제
//                     else{q.pollLast();} //최댓값 삭제
//                     }
//                 }
//         }
//         int[] answer = q.size()>0? new int[]{q.pollLast(),q.pollFirst()}:new int[2];
        
//         return answer;
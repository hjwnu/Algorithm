import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 각 배열 큐로 전환
        Queue<String> card1 = new LinkedList<>(); for(String str : cards1){card1.add(str);}
        Queue<String> card2 = new LinkedList<>(); for(String str : cards2){card2.add(str);}
        Queue<String> goals = new LinkedList<>(); for(String str : goal){goals.add(str);}
       
        // 카드들이 모두 소진됐거나, 골을 완성했으면 종료
        // 한쪽 카드가 모두 소진된 상태에서 다른 한 쪽이 goal과 맞지 않다면 종료
        while((!card1.isEmpty()&&!card2.isEmpty())||!goals.isEmpty()){
            if(!card1.isEmpty()){
                if(goals.peek().equals(card1.peek())){
                    goals.poll(); card1.poll();
                }
                else if(card2.isEmpty()){break;}
            }
            if(!card2.isEmpty()){
                if(goals.peek().equals(card2.peek())){
                    goals.poll(); card2.poll();
                }
                else if(card1.isEmpty()){break;}
            }
            if(goals.isEmpty()){break;}
        }
        return goals.isEmpty()? "Yes":"No";
    }
}
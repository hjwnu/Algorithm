package Programmers.lv2;

import java.util.*;

public class Process {
    public static void main(String[] args) {
        List<Integer> order = new ArrayList<>();
        int[] c = {1, 1, 2, 3, 2, 1};

        for (int i : c) {
            order.add(i);
        }

        Collections.sort(order,Collections.reverseOrder());
        System.out.println(order);
    }
    public static int solution(int[] prior, int loca) {
        Queue<Integer> order = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> ans = new LinkedList<>();
        for(int i : prior){
            order.add(i);
        }
        System.out.println(order);
        int max =0;
        while(!order.isEmpty()){
            for(int i : order){max = Math.max(i,max);}
            if(order.peek()!=max){order.add(order.poll());}
            else{ ans.add(order.poll()); max =0; }
        }
        int pri = 1;
        int[] answer = new int[prior.length];
        for(int i =0; i < prior.length;i++){
            if(ans.peek()==prior[i]){ answer[i] = pri; pri++; ans.poll(); if(ans.isEmpty()) break;}
            if(i == prior.length-1){ i = -1;}

        }
        return answer[loca];
    }
}
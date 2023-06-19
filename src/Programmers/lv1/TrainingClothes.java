package Programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrainingClothes {
    public static void main(String[] args) {
        System.out.println(solution(30,new int[]{3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 16, 18, 20, 21, 24, 25, 27, 28, 30},new int[]{1, 2, 3, 4, 5, 6, 7, 8, 29}));
    }
        public static int solution(int n, int[] lost, int[] reserve) {
            // 여벌 체육복을 가져온 학생이 도난당한 경우 선별 후 인원수 세기.
            List<Integer> dupl = new ArrayList<>();
            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) { if (lost[i] == reserve[j]) {dupl.add(lost[i]); break;} }
            }
            int distinct = lost.length - dupl.size();
            if (distinct == 0) return n; // 도난당한 모든 학생이 여벌을 갖고있었다면 그대로 총인원 리턴
            if (dupl.size() == reserve.length) return n-distinct; // 여벌 가진 모든 학생이 도난 당했다면 총인원 - 여벌 없는 도난 당한 학생 리턴

            // 위 케이스 배제하며 우선순위 큐로 저장
            Queue<Integer> lo = new PriorityQueue<>();
            Queue<Integer> re = new PriorityQueue<>();
            for (int i : lost) { if(!dupl.contains(i)) lo.add(i); }
            for (int i : reserve) { if(!dupl.contains(i)) re.add(i); }

            // 여벌 빌려줄 수 있는 케이스
            int cnt = 0;
            while (lo.size() != 0 && re.size() != 0) {
                int a = lo.poll();
                if (re.peek() + 1 == a || re.peek() - 1 == a) {
                    re.poll();
                    cnt++;
                }
            }
            return n - distinct + cnt;
        }
}
package Programmers.lv2;

import java.util.*;
/*
문제 설명
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

제한사항
과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 */
public class H_Index {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,4,4,5,6,7,7,7,7,7,8,8,9,9,9,9,10,10,11,11};
        System.out.println(solution(a));
        System.out.println(solution2(a));
    }

    public static int solution(int[] citations) {
        double start = System.nanoTime();
        HashMap<Integer, Integer> h = new HashMap<>();
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int min = citations[i];
            if (h.containsKey(min)) {
                continue;
            } else {
                int cnt = 0;
                for (int j = 0; j < citations.length; j++) {
                    if (citations[j] >= min) cnt++;
                    h.put(min, cnt);
                }
            }
        }
        List<Integer> max = new ArrayList<>();
        for (int key : h.keySet()) {
            if (key <= h.get(key)) {
                max.add(key);
            } else {
                max.add(h.get(key));
            }
        }
        int answer = max.get(0);
        for (int i : max) {
            answer = Math.max(answer, i);
        }
        double end = System.nanoTime();
        System.out.printf("%fms\n", (end-start)/1000000);

        return answer;
    }

// 이중for문으로 인한 시간복잡도 개선. 처음 접근법 그대로 조금만 고민했으면 아래처럼 바로 만들 수 있었을듯..
    public static int solution2(int[] citations) {
        double start = System.nanoTime();
    int max =0;
    Arrays.sort(citations);
       for(int i = citations.length-1; i>=0; i--) {
           int min = Math.min(citations[i], citations.length - i);
           if(max < min) max = min;
           if(max > min) break;
        }
       double end = System.nanoTime();
        System.out.printf("%fms\n", (end-start)/1000000);
        return max;
    }
}
package Programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 */
public class PracticeTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5,2,1,2,4,1,1,2,3,4,5,1,2,5,1,2,3,5,1,5,3,4,5,1,5,1,5};

        System.out.println(Arrays.toString(solution(a)));
    }

    public static int[] solution(int[] answers) {
        int[] su1 = {1,2,3,4,5};
        int[] su2 = {2,1,2,3,2,4,2,5};
        int[] su3 = {3,3,1,1,2,2,4,4,5,5};
        int[] ans = new int[3];

        int idx1 =0, idx2 =0, idx3=0;
        for(int i = 0; i < answers.length;i++){
            if(answers[i]==su1[i%su1.length]){ans[0] ++;}
            if(answers[i]==su2[i%su2.length]){ans[1] ++;}
            if(answers[i]==su3[i%su3.length]){ans[2] ++;}
        }

        int max = Math.max(Math.max(ans[1],ans[2]),ans[0]);

        List<Integer> li = new ArrayList<>();
        for(int j = 0 ; j <ans.length ; j++){
            if(ans[j]==max){ li.add(j+1);}
            System.out.println(ans[j]);
        }
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i);

        }

        return result;
    }
}

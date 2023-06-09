package Programmers.lv2;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(18,6)));
    }
    public static int[] solution(int brown, int yellow){
        int total = brown+yellow;
//        if(total/(yellow+2) == 3){    // brown 18, yellow 6 같은 문제를 해결하기 위해 넣은 추가 조건문이지만, 여전히 특정 테케에서 실패함.
//         return new int[]{total/3,3}; // 갈아엎고 다시 생각해야함.
//        }
//     근의 공식을 이용한 풀이법도 한번 생각해보겠음
        int[] ans = new int[2];
        for(int i = total-1; i >0; i--){
            if(total%i==0&& total/i >= i){
                    ans[0] = total / i;
                    ans[1] = i;
                if(yellow==(ans[0]-2)*(ans[1]-2)) {
                    break;
                }
                }
        }
         return ans;
    }
}

package Programmers.lv2;

import java.util.Arrays;

public class JoyStick {
    public static void main(String[] args) {
        String name = "AAB";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] alpha = str.split("");
        String[] n = name.split("");


        //글자변경(상하이동) 최소 횟수
        int ans = n.length-1;
        for (String ch : n){
            ans+= Math.min(Arrays.asList(alpha).indexOf(ch),26-Arrays.asList(alpha).indexOf(ch));
        }

        //자리변경(좌우이동) 최소 횟수.

        // 구현 필요. 로직도 안떠오름
        return ans;
    }
}

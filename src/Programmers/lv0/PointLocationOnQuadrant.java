package Programmers.lv0;

import java.util.Arrays;

public class PointLocationOnQuadrant {
    public static void main(String[] args) {
        int[] dot1 = new int[]{2,4};
        int[] dot2 = new int[]{-7,9};
        int[] dot3 = new int[]{-10,-11};
        int[] dot4 = new int[]{3,-2};
        System.out.printf("%s is on %d%n", Arrays.toString(dot1), solution(dot1));
        System.out.printf("%s is on %d%n", Arrays.toString(dot2), solution(dot2));
        System.out.printf("%s is on %d%n", Arrays.toString(dot3), solution(dot3));
        System.out.printf("%s is on %d%n", Arrays.toString(dot4), solution(dot4));
    }
    public static int solution(int[] dot) {
        int answer;
        int n = dot[1] > 0 ? 1 : 2;
        if (dot[0]*dot[1] > 0){
            answer = 2*n-1;
        }
        else {
            answer = 2*n;
        }
        return answer;
    }
}

import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
    List<Integer> li = Arrays.asList(a,b,c,d);
        int[] A = li.stream().distinct().mapToInt(i->i).toArray();
        int p = (int) Arrays.stream(A).count();
        int answer = 0;
        int[] B = li.stream().filter(i -> Collections.frequency(li, i) > 1).mapToInt(i->i).toArray();
        if(B.length!=3) {
            switch (p) {
                case 1:
                    answer = a * 1111;
                    break;
                case 2:
                    answer = (int) Arrays.stream(A).reduce(0, Integer::sum) * (int) Math.abs(Arrays.stream(A).reduce(0, (x, y) -> -x + y));
                    break;
                case 3:
                    answer = Arrays.stream(A).filter(i -> i != B[0]).reduce(1, (x, y) -> x * y); 
                    break;   
                case 4:
                    answer = Arrays.stream(A).min().getAsInt();
                    break;
            }
        }
        else{
            if(B[0]==A[0]){
            answer = (B[0]*10+A[1]);
            answer = answer*answer;}
            else{
                answer = B[0]*10+A[0];
                answer = answer *answer;
            }
        }
        return answer;
    }
}
package lv0;

public class Ordered_Pair {
    public static void main(String[] args) {
        for(int i =0; i <= 10000;i++){
            System.out.println(i + " => "+solution(i) + "\n");
        }
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <=n/2;i++){
            if(n%i==0){
                answer++;
            }
        }
        return answer+1;
    }
}

package Programmers.lv0;

public class Discount {
    public static void main(String[] args) {
        for(int i = 10; i <= 1000010; i+=100000){
            System.out.println(solution(i));
        }
    }
    public static int solution(int price) {
        int answer;

        if(price >= 500000){
            answer = price*4/5;
            }
        else if(price >= 300000){
            answer = price *9/10;
            }
        else if (price >= 100000){
            answer = price * 19/20 ;
            }
        else {
            answer = price;
            }
        return answer;
    }

}

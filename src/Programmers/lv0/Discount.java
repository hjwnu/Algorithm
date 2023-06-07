package Programmers.lv0;
/*
머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.

10 ≤ price ≤ 1,000,000
price는 10원 단위로(1의 자리가 0) 주어집니다.
소수점 이하를 버린 정수를 return합니다.
 */
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

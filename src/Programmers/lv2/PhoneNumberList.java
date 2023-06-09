package Programmers.lv2;
/*
문제 설명
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
같은 전화번호가 중복해서 들어있지 않습니다.
 */
public class PhoneNumberList {
    public static void main(String[] args) {
        String[] a = {"123", "456", "789"};
        System.out.println(solution(a));
    }
    public static boolean solution(String[] phone_book) {
    return false;
    }
}
//    public static boolean solution2(String[] phone_book) {
//        int idx =0, cnt =0, a=-1;
//        while(a!=0) {
//            if (idx == phone_book.length) break;
//            if (cnt == phone_book.length) {
//                idx++; if (idx == phone_book.length) break;
//                cnt = cnt-idx;
//            }
//            if (idx == cnt) {
//                cnt++;
//            } else {
//                if (phone_book[idx].length() > phone_book[cnt].length()) {
//                    a = phone_book[idx].indexOf(phone_book[cnt]);
//                    cnt++;
//                } else {
//                    a = phone_book[cnt].indexOf(phone_book[idx]);
//                    cnt++;
//                }
//            }
//        }
//        return a!=0;
//    }
//        }
//    public static boolean solution1(String[] phone_book) {
//        int a = -1;
//        for (int i = 0; i < phone_book.length; i++) {
//            if(a==0) break;
//            for (int j = 1; j < phone_book.length; j++) {
//                if(i!=j){
//                    if (phone_book[i].length() > phone_book[j].length()) {
//                    a = phone_book[i].indexOf(phone_book[j]);  if(a==0) break;
//                } else {
//                    a = phone_book[j].indexOf(phone_book[i]);  if(a==0) break;
//                }
//                }
//            }
//        }
//        return a == 0? false:true;
//    }


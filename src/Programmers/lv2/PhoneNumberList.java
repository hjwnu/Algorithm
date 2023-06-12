package Programmers.lv2;

import java.util.*;

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
        String[] a = {"111", "1005", "1006","1000"};
        String[] b = {"123", "1246", "1234", "1235"};
        String[] c = {"119", "97674223", "1195524421"};
        String[] d = {"123","456", "7123"};
        System.out.println(solution(b));
    }

    public boolean solution(String[] phoneBook) {

        Arrays.sort(phoneBook); // 접두어를 찾는 문제이므로, 오름차순으로 정렬하면 가장 근접해 있을 것이다.
        boolean result = true;

        for (int i = 0; i < phoneBook.length -1 ; i++){
            if(phoneBook[i + 1].startsWith(phoneBook[i])){result = false; break;}
        }
        return result;
    }
//    psvm에 작성한 테스트케이스 a와 같은 경우를 지속적으로 실패한다. 이 로직으로 특정 케이스를 함께 커버하는 방법을 생각해보았으나, 다른 로직을 생각해 보기로 했다.
//    public static boolean solution3 (String[] phone_book) {
//        int min = 20;
//        for(int i =0; i < phone_book.length;i++){
//            min = Math.min(min, phone_book[i].length());
//        }
//        Map<String, Integer> map = new HashMap<>();
//        map.put(phone_book[0].substring(0,min),0);
//
//        for(int i = 1; i < phone_book.length;i++){
//
//            String temp = phone_book[i].substring(0,min);
//            map.put(temp,map.getOrDefault(map.get(temp),0));
//        }
//        return map.size()==phone_book.length;
//    }

}
//   효율성 테스트 3,4 실패. 로직은 그대로 두고, 중첩반복문을 회피하기 위한 변칙적인 단일 반복문으로는 아무래도 시간복잡도 해결이 안되나보다.
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
//  이중for문으로 인해 시간복잡도 극악인 듯 하다.
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


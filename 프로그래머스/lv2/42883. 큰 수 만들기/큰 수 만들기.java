import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        int remain = n - k;  // 만들어야 할 결과 숫자의 자릿수

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char digit = number.charAt(i);
            // 스택에 숫자가 있고, 현재 탐색 중인 숫자보다 작은 숫자가 스택에 있다면 제거
            while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.substring(0, remain);
    }
}

//    public static String solution(String number, int k) {
//        int len = number.length()-k; // 구해야할 값의 길이
//        int[] temp = new int[len];
//        int idx = 0, cnt = 0;
//
//        while(cnt<len){
//            int max= 0;
//            int maxIdx = -1;
//            for (int i =idx; i <= k+cnt;i++){
//                int a = (int)number.charAt(i)-'0';
//                if( a > max){ max = a; maxIdx = i;}
//            }
//            temp[cnt] = max; cnt++;
//            idx = maxIdx+1;
//        }
//
//        // to String
//        String ans ="";
//        for( int i : temp){
//            ans += String.valueOf(i);
//        }
//        return ans;
//    }
//}
//
//    0     ~ length - (len-1) 중에 최대값 ==> len(구해야할 길이) = length - k /// length - (len - i) = k+i;
// 고른 인덱스 ~ length - (len-2)
// 고른 인덱스 ~ length - (len-3)
// ...
// 고른 인덱스 ~ length - (len-len) 중 최대값
//

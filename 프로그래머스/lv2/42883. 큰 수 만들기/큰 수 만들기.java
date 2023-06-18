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
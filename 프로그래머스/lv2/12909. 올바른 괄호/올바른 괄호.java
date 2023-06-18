import java.util.*;
class Solution {
    boolean solution(String s) {
    Stack<Character> stack = new Stack<>();
    boolean ans = true;
    char[] arr = s.toCharArray();
    stack.push(arr[0]);
    for (int i =1; i < arr.length;i++){
        if(arr[i] == '('){
            stack.push(arr[i]);
        }
        else if(stack.size()!=0&&stack.pop()!='('){ans = false;}
        }
        return ans&&stack.size()==0;
    }
}
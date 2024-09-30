import java.util.*;
class Solution {
    public int solution(String s) {
        String[] split = s.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < split.length; i++){
            if(split[i].equals("Z")){
                stack.pop();
                continue;
            }
            stack.push(Integer.parseInt(split[i]));
        }
        int answer = 0;
        while(true){
            if(!stack.isEmpty()){
                answer += stack.pop();
            } else {
                break;
            }
        }
        return answer;
    }
}
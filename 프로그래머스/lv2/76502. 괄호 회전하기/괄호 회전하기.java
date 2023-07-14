import java.util.*;
class Solution {
    public int solution(String s) {
    Queue<Character> brk = new LinkedList<>(); // Queue로 전환
    for(char ch: s.toCharArray()){brk.add(ch);}

    Queue<Character> temp = new LinkedList<>(brk); // 되돌아왔는지 비교를 위한 큐 생성
    int ans =0; // 올바른 괄호문자열 여부 체크

    do{
        if(pairBrk(brk)){ans++;} // 올바른 괄호문자열이면 +1
        brk.add(brk.poll()); // 괄호 회전
    }while(!brk.equals(temp)); // 처음으로 되돌아올때까지 반복

    return ans;
}
    public static boolean pairBrk(Queue<Character> bracket){
        Queue<Character> clone = new LinkedList<>(bracket); // 괄호쌍 체크를 위해 큐 복사
        Stack<Character> tmp = new Stack<>(); 
        while(!clone.isEmpty()){
            char ch = clone.poll();
            switch(ch){
                case '(': case '{': case '[': tmp.push(ch); break;

                case ')': if(tmp.isEmpty()||tmp.peek()!='('){return false;}
                else {tmp.pop(); break;}
                case ']': if(tmp.isEmpty()||tmp.peek()!='['){return false;}
                else {tmp.pop(); break;}
                case '}': if(tmp.isEmpty()||tmp.peek()!='{'){return false;}
                else {tmp.pop(); break;}
            }
        }
        return tmp.isEmpty()? true:false;
    }
}
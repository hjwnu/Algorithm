import java.util.*;
class Solution {
    public int solution(String s) {
        Queue<Character> brk = new LinkedList<>();
    for(char ch: s.toCharArray()){
        brk.add(ch);
    }

    Queue<Character> temp = new LinkedList<>(brk);
    int ans =0;

    do{
        if(pairBrk(brk)){ans++;}
        brk.add(brk.poll());
    }while(!brk.equals(temp));

    return ans;
}
    public static boolean pairBrk(Queue<Character> bracket){
        Queue<Character> clone = new LinkedList<>(bracket);
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
import java.util.*;
class Solution{
    public int solution(String s){
        int answer = 0;
        Stack<Character> str = new Stack<>();
        for(int i =0 ; i < s.length();i++){
            if(str.size()==0){str.push(s.charAt(i));}
            else if(str.peek()==s.charAt(i)){str.pop();}
            else{ str.push(s.charAt(i));}
        }
        return str.size()==0? 1:0;
    }
}
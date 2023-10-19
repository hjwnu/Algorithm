
import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            Stack<Character> stack = new Stack<>();
            String sentence = br.readLine();
            String answer = "yes";
            if(sentence.equals(".")){break;}
            loop1:
            for(int i =0; i < sentence.length();i++){
                char ch = sentence.charAt(i);
                switch(ch){
                    case '(' : case '[' : stack.push(ch); break;
                    case ')' : if(!stack.isEmpty()&&stack.peek()=='('){
                        stack.pop(); break;
                    } else {
                        answer ="no"; break loop1;
                    }
                    case ']' : if(!stack.isEmpty()&&stack.peek()=='['){
                        stack.pop(); break;
                    } else {
                        answer = "no"; break loop1;
                    }
                }
            }
            if(stack.size()>0){answer ="no";}
            System.out.println(answer);
        }
    }
}
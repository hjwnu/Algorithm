import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfCase = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        while(count < numOfCase){
            String command = br.readLine();
            if(command.length()>5){
                command = command.substring(5);
                stack.push(Integer.parseInt(command));
            }
            else{
                switch(command){
                    case "pop": if(stack.size()==0){answer.add(-1);}
                    else{answer.add(stack.pop());}
                        break;
                    case "size":answer.add(stack.size()); break;
                    case "top":if(stack.size()==0){answer.add(-1);}
                    else{answer.add(stack.peek());} break;
                    case "empty": if(stack.size()==0){answer.add(1);}
                    else{answer.add(0);} break;
                }
            }
            count++;
        }
        for(int i : answer){
            System.out.println(i);
        }
    }
}
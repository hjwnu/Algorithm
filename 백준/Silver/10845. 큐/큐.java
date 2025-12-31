import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfCase = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        while(count < numOfCase){
            String command = br.readLine();
            if(command.length()>5){
                command = command.substring(5);
                q.offer(Integer.parseInt(command));
            }
            else{
                switch(command){
                    case "pop": if(q.size()==0) answer.add(-1);
                                else answer.add(q.poll());
                                break;
                    case "size": answer.add(q.size()); break;
                    case "front": if(q.size()==0) answer.add(-1);
                                  else answer.add(q.peek()); 
                                  break;
                    case "back": if(q.size()==0) answer.add(-1);
                                 else answer.add(q.peekLast()); 
                                 break;
                    case "empty": if(q.size()==0) answer.add(1);
                                  else answer.add(0);
                                  break;
                }
            }
            count++;
        }
        for(int i : answer){
            System.out.println(i);
        }
    }
}
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            String command = br.readLine().replace("RR", "");
            int length = Integer.parseInt(br.readLine());
            StringBuilder tempArrString = new StringBuilder(br.readLine());
            tempArrString.setLength(tempArrString.length() - 1);
            tempArrString.deleteCharAt(0);
            String[] tempArr = tempArrString.toString().split(",");
            Deque<Integer> deq = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                deq.add(Integer.parseInt(tempArr[j]));
            }
            boolean error = false;
            boolean reverse = false;
            loop1:
            for (char ch : command.toCharArray()) {
                switch (ch) {
                    case 'R' : reverse = !reverse; break;
                    case 'D' : 
                        if(deq.isEmpty()){error = true; break loop1;}
                        else {
                            if(reverse){ deq.pollLast(); break;}
                            else{ deq.pollFirst(); break;}
                        }
                }
            }
            if(error){ System.out.println("error");}
            else{printAns(deq, reverse);}
        }
    }
    public static void printAns(Deque<Integer> deq, boolean reverse) {
            StringBuilder ans = new StringBuilder("[");
            if (deq.size() > 0) {
                if(reverse){
                    ans.append(deq.pollLast());
                    while (!deq.isEmpty()) {
                        ans.append(",").append(deq.pollLast());
                    }
                } else{
                    ans.append(deq.pollFirst());
                    while (!deq.isEmpty()) {
                        ans.append(",").append(deq.pollFirst());
                }
            }
        }
        ans.append("]");
        System.out.println(ans);
    }
}

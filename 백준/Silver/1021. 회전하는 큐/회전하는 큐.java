import java.util.*;
import java.io.*;
public class Main {
    static Deque<Integer> q = new LinkedList<>();
    static int move =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] total = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] targetArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i =1; i <= total[0];i++){ q.add(i); }
        for(int target : targetArr){
            int idx = findIndex(target);
            while(q.peek()!=target){
                if(idx <= q.size()-idx){ moveLeft(); }
                else{ moveRight(); }
            }
            q.poll();
        }

        System.out.println(move);
    }
    public static int findIndex(int target){
        int idx =0;
        for (int i : q) {
                if(i==target){  break;}
                idx++;
        }
        return idx;
    }
    public static void moveLeft(){
        q.addLast(q.pollFirst()); move++;
    }
    public static void moveRight(){
        q.addFirst(q.pollLast()); move++;
    }
}
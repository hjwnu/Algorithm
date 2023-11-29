import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0; i < total;i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(maxHeap.isEmpty()){System.out.println(0);}
                else{System.out.println(maxHeap.poll());}
            } else{
                maxHeap.add(num);
            }
        }
    }
}
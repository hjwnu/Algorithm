import java.util.*;
import java.io.*;
 
public class Main {
    static int N,K;
    static int[][] arr;
    static int[] bag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        N = input[0]; K = input[1];
        arr = new int[N][2]; bag = new int[K];
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<N;i++)
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<K;i++) bag[i] = Integer.parseInt(br.readLine());
 
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
        Arrays.sort(bag);
 
        long sum=0;
        int index=0;
        for (int curBag : bag) {
 
            while (index < N && arr[index][0]<=curBag )
                q.add(arr[index++][1]);
 
            if(q.size()>0) sum+=q.poll();
        }
        System.out.println(sum);
 
    }
}
 
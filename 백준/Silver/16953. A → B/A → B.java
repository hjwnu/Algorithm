import java.io.*;
import java.util.*;

class Main {
    static long end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        bfs(start);
    }

    public static void bfs(long start){
        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{start,1});

        while(!q.isEmpty()){
            long[] cur = q.poll();
            long n = cur[0];
            long count = cur[1];

            if(n == end){
                System.out.println(count);
                return;
            }

            if(n*2 <= end) q.add(new long[]{n*2, count+1});
            if(n*10+1 <= end) q.add(new long[]{n*10+1, count+1});
        }

        System.out.println(-1);
    }
}
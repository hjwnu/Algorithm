import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        dist[n] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == 1) {
                System.out.println(dist[x]);
                return;
            }

            // 1) /3
            if (x % 3 == 0) {
                int nx = x / 3;
                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    q.add(nx);
                }
            }

            // 2) /2
            if (x % 2 == 0) {
                int nx = x / 2;
                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    q.add(nx);
                }
            }

            // 3) -1
            if (x - 1 >= 1) {
                int nx = x - 1;
                if (dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    q.add(nx);
                }
            }
        }
    }
}

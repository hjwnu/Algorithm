import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] g;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        // A가 B를 신뢰 => B 해킹하면 A 해킹됨 => B -> A
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g[B].add(A);
        }

        int max = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int cnt = bfs(i);

            if (cnt > max) {
                max = cnt;
                ans.clear();
                ans.add(i);
            } else if (cnt == max) {
                ans.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append(' ');
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    static int bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        q.add(start);
        visited[start] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : g[cur]) {
                if (visited[next]) continue;
                visited[next] = true;
                q.add(next);
                cnt++;
            }
        }
        return cnt;
    }
}

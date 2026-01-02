import java.io.*;
import java.util.*;

class Main {
	static int[] dist;

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		if (start == end) {
			System.out.println(0);
			return;
		}

		int MAX = Math.max(start, end) * 2 + 2;
		dist = new int[MAX + 1];

		Arrays.fill(dist, - 1);
		bfs(start, end, MAX);

		System.out.println(dist[end]);
	}

	public static void bfs (int start, int end, int MAX) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);

		dist[start] = 0;
		while (! q.isEmpty()) {
			int cur = q.poll();
			int nextDist = dist[cur] + 1;

			for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
				if (next < 0 || next > MAX) continue;
				if (dist[next] != - 1) continue;

				dist[next] = nextDist;
				if ( next == end ) return;
				q.add(next);
			}
		}
	}
}
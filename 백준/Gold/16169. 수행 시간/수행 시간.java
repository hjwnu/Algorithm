import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] computer = new int[n + 1];
		int[] time = new int[n + 1];
		int maxRank = 0;

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			computer[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
			maxRank = Math.max(maxRank, computer[i]);
		}

		List<Integer>[] byRank = new ArrayList[maxRank + 1];
		for (int r = 1; r <= maxRank; r++) byRank[r] = new ArrayList<>();
		for (int i = 1; i <= n; i++) byRank[computer[i]].add(i);

		long[] finish = new long[n + 1];

		for (int idx : byRank[1]) finish[idx] = time[idx];

		for (int r = 2; r <= maxRank; r++) {
			for (int i : byRank[r]) {
				long start = 0;
				for (int j : byRank[r - 1]) {
					long dist = i - j;
					long trans = dist * dist;
					start = Math.max(start, finish[j] + trans);
				}
				finish[i] = start + time[i];
			}
		}

		long ans = 0;
		for (int i = 1; i <= n; i++) ans = Math.max(ans, finish[i]);
		System.out.println(ans);
	}
}

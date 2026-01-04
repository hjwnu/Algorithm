import java.io.*;
import java.util.*;

class Main {
	static int[][] matrix;
	static int n, ans = Integer.MAX_VALUE;
	static boolean[] visited;

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n];
		visited[0] = true;
		dfs(1, 1);
		System.out.println(ans);
	}

	static void dfs (int idx, int depth) {
		if (depth == n / 2) {
			int teamStart = 0;
			int teamLink = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i] && visited[j]) teamStart += matrix[i][j];
					else if (!visited[i] && !visited[j]) teamLink += matrix[i][j];
				}
			}

			ans = Math.min(ans, Math.abs(teamStart - teamLink));
			return;
		}

		for (int i = idx; i < n; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			dfs(i + 1, depth + 1);
			visited[i] = false;

		}
	}
}
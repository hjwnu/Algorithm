import java.io.*;
import java.util.*;

class Main {
	static int[][] matrix;
	static int n;
	static boolean[][] visited;
	static int[][] direction = {{- 1, 0}, {1, 0}, {0, 1}, {0, - 1}};
	static int maxSafe = 0;
	static int safe = 0;

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		matrix = new int[n][n];
		int maxHeight = - 1;
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int height = Integer.parseInt(temp[j]);
				matrix[i][j] = height;
				maxHeight = Math.max(height, maxHeight);
			}
		}

		for (int i = 0; i < maxHeight; i++) {
			safe =0;
			visited = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (! visited[j][k] && matrix[j][k] > i) {
						bfs(i,j,k);
						safe++;
					}
				}
			}
			maxSafe = Math.max(maxSafe, safe);
		}

		System.out.println(maxSafe);
	}

	static void bfs (int safeHeight, int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;

		while (! q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];


			for (int[] d : direction) {
				int moveX = curX + d[0];
				int moveY = curY + d[1];

				if (moveX < 0 || moveX >= n
						|| moveY < 0 || moveY >= n
						|| visited[moveX][moveY]
						|| matrix[moveX][moveY] <= safeHeight) continue;

				visited[moveX][moveY] = true;
				q.add(new int[]{moveX, moveY});
			}
		}
	}
}


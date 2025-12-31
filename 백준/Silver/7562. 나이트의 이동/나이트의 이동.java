import java.util.*;
import java.io.*;

class Main {
	static boolean[][] visited;
	static int[][] direction = {{-2,1}, {2,1}, {2,-1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}};
	static int n;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T ; i++){
			n = Integer.parseInt(br.readLine());
			visited = new boolean[n][n];
			dist = new int[n][n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int destX = Integer.parseInt(st.nextToken());
			int destY = Integer.parseInt(st.nextToken());
			sb.append(bfs(startX, startY, destX, destY)).append('\n');
		}

		System.out.println(sb);
	}

	public static int bfs(int startX, int startY, int destX, int destY){
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{startX,startY});
		visited[startX][startY] = true;
		dist[startX][startY] = 0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			for(int[] d : direction){
				int moveX = curX + d[0];
				int moveY = curY + d[1];

				if((moveX >= n || moveX < 0)
						|| (moveY >= n || moveY < 0)
						|| visited[moveX][moveY]) continue;

				visited[moveX][moveY] = true;
				dist[moveX][moveY] = dist[curX][curY] + 1;
				q.add(new int[]{moveX, moveY});
				if(moveX == destX && moveY == destY) {
					return dist[moveX][moveY];
				}
			}
		}
		return 0;
	}
}
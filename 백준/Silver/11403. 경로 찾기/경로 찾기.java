import java.io.*;
import java.util.*;

class Main {
	static boolean[][] graph;
	static boolean[][] reached;
	static int total;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(br.readLine());

		graph = new boolean[total][total];
		reached = new boolean[total][total];
		for(int i =0 ; i < total; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ;j <total; j++){
				graph[i][j] = st.nextToken().equals("1");
			}
		}
		for(int i = 0; i < total; i++) bfs(i);

		StringBuilder sb = new StringBuilder();
		for(boolean[] arr : reached){
			for(boolean b : arr){
				sb.append(b ? 1 : 0).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void bfs(int start){
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[total];;
		q.add(start);

		while(!q.isEmpty()){
			int cur = q.poll();

			for(int next = 0 ; next < total; next++){
				if(!graph[cur][next] || visited[next]) continue;
				q.add(next);
				visited[next] = true;
				reached[start][next] = true;
			}
		}
	}
}
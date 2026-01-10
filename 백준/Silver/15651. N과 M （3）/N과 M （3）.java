import java.io.*;
import java.util.*;

class Main {
	static int[] visited;
	static int n,m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new int[m];
		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int depth){
		if(depth == m){
			for(int i = 0; i < m; i++){
				sb.append(visited[i]);
				if ( i + 1 < m) sb.append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int i = 1; i <= n; i++){
			visited[depth] = i;
			dfs(depth +1);

		}
	}
}


import java.io.*;
import java.util.*;

class Main {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static int[] picked;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		picked = new int[m];
		dfs(0,1);
		System.out.println(sb);
	}

	static void dfs(int depth, int start){
		if(depth == m){
			for(int i = 0; i < m;i++){
				sb.append(picked[i]);
				if( i+1 < m) sb.append(' ');
			}
			sb.append('\n');
			return;
		}

		for(int i = start; i <= n; i++){
			picked[depth] = i;
			dfs(depth+1, i);
		}
	}

}
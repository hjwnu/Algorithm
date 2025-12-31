import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int total = Integer.parseInt(st.nextToken());
		int pair = Integer.parseInt(st.nextToken());

		List<Integer>[] graph = new ArrayList[total+1];
		for(int i = 1; i <=total;i++) graph[i] = new ArrayList<>();

		int[] indegree = new int[total+1];

		for(int i =0 ; i< pair;i++){
			StringTokenizer pairSt = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(pairSt.nextToken());
			int b = Integer.parseInt(pairSt.nextToken());
			graph[a].add(b);
			indegree[b]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 1; i <=total;i++){
			if(indegree[i] == 0 ) pq.add(i);
		}

		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()){
			int cur = pq.poll();
			sb.append(cur).append(' ');

			for(int next : graph[cur]){
				indegree[next]--;
				if (indegree[next] == 0) pq.add(next);
			}
		}

		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
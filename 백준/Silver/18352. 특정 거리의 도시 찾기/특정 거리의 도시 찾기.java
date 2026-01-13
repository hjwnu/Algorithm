import java.io.*;
import java.util.*;

class Main {
	static List<Integer>[] graph;
	static int distance, cities;
	static List<Integer> answer = new ArrayList<>();
	static boolean[] visited;

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		cities = Integer.parseInt(st.nextToken());
		int roads = Integer.parseInt(st.nextToken());
		distance = Integer.parseInt(st.nextToken());
		int startCity = Integer.parseInt(st.nextToken());

		visited = new boolean[cities+1];

		graph = new ArrayList[cities+1];
		for(int i = 0; i <= cities; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < roads; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			graph[n].add(m);
		}

		bfs(startCity, 0);

		if (answer.isEmpty()) {
			System.out.println(- 1);
			return;
		}
		Collections.sort(answer);
		for (int ans : answer) {
			System.out.println(ans);
		}
	}

	static void bfs (int start, int d) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int city = queue.poll();
				if (d == distance) {
					answer.add(city);
				} else {
					for (int nextCity : graph[city]) {
						if (!visited[nextCity]) {
							visited[nextCity] = true;
							queue.add(nextCity);
						}
					}
				}
			}
			d++;
			if (d > distance) break;
		}
	}
}
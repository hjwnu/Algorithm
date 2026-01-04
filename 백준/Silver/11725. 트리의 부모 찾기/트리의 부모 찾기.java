import java.io.*;
import java.util.*;

class Main {
	static class Node {
		int num;
		int parent;
		List<Integer> linkList;

		Node (int num, int link) {
			this.num = num;
			this.linkList = new ArrayList<>();
			this.linkList.add(link);
		}

		public void addLink (int link) {
			this.linkList.add(link);
		}

		public void changeParent (int parent) {
			this.parent = parent;
		}
	}

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Node> nodes = new HashMap<>();
		boolean[] visited;
		visited = new boolean[n + 1];
		for (int i = 0; i < n - 1; i++) {
			String[] temp = br.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			if (! nodes.containsKey(a)) nodes.put(a, new Node(a, b));
			else nodes.get(a).addLink(b);
			if (! nodes.containsKey(b)) nodes.put(b, new Node(b, a));
			else nodes.get(b).addLink(a);
		}
		nodes.get(1).changeParent(0);
		bfs(nodes, visited);
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(nodes.get(i).parent).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs (Map<Integer, Node> nodes, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		while (! q.isEmpty()) {
			int cur = q.poll();
			for (int n : nodes.get(cur).linkList) {
				if (! visited[n]) {
					visited[n] = true;
					nodes.get(n).changeParent(cur);
					q.offer(n);
				}
			}
		}
	}
}
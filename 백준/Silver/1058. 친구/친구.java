import java.io.*;
import java.util.*;

class Main {
	static boolean[][] friends;
	static class Node {
		int v, d;
		Node(int v, int d){
			this.v = v;
			this.d =d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());

		friends = new boolean[total][total];
		for(int i = 0; i < total; i++){
			String friend = br.readLine();
			for(int j = 0; j < total; j++){
				friends[i][j] = friend.charAt(j) == 'Y';
			}
		}
		bfs(total);
	}

	public static void bfs(int total){
		int maxFriend = 0;

		for(int i = 0; i < total; i++){
			boolean[] visited =new boolean[total];
			Queue<Node> q = new ArrayDeque<>();

			visited[i] = true;
			q.add(new Node(i,0));

			while(!q.isEmpty()){
				Node cur = q.poll();

				if(cur.d == 2) continue;

				for(int next = 0; next < total; next++){
					if (!friends[cur.v][next] || visited[next]) continue;

					visited[next] = true;
					q.add(new Node(next, cur.d+1));
				}
			}

			int cnt = 0;
			for(int j = 0; j < total;j++){
				if(j != i && visited[j] ) cnt++;
			}
			maxFriend = Math.max(maxFriend,cnt);
		}

		System.out.println(maxFriend);
	}
}
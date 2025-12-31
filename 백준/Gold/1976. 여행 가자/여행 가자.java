import java.util.*;
import java.io.*;
class Main {
	static boolean[][] roads;
	static int[] plan;
	static boolean[] reachable;
	static int cities;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cities = Integer.parseInt(br.readLine());
		reachable = new boolean[cities];
		int tripCities = Integer.parseInt(br.readLine());
		roads = new boolean[cities][cities];
		for(int i = 0; i < cities; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <cities; j++){
				boolean isLinked = st.nextToken().equals("1");
				roads[i][j] = roads[j][i] = isLinked;
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		plan = new int[tripCities];
		for (int i = 0; i < tripCities; i++) plan[i] = Integer.parseInt(st.nextToken()) - 1;
		
		bfs();

	}
	public static void bfs (){
		Queue<Integer> q= new ArrayDeque<>();
		q.add(plan[0]);
		reachable[plan[0]] = true;

		while(!q.isEmpty()){
			int cur = q.poll();
			for(int next = 0; next < cities;next++){
				if(roads[cur][next] && !reachable[next]){
					reachable[next] = true;
					q.add(next);
				}
			}
		}

		for(int city : plan){
			if(!reachable[city]){
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}
}
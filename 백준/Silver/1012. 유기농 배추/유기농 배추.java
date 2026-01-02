import java.util.*;
import java.io.*;

class Main {
	static boolean[][] matrix;
	static boolean[][] visited;
	static int answer;
	static int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
	static int row, col;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < n; i++){
			String[] temp = br.readLine().split(" ");
			row = Integer.parseInt(temp[0]);
			col = Integer.parseInt(temp[1]);
			matrix = new boolean[col][row];
			visited = new boolean[col][row];
			for(int j = 0; j < Integer.parseInt(temp[2]);j++){
				String[] tmp = br.readLine().split(" ");
				matrix[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[0])] = true;
			}
			answer = 0;
			for(int j = 0 ; j < matrix.length;j++){
				for(int k = 0; k < matrix[j].length;k++){
					if(matrix[j][k] && !visited[j][k]) bfs(j,k);
				}
			}
			System.out.println(answer);

		}
	}

	public static void bfs(int x, int y){
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{x,y});
		visited[x][y] = true;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int curX = cur[0];
			int curY = cur[1];
			for(int[] d : direction){
				int moveX = curX + d[0];
				int moveY = curY + d[1];

				if((moveX < 0 || moveX >= col)
						|| (moveY < 0 || moveY >= row)
						|| !matrix[moveX][moveY]
						|| visited[moveX][moveY]) continue;

				q.add(new int[]{moveX, moveY});
				visited[moveX][moveY] = true;
			}
		}

		answer++;
	}
}
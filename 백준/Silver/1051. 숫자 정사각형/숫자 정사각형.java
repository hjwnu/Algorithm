// 같은 행에 동일한 숫자가 있는지 찾는다
// 있다면, 두 숫자 간의 최대 거리를 구한다
// 두 숫자를 기준으로 같은 거리의 열에 동일한 숫자가 있는지 찾는다 (거리가 최대 범위를 넘는지 확인한다)
// 2개 이상 있다면 각 거리를 모두 시도한다 
// 각 거리마다 같은 거리의 열에 동일한 숫자가 있는지 찾는다 (열 거리가 최대 범위를 넘는지 확인한다)
// 각 탐색마다 최대거리를 비교한다.
// 없다면, 다음 행으로 넘어가 2-6을 반복한다.

import java.io.*;
import java.util.*;

class Main {
	static int[][] matrix;
	static int row, col;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		matrix = new int[row][col];
		for(int i = 0; i < row; i++){
			String line = br.readLine();
			for(int j = 0; j < col; j++){
				matrix[i][j] = line.charAt(j)-'0';
			}
		}

		int answer = 1;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				int maxLen = Math.min(row-i, col-j);
				for(int k = 1; k < maxLen; k++){
					int v = matrix[i][j];
					if(i+k >= row || j+k >= col) break;
					if( v == matrix[i+k][j] &&
						v == matrix[i][j+k] &&
						v == matrix[i+k][j+k]){
						answer = Math.max(answer, k+1);
					}
				}
			}
		}
		System.out.println(answer*answer);
	}
}

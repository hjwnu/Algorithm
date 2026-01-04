import java.io.*;
import java.util.*;

class Main {
	static int[] opsArr;
	static int min,max;
	static int[] seq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		seq = new int[n];

		String[] temp = br.readLine().split(" ");
		for(int i = 0 ; i < n; i++) seq[i] = Integer.parseInt(temp[i]);
		StringTokenizer st = new StringTokenizer(br.readLine());

		opsArr = new int[4];
	for(int i = 0 ; i < 4; i++) {
		opsArr[i] = Integer.parseInt(st.nextToken());
	}

	min = Integer.MAX_VALUE;
	max = Integer.MIN_VALUE;
	dfs(0,seq[0]);

        System.out.println(max);
        System.out.println(min);

}

	static void dfs(int idx, int result) {
		if(idx == seq.length -1) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}

		for(int i = 0 ; i < 4; i++) {
			if(opsArr[i] > 0) {
				opsArr[i]--;
				if(i == 0) {
					dfs(idx+1, result + seq[idx+1]);
				}else if(i == 1) {
					dfs(idx+1, result - seq[idx+1]);
				}else if(i == 2) {
					dfs(idx+1, result * seq[idx+1]);
				}else {
					dfs(idx+1, result / seq[idx+1]);
				}
				opsArr[i]++;
			}
		}

	}


}
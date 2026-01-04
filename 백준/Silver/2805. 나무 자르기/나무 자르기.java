import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int treeNum = Integer.parseInt(temp[0]);
		int need = Integer.parseInt(temp[1]);

		int[] trees = new int[treeNum];
		StringTokenizer st = new StringTokenizer(br.readLine());

		long lo = 1;
		long hi = 0;
		for(int i =0 ; i < treeNum; i++) {
			int height = Integer.parseInt(st.nextToken());
			trees[i] = height;
			hi = Math.max(hi, height);
		}

		while(lo <= hi){
			long mid = (lo+hi)/ 2;
			long sum = 0;
			for(int i = 0; i < treeNum; i++) if(trees[i] > mid) sum += trees[i] - mid;

			if( sum >= need) {
				lo = mid +1;
			} else {
				hi = mid - 1;
			}
		}

		System.out.println(hi);
	}
}
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int[] reg = new int[n];
		for(int i = 0 ; i <n ; i++) {
			int r = Integer.parseInt(st.nextToken());
			sum += r;
			max = Math.max(r, max);
			min = Math.min(r, min);
			reg[i] = r;
		}

		long budget = Integer.parseInt(br.readLine());

		if( sum <= budget) {
			System.out.println(max);
			return;
		}

		long lo = 0;
		long hi = 1_000_000_000L;

		while( lo <= hi ){
			long mid = (lo+hi)/2;
			long temp = 0;
			for(int i = 0; i < n ; i++) {
				if( reg[i] > mid) {
					temp += mid;
				} else {
					temp += reg[i];
				}
			}
			if( temp > budget) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		System.out.println(hi);
	}
}
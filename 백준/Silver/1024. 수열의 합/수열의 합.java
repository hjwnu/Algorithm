import java.util.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		// x = 연속된 숫자의 갯수, N = 시작 숫자
		// sum = xN + x^2/2 - x/2;
		// N = (2sum/x - x + 1)/2;
		// xN = sum - (x^2 + x)/2;
		// N = (sum - (x-1)(x)/2) / x;

		for(int x = n; x <= 100; x++){
			long xN = sum - (long)(x-1)*(long)(x)/2;

			if(xN < 0) continue;
			if(xN % x != 0) continue;

			long N = xN / x;

			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < x; i++){
				sb.append(N + i).append(" ");
			}
			sb.setLength(sb.length()-1);
			System.out.println(sb); return;
		}

		System.out.println(-1);
	}
}
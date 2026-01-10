import java.io.*;
import java.util.*;

class Main {
	static boolean[] prime;

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;

		int[] nums = new int[n];
		for(int i = 0; i < n;i++){
			int a = Integer.parseInt(br.readLine());
			max = Math.max(max, a);
			nums[i] = a;
		}
		prime = new boolean[max + 1];

		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		prime[2] = true;

		for (int i = 2; i * i <= max; i++) {
			if (prime[i]) for (int j = i * i; j <= max; j += i) prime[j] = false;
		}

		List<Integer> primeList = new ArrayList<>();
		for (int i = 2; i <= max; i++) {
			if (prime[i]) primeList.add(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i : nums) {
			for (int p = i / 2; p >= 2; p--) {
				int q = i - p;
				if (prime[p] && prime[q]) {
					sb.append(p).append(" ").append(q).append('\n');
					break;
				}
			}
		}

		System.out.println(sb);
	}

}
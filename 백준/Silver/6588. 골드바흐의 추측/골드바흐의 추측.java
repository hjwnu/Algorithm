import java.io.*;
import java.util.*;

class Main {
	static boolean[] prime;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> nums = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		while(true){
			int n = Integer.parseInt(br.readLine());
			if( n == 0 ) break;
			max = Math.max(max, n);
			nums.add(n);
		}
		prime = new boolean[max+1];

		Arrays.fill(prime,true);
		prime[0] = prime[1] = false;
		prime[2] = true;

		for(int i = 2; i*i <= max;i++){
			if(prime[i]) for(int j = i*i; j <= max;j+=i) prime[j] = false;
		}

		int sum = 0;

		List<Integer> primeList = new ArrayList<>();
		for(int i = 2; i <= max; i++){
			if(prime[i]) primeList.add(i);
		}

		StringBuilder sb = new StringBuilder();
		for(int n: nums){
			int loIdx = 0;
			int size = sb.length();
			while(true){
				int lo = primeList.get(loIdx);
				boolean isPrime = prime[n - lo];
				if(isPrime){
					sb.append(n).append(' ')
							.append('=').append(' ')
							.append(lo).append(' ')
							.append('+').append(' ')
							.append(n-lo)
							.append('\n');
					break;
				}
				else {
					loIdx++;
					if(loIdx >= primeList.size() || primeList.get(loIdx) > n) break; 
				}
			}
			if(size == sb.length()) sb.append("Goldbach's conjecture is wrong").append('\n');
		}

		System.out.println(sb);
	}

}
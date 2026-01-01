import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		boolean[] prime = new boolean[end+1];
		Arrays.fill(prime,true);
		prime[0] = false; prime[1] = false;
		for(int i = 2; i <= Math.sqrt(end); i++){
			if(prime[i]){
				for(int j = i*i; j <= end; j+=i){
					prime[j] = false;
				}
			}
		}

		int cnt = 0;
		for(int i = start; i <= end; i++){
			int primeNum = 0;
			int num = i;
			for(int j = 2; j < prime.length;j++){
				if(prime[j] && num % j == 0){
					while(num % j == 0){
						primeNum ++;
						num /= j;
					}
					if (num == 1) break;
				}
			}
			if(prime[primeNum]) cnt++;
		}
		System.out.println(cnt);
	}
}
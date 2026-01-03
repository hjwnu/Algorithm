import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int target = Integer.parseInt(temp[1]);

		List<Integer> list = new ArrayList<>();
		long lo = 1;
		long hi = -1;
		for(int i = 0; i < n ; i++){
			int input = Integer.parseInt(br.readLine());
			list.add(input);
			hi = Math.max(hi, input);
		}

		long mid = 0;
		while(lo <= hi){
			mid = (lo + hi)/2;
			long sum = 0;
			for(int i = 0; i < n; i++) sum += list.get(i)/mid;

			if(sum < target){
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}

		System.out.println(hi);
	}
}

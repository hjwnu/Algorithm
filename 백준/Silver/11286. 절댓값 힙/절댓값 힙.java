import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
			int absA = Math.abs(a);
			int absB = Math.abs(b);
			if(absA == absB) return a - b;
			else return absA - absB;
		});
		for(int i = 0 ; i < n; i++){
			int num = Integer.parseInt(br.readLine());

			if(num != 0) pq.add(num);
			else {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
		}
	}
}
}
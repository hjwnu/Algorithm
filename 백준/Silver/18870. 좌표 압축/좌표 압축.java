import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] seq = new int[n];
		String[] temp = br.readLine().split(" ");
		for(int i = 0; i < n;i++){
			seq[i] = Integer.parseInt(temp[i]);
		}

		SortedSet<Integer> set = new TreeSet<>();

		for(int i : seq) set.add(i);

		Map<Integer,Integer> map = new HashMap<>();

		int idx = 0;
		for(int i : set){
			map.put(i, idx++);
		}

		StringBuilder sb = new StringBuilder();

		for(int i : seq){
			sb.append(map.get(i)).append(" ");
		}
		System.out.println(sb);

	}
}
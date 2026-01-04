import java.io.*;
import java.util.*;

class Main {
	static int total;
	static int target;
	static int[] seq;
	static List<String> list = new ArrayList<>();

	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		total = Integer.parseInt(input[0]);
		target = Integer.parseInt(input[1]);
		seq = new int[target+1];
		backTrack(0, 1);

		for (String sb : list) System.out.println(sb.trim());
	}

	static void backTrack (int depth, int start) {
		if (depth == target) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < target; i++) {
				sb.append(seq[i]).append(" ");
			}
			sb.append('\n');
			list.add(sb.toString());
			return;
		}
		for (int i = start; i <= total; i++) {
			seq[depth] = i;
			backTrack(depth + 1, i+1);
		}
	}
}
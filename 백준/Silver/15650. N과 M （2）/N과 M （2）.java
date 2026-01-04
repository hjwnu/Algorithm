import java.io.*;
import java.util.*;

class Main {
	static int total;
	static int target;
	static boolean[] used;
	static List<String> list = new ArrayList<>();
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		total = Integer.parseInt(input[0]);
		target = Integer.parseInt(input[1]);
		used = new boolean[total];
		backTrack(0);

		for(String sb : list) System.out.println(sb.trim());
	}

	static void backTrack(int depth){
		if(depth == target){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < total; i++){
				if(used[i]){
					sb.append(i + 1).append(" ");
				}
			}
			String s = sb.toString();
			if(!list.contains(s)) list.add(s);
			return;
		}
		for(int i = 0; i < total; i++){
			if(!used[i]){
				used[i] = true;
				backTrack(depth + 1);
				used[i] = false;
			}
		}
	}
}
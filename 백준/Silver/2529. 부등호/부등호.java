import java.io.*;
import java.util.*;

public class Main {

	static int total;
	static int[] numbers;
	static List<Character> inEqList = new ArrayList<>();
	static boolean[] visited = new boolean[10];
	static ArrayList<String> answer = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		total = Integer.parseInt(br.readLine()) + 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<total-1; i++) {
			inEqList.add(st.nextToken().charAt(0));
		}
		numbers = new int[10];
		for (int i = 0; i < 10; i++) {
			numbers[i] = i;
		}
		dfs(0,  "");
		System.out.println(answer.get(answer.size()-1));
		System.out.println(answer.get(0));
	}

	private static void dfs(int index, String num) {
		if (num.length() == total) {
			answer.add(num);
			return;
		}
		for (int i = 0; i < 10; i++) {
			if(visited[i]) continue;
			if(index == 0 || inEqCheck(inEqList.get(index-1),num.charAt(index-1), (char) (i+'0'))){
				visited[i] = true;
				dfs(index+1, num+i);
				visited[i] = false;
			}
		}
	}

	private static boolean inEqCheck (char inEq, int a, int b){
		if(inEq == '<' && a > b) return false;
		if(inEq == '>' && a < b) return false;
		return true;
	}
}
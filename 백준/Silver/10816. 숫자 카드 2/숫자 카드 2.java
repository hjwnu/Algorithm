import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalCard = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int[] card = new int[20000001];
		for(int i = 0 ; i < totalCard; i++){
			card[Integer.parseInt(st.nextToken())+10000000]++;
		}
		int targetNum = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < targetNum; i++){
			int target = Integer.parseInt(st.nextToken())+10000000;
			sb.append(card[target] + " ");
		}
        
        System.out.print(sb.toString());
	}
}
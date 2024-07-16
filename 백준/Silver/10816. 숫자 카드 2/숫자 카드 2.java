import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalCard = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> cardMap = new HashMap<>();
		for(int i = 0 ; i < totalCard; i++){
            int card = Integer.parseInt(st.nextToken());
			cardMap.put(card, cardMap.getOrDefault(card, 0)+1);
		}
		int targetNum = Integer.parseInt(br.readLine());
		int[] targetArr = new int[targetNum];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < targetNum; i++){
			int target = Integer.parseInt(st.nextToken());
			targetArr[i] = cardMap.getOrDefault(target, 0);
		}

		for(int target : targetArr){
			System.out.print(target + " ");
		}
	}

}
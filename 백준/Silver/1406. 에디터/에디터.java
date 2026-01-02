import java.io.*;
import java.util.*;


// abcd
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder text = new StringBuilder(br.readLine());
		int command = Integer.parseInt(br.readLine());
		int idx = text.length();
		for(int i = 0 ; i < command; i++){
			StringBuilder sb = new StringBuilder(br.readLine());
			switch(sb.charAt(0)){
				case 'L': {
					if(idx > 0) idx--;
					break;
				}
				case 'D': {
					if( idx < text.length()) idx++;
					break;
				}
				case 'B': {
					if(idx > 0) text.deleteCharAt(--idx);
					break;
				}
				case 'P': {
					text.insert(idx++, sb.charAt(2));
				}
			}
		}

		System.out.println(text);
	}
}

import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			String input = br.readLine();
			int cursor = 0;
			for (int j = 0; j < input.length(); j++) {
				char ch = input.charAt(j);
				if (Character.isLetterOrDigit(ch)) {
					sb.insert(cursor, ch);
					cursor++;
					continue;
				}
				switch (ch) {
					case '<':
						if (cursor > 0) cursor--;
						break;
					case '>':
						if (cursor < sb.length()) cursor++;
						break;
					case '-':
						if (cursor > 0) {
							sb.deleteCharAt(cursor - 1);
							cursor--;
						}
						break;
				}
			}
			System.out.println(sb);
		}
	}
}
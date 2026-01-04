import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		String[] minersParts = line.split("-");
		
		int result = sumPlus(minersParts[0]);
		for(int i = 1; i < minersParts.length; i++) {
			result -= sumPlus(minersParts[i]);
		}

		System.out.println(result);
	}

	public static int sumPlus(String str) {
		int sum = 0;
		for(String s : str.split("\\+")) sum += Integer.parseInt(s);
		return sum;
	}
}
import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");

		long total = Integer.parseInt(temp[0]);
		long win = Integer.parseInt(temp[1]);

		if(total ==0 ){
			System.out.println(0); return;
		}

		long z = win*100 / total;

		if( z >= 99){
			System.out.println(-1); return;
		}

		long numerator = (z+1) * total - 100*win;
		long denominator = 99 -z;

		long answer = (numerator + denominator-1) / denominator;
		System.out.println(answer);

	}
}
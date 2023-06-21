import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(in.readLine());
        int[] quest = new int[T];
        for(int i =0 ; i < T; i++){
            quest[i] = Integer.parseInt(in.readLine());
        }
        int[] zefi = new int[42]; zefi[0] = 1; zefi[1] = 0; // 0 출력 갯수는 맨앞에 1이 붙은 피보나치. 1,0,1,1,1,2,3,5,.
        for(int i =2; i < 42; i++){
            zefi[i] = zefi[i-1] + zefi[i-2];
        }
        for(int i =0; i < T; i++) {
            System.out.println(zefi[quest[i]] + " " + zefi[quest[i] + 1]);
        }
    }
}

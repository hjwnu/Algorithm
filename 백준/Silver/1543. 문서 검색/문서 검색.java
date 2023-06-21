import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String a = br.readLine();
            String c = br.readLine();
            String A = a;
        int lena, lenb; String b; int cnt=0;
        while(true){
            a = a.replaceFirst(c,"//");
            if(!A.equals(a)){cnt++;}
            else{break;}
            A=a;
        }
        System.out.println(cnt);
    }
}
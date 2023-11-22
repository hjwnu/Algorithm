import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input = br.readLine();
            if(input.equals("0")){break;}
            StringBuilder reverse = new StringBuilder(input);
            reverse.reverse();
            if(input.contentEquals(reverse)){System.out.println("yes");}
            else { System.out.println("no");}
        }
    }
}
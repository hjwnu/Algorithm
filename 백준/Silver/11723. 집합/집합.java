import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[21];
    static boolean[] temp = new boolean[21];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        Arrays.fill(temp,true);
        for(int i =0 ; i < total ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); int num =0;
            if(!command.equals("all")
               &&!command.equals("empty")){
                num = Integer.parseInt(st.nextToken());
            }
            
            switch(command){
                case "add" : check[num] = true; break;
                case "remove": check[num] = false; break;
                case "check": bw.write(check[num]?"1\n":"0\n"); break;
                case "toggle": check[num] = !check[num]; break;
                case "all" : check = temp.clone(); break;
                case "empty" : check = new boolean[21]; break;
            }
        }
        bw.close();
    }
}
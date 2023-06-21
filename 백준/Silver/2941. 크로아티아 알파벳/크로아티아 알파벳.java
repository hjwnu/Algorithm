import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        String[] cro = {"c=", "c-", "dz=", "d-","lj", "nj","s=","z="};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        for(int i =0 ; i < cro.length;i++){
            a = a.replace(cro[i],"0");
        }
        System.out.println(a.length());
    }
}
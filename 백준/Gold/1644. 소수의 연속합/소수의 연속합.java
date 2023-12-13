import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        List<Integer> prime = getPrimeList();
        int ans =0;
        for(int i = 0; i< prime.size();i++){
            int sum = prime.get(i);
            for(int j = i+1; j < prime.size();j++){
                if(sum >= n){ break;}
                sum += prime.get(j);
            }
            if(sum==n){ans++;}
        }
        System.out.println(ans);
    }
    public static List<Integer> getPrimeList(){
        boolean[] isPrime = new boolean[n+1];
        isPrime[0] = true; isPrime[1] = true;  // false면 소수

        for(int i=2; i*i<=n; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<=n; j+=i){ isPrime[j]=true; }
            }
        }
        List<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < n+1;i++){
            if(!isPrime[i]){
                temp.add(i);
            }
        }
        return temp;
    }
}

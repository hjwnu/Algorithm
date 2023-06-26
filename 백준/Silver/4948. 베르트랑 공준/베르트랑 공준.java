import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean[] prime = new boolean[246913];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        getPrime();
        List<Integer> getCnt = new ArrayList<>();
        while(true){
            int min = sc.nextInt(); if(min==0){break;}
            int cnt=0;
            for (int i = min+1; i <= min*2; i++) {
                if (!prime[i]) {
                    cnt++;
                }
            } 
            System.out.println(cnt);
        }
        //getCnt = getCnt.subList(0,getCnt.size()-1); 
    }

    public static void getPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <=Math.sqrt(prime.length);i++){
            if(prime[i]) {continue;}
            for(int j =i*i; j <prime.length; j+=i){
                prime[j]=true;
            }
        }
    }
}
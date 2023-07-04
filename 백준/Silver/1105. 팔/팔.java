import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int begin = sc.nextInt(); int end = sc.nextInt();
        int num = 11;  //  L<=R<= 2,000,000,000
        int min = 11;
        for(int i = begin; i <= end; i++){
            if(min==0){break;}
            num = eight(i);
            if(num < min){ min= num;}
        }
        System.out.println(min);
    }
    public static int eight(int n){
        String a = String.valueOf(n);
        int cnt =0;
        for (char ch : a.toCharArray()){
            if(ch=='8') {cnt++;}
        }
        return cnt;
    }
}
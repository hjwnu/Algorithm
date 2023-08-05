import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int devilsNum = 666;
        int cnt =1;
        while( cnt<a){
            devilsNum ++;
            if(String.valueOf(devilsNum).contains("666")){
                cnt++;
            }
        }
        System.out.println(devilsNum);
    }
}
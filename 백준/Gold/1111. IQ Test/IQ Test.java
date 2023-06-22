import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(in.readLine());
        int[] arr = new int[len];
        String[] num = in.readLine().split(" ");
        for(int i =0 ; i < arr.length;i++){
            arr[i] = Integer.parseInt(num[i]);
        }
        // 기본 case
        int a,b,p=0,q=0;
        if(len>2){
            a=arr[2]-arr[1];
            b=arr[1]-arr[0];
            if(b==0) {
                for (int i = 2; i < arr.length; i++) {
                    if (arr[i] != arr[i - 1]) {
                        len = -1;
                        break;
                    }
                else len = 2;
                }
            }
            else{
                p = a/b;
                q = arr[1]-p*arr[0];
                for(int i =1 ; i < len; i++){
                    if(arr[i]!=arr[i-1]*p+q) len = -1;
                }
            }
        }
        // 절댓값이 점점 감소하는 케이스
        for(int i=1; i< len;i++){
            len = Math.abs(i-1) >  Math.abs(i)? -1:len;
        }
        switch(len){
            case 1 : System.out.println("A"); break;
            case 2 : if(arr[0]==arr[1]){System.out.println(arr[0]); break;} // [57, 57]
                System.out.println("A"); break;
            case -1 : System.out.println("B"); break;
            default : System.out.println(arr[len-1]*p+q); break;
        }
    }
}

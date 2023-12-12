import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int brokenNum = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if(brokenNum>0){
            String[] temp = br.readLine().split(" ");
            for(int i =0; i < temp.length;i++){
                int n = Integer.parseInt(temp[i]);
                broken[n] = true;
            }
        }
        int click = Math.abs(target-100); 
        for(int i = 0 ; i <= 999999 ; i ++){
            String str = String.valueOf(i); int len = str.length();
            boolean isBroken = false;
            for(int j = 0; j < len; j++){
                if(broken[str.charAt(j)-'0']){  
                    isBroken = true;  break;
                }
            }
            if(!isBroken) {
                int min = len + Math.abs(target - i);
                click = Math.min(min, click);
            }
        }
        System.out.println(click);
        }
    }
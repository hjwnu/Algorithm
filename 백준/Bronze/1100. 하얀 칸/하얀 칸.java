import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isEven = true;
        int checkPieces = 0;
        int lines = 0;
        while(lines<8){
            checkPieces += checkPieceOnLine(br.readLine(),isEven);
            isEven = !isEven; 
            lines++;
        }
        System.out.println(checkPieces);
    }
    
    public static int checkPieceOnLine(String line, boolean isEven){
        int piece = 0;
        int start = isEven? 0:1;
        for(int i =start ; i < 8;i+=2){
                if(line.charAt(i)=='F'){piece++;}
            }
        return piece;
    }
}

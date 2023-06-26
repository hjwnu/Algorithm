import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        
        int cross = 1, prevsum = 0;
        
        while(true){
            
            if(X<=prevsum + cross){
                if(cross%2 ==1){
                    System.out.print((cross - (X-prevsum-1)) + "/" + (X-prevsum));
                    break;
                }
                else{
                    System.out.println((X-prevsum)+"/"+(cross-(X-prevsum-1)));
                    break;
                }
            } 
              else {
                  prevsum += cross; cross++;
              }
            }
        }
    }
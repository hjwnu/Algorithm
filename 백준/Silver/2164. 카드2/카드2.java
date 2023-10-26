import java.util.*;
import java.io.*;
public class Main {
    static Queue<Integer> deck = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int card = Integer.parseInt(br.readLine());
        for(int i=1; i <= card;i++){
            deck.add(i);
        }
        while(deck.size()!=1){
            discard(); 
            moveUnderBottom();
        }
        System.out.println(deck.poll());
    }
    public static void discard(){
        deck.poll();
    }
    public static void moveUnderBottom(){
        deck.add(deck.poll());
    }
}
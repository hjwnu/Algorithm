import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      
      int player = Integer.parseInt(in.readLine());
      int[] p = new int[player];
      int[] S = new int[player];
      int[] cards = new int[player];
      
      StringTokenizer st = new StringTokenizer(in.readLine());
      for(int i=0;i<player;i++) p[i] = Integer.parseInt(st.nextToken());
      
      st = new StringTokenizer(in.readLine());
      for(int i=0;i<player;i++) {
         S[Integer.parseInt(st.nextToken())] = i;
         cards[i] = i%3;
      }
 
      int[] compare = cards.clone();
      int[] next = new int[player];
 
      int result = 0;
      while(!Arrays.equals(cards,p) && !(result !=0 && Arrays.equals(cards, compare))) {
         for(int j=0;j<player;j++) {next[S[j]] = cards[j];}
         
         cards = next.clone();
         result++;
      }
   
      if(result !=0 && Arrays.equals(cards, compare)) System.out.println(-1);
      else System.out.println(result);
   }
}
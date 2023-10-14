import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] sequence = getInput();
        Stack<Integer> stack = new Stack<>();
        for(int i =0 ; i < sequence.length;i++){
            while(!stack.isEmpty() && sequence[stack.peek()] < sequence[i]){
                sequence[stack.pop()] = sequence[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            sequence[stack.pop()] = -1;
        }
        StringBuilder ans = new StringBuilder( );
        for(int i : sequence){
            ans.append(i).append(' ');
        }
        ans.setLength(ans.length()-1);
        System.out.print(ans);
    }
    
    public static int[] getInput() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] numArr = new int[total];
        for(int i =0; i < total;i++){
            numArr[i] = Integer.parseInt(temp[i]);
        }
        return numArr;
    }
}
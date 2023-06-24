import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
     Stack<Integer> bsk = new Stack<>(); int cnt =0;
      for (int i = 0 ; i < moves.length; i++){
          for(int j = 0 ; j < board.length;j++){
              int get = board[j][moves[i]-1];
              if(get!=0){ 
                  if(bsk.size()==0 || bsk.peek()!=get){
                      bsk.push(get); 
                      board[j][moves[i]-1] =0; break;
                  }
                  else if(bsk.peek()==get){
                      bsk.pop(); cnt+=2; 
                      board[j][moves[i]-1] =0; break;
                  }
              }
          }
      }
       return cnt; 
    }
}
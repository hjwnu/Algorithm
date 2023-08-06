import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] pow = new int[10];
        for(int i =0; i < 10;i++){
            pow[i] = (int)Math.pow(2,i+1);
            if(arr.length==pow[i]||arr.length==1){return arr;}
        }
        for(int i =0; i < 10;i++){
            if(arr.length<pow[i]){
                pow[i] = Math.abs(pow[i]-arr.length);
            }
            else{pow[i] = Integer.MAX_VALUE;}
        }
        int min = Integer.MAX_VALUE;
        for(int i : pow){
            min = Math.min(min, i);
        }
        int[] answer = new int[arr.length+min];
        for(int i=0;i <arr.length;i++){
            answer[i] = arr[i];            
        }
        return answer;
    }
}
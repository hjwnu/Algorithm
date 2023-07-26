class Solution {
    public int solution(int[][] dots) {
        int x=0,y=0;
        for(int i =0 ; i < 4;i++){
            for(int j =i+1; j < 4; j++){
                if(dots[i][0]==dots[j][0]){x=Math.abs(dots[i][1]-dots[j][1]);}
                if(dots[i][1]==dots[j][1]){y=Math.abs(dots[i][0]-dots[j][0]);}
            }
        }
        return x*y;
    }
}
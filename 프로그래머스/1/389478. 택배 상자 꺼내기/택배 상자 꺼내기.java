import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
         Map<Integer, Box> map = new HashMap<>();

            int totalRows = n%w==0 ? n/w : n/w+1;

            int floor = 1;
            int column = 1;
            for(int i  = 1; i <= n; i++){
                if(floor % 2 == 1){
                    map.put(i, new Box(i, floor, column++));
                } else {
                    map.put(i, new Box(i, floor, (w+1-column++)));
                }
                if(column == w+1){
                    floor++;
                    column = 1;
                }
            }
            Box target = map.get(num);
            int answer = floor - target.floor;

            for(Box b : map.values()){
                if(b.floor == floor){
                    if(b.column == target.column){
                        answer++; break;
                    }
                }
            }
            return answer;
    }
}

class Box {
    int number;
    int floor;
    int column;
    
    public Box(int number, int floor, int column){
        this.number = number;
        this.floor = floor;
        this.column = column;
    }
}
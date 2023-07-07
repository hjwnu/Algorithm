class Solution {
    public String solution(int[] food) {
        String answer = "0";
        for(int i =food.length-1 ; i >0;i--){
            String temp = String.valueOf(i).repeat(food[i]/2);
            if(food[i]>=2){
               answer = temp+ answer +temp;
            }
        }
        return answer;
    }
}
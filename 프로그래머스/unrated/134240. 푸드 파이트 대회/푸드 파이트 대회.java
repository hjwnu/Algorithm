class Solution {
    public String solution(int[] food) {
        String answer = "0";
        for(int i =food.length-1 ; i >0;i--){
            if(food[i]>=2){
               answer = String.valueOf(i).repeat(food[i]/2)+ answer +String.valueOf(i).repeat(food[i]/2);
            }
        }
        return answer;
    }
}
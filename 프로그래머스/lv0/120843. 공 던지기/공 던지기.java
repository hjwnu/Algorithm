class Solution {
    public int solution(int[] numbers, int k) {
        int begin = 0; k--;
        while(k>0){
            begin += 2; k--;
            if(begin > numbers.length-1){
                begin -= numbers.length;
            }
        }
        return numbers[begin];
    }
}
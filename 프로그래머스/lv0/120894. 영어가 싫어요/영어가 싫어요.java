class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] num = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine","zero"};
        String[] n = {"1","2","3","4","5","6","7","8","9","0"};
        for (int i =0 ; i < num.length;i++){
            if(numbers.contains(num[i])){ numbers = numbers.replaceAll(num[i],n[i]);}
        }
        return Long.parseLong(numbers);
    }
}
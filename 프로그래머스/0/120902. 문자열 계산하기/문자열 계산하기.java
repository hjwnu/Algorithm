class Solution {
    public int solution(String my_string) {
        int sum = 0;
        String numStr = "";
        boolean isPlus = true;
        for(int i = 0; i< my_string.length(); i++){
            char ch = my_string.charAt(i);
            if(ch == ' '){
                continue;
            }
            if(Character.isDigit(ch)){   
                numStr += ch;
                if(i != my_string.length()-1){
                    continue;
                }
            }
            int num = Integer.parseInt(numStr);
            numStr = "";
            sum = isPlus ? sum+num : sum-num;
            isPlus = ch == '+';
            
            System.out.println(numStr);
        }
        return sum;
    }
}
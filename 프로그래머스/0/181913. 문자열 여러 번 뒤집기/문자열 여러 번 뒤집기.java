class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer;
        
        for(int i = 0 ; i< queries.length;i++){
            int[] indexArr = queries[i];
            int start = indexArr[0];
            int end = indexArr[1];
            
            my_string = reverse(my_string, start, end);
        }
        return my_string;
    }
    
    public String reverse(String string, int start, int end){
        String newStr = string.substring(0, start);
        
        String reversed = new StringBuilder(string.substring(start,end+1)).reverse().toString();
        
        return newStr + reversed + string.substring(end+1, string.length());
    }
    
}
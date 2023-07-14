class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string.substring(s,e+1));
        sb.reverse().toString();
        my_string = my_string.substring(0,s) + sb + my_string.substring(e+1,my_string.length());
        
        return my_string;
    }
}
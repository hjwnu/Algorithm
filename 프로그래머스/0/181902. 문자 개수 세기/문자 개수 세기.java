class Solution {
    public int[] solution(String my_string) {
        int[] arr = new int[52];
        for(int i = 0; i < my_string.length(); i++){
            char ch = my_string.charAt(i);
            if( ch >= 'A' && ch <= 'Z'){
                arr[ch-'A']++;
            } else if ( ch >= 'a' && ch <= 'z'){
                arr[ch-'a'+26]++;
            }
        }
        return arr;
    }
}
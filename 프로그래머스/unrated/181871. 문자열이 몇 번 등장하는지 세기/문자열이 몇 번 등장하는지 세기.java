class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int len =myString.length()-pat.length();
        for(int i =0; i < len+1;i++){
            String temp = myString.substring(i, pat.length()+i);
            if(temp.equals(pat)){answer++;}
        }
        return answer;
    }
}
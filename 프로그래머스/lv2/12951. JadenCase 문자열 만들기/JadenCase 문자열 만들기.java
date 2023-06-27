class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] S = s.split(" ");
        for(int i =0; i<S.length;i++){
            if(!S[i].isEmpty()){
                S[i] = Character.toUpperCase(S[i].charAt(0)) + S[i].substring(1);
            }
        }
        String after = String.join(" ", S);
        if (after.length() == s.length()) return after;
        return after + " ".repeat(s.length()-after.length());
    }
}
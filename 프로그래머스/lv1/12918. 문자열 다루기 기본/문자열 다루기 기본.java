class Solution {
    public boolean solution(String s) {
    try{int a = Integer.parseInt(s); return s.length()==4||s.length()==6?true:false;}
    catch(NumberFormatException e){return false;}
    }
}
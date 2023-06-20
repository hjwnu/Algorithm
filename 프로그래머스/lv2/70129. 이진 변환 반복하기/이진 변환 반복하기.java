class Solution {
    public int[] solution(String s) {
        int cnt =0,len=0; String c;
        
        while(!s.equals("1")){
            c = s.replace("0","");
            len += s.length()-c.length();
            s= Integer.toBinaryString(c.length());
            cnt++;
        }
        return new int[]{cnt, len};
    }
}
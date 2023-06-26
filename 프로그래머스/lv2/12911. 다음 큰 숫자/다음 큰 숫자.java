class Solution {
     public static int solution(int n) {
    String nBinary = Integer.toBinaryString(n);
    while(true){
        n = n+1;
        String plusBinary = Integer.toBinaryString(n);
        if(oneNum(nBinary)==oneNum(plusBinary)){break;}
    }
    return n;
}
    public static int oneNum(String a){
        int cnt = 0;
        for(int i= 0; i <a.length();i++){
            if(a.charAt(i)=='1') { cnt++;}
        }
        return cnt;
    }
}
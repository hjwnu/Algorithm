class Solution {
    public long solution(long n) {        
        return n==(long)Math.sqrt(n)*(long)Math.sqrt(n) ? (long)Math.pow(Math.sqrt(n)+1,2):-1;
    }
}
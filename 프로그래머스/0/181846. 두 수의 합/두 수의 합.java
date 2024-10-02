class Solution {
    public String solution(String a, String b) {
        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);
        equalize(sbA,sbB);
        boolean plusOne = false;
        StringBuilder answer = new StringBuilder();
        for(int i = sbA.length()-1; i >= 0; i--){
            int sum = (int)(sbA.charAt(i)-'0')+(int)(sbB.charAt(i)-'0');
            sum = plusOne ? sum+1 : sum;
            if(sum >= 10){
                plusOne = true;
                sum -= 10;
            } else {
                plusOne = false;
            }
            answer.insert(0,sum);
        }
        if(plusOne){
            answer.insert(0,1);
        }
        
        return answer.toString();
    }
    
    public void equalize(StringBuilder a, StringBuilder b){
        while(a.length() > b.length()){
            b.insert(0, "0");
        }
        while(b.length() > a.length()){
            a.insert(0, "0");
        }
    }
}
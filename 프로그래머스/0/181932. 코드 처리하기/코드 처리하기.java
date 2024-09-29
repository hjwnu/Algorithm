class Solution {
    public String solution(String code) {
        boolean mode = true;
        String ret = "";
        for(int i = 0; i < code.length(); i++){
            char ch = code.charAt(i);
            if( ch == '1'){
                mode = !mode;
                continue;
            }
            if(mode){
                if( i%2 == 0 ){
                    ret += code.charAt(i);
                }
            } else {
                if ( i%2 != 0){
                    ret += code.charAt(i);
                }
            }
        }
        if( ret.length() == 0){
            ret = "EMPTY";
        }
        return ret;
    }
}
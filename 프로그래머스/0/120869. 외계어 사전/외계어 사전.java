class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean isAllContains = true;
        for(int i = 0 ; i < dic.length;i++){
            isAllContains = true;
            String target = dic[i];
            for(int j = 0; j < spell.length;j++) {
                if(!target.contains(spell[j])){
                    isAllContains = false;
                    break;
                }
                int len = target.length();
                target = target.replace(spell[j],"");
                System.out.println(target);
                if(len - target.length()  != 1 ){
                    isAllContains = false;
                    break;
                }
            }
            if(isAllContains) return 1;
        }
        return 2;
    }
}
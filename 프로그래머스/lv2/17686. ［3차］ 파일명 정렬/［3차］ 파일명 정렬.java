import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files,new Comparator<String> (){
           @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                //head가 같을경우 
                if(result == 0) {
                    result = number(o1, head1) - number(o2, head2);
                }
                return result;
            } 
        });
        
        return files;
    }
    public static int number(String o1, String head){
        StringBuilder num = new StringBuilder(o1.substring(head.length()));
        int tailIdx=-1;
        for(int i = 0; i < num.length(); i++) {
            if(i>4||!Character.isDigit(num.charAt(i))){tailIdx = i; break;}
        }
        //tail이 비어있다면 number 끝까지 그대로.
        if(tailIdx==-1){tailIdx=num.length();}
        return  Integer.parseInt(num.substring(0,tailIdx).toString());
    }
    /*
    head와 number 배열을 미리 잘라 구해놓고, 이를 바탕으로 sort의 메서드를 override 하려 했다.
    다만, 외부 배열의 인덱스에 따라 비교하는 식으로 메서드를 override하는 것에 실패했다.
    정렬 메서드 자체에서 구해 비교하는 것으로 수정했다.
    
    public static void split(String[] files){
        head = new String[files.length]; 
        numArr = new String[files.length]; 
        for(int i =0 ; i < files.length;i++){
            String file = files[i];
            int numIdx=101; int tailIdx = 101;
            for(int j =0 ; j < file.length();j++){
                if(Character.isDigit(file.charAt(j))){
                    numIdx = Math.min(numIdx,j);
                }
                if((!Character.isDigit(file.charAt(j))
                   && j > numIdx)||j-numIdx>4){
                    tailIdx = Math.min(tailIdx, j);
                }
            }
            head[i] = file.substring(0, numIdx).toLowerCase();
            numArr[i] = file.substring(numIdx,tailIdx);
        }
    }
    */
}
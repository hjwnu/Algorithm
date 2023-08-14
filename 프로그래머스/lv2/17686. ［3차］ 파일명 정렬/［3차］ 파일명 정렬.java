import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        
//         String[] head = new String[files.length]; 
//         String[] number = new String[files.length]; 

//         for(int i =0 ; i < files.length;i++){
//             String file = files[i];
//             int numIdx=101; int tailIdx = 101;
//             for(int j =0 ; j < file.length();j++){
//                 if(Character.isDigit(file.charAt(j))){
//                     numIdx = Math.min(numIdx,j);
//                 }
//                 if((!Character.isDigit(file.charAt(j))
//                    && j > numIdx)||j-numIdx>4){
//                     tailIdx = Math.min(tailIdx, j);
//                 }
//             }
//             head[i] = file.substring(0, numIdx).toLowerCase();
//             number[i] = file.substring(numIdx,tailIdx);
//         }
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
    int number(String o1, String head){
        StringBuilder num = new StringBuilder(o1.substring(head.length()));
        int tailIdx=-1;
        for(int i = 0; i < num.length(); i++) {
            if(i>4||!Character.isDigit(num.charAt(i))){tailIdx = i; break;}
        }
        //tail이 비어있다면 number 끝까지 그대로.
        if(tailIdx==-1){tailIdx=num.length();}
        return  Integer.parseInt(num.substring(0,tailIdx).toString());
    }
}
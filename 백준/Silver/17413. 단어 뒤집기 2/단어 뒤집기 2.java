import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder originalWord = new StringBuilder(br.readLine());
        StringBuilder reverseWord = new StringBuilder();
        for(int i=0; i < originalWord.length();i++){
            if (originalWord.charAt(i) == '<') {
                i = extractTag(i,originalWord, reverseWord);
            } else {
                i = reverseTargetWord(i, originalWord, reverseWord);
            }
        }
        System.out.println(reverseWord);
    }

    private static int reverseTargetWord(int start, StringBuilder originalWord, StringBuilder reverseWord) {
        int closeIdx =  originalWord.length()-1;
        boolean isLast = true;
        for (int i = start; i < originalWord.length(); i++) {
            if(originalWord.charAt(i)==' '||originalWord.charAt(i)=='<') closeIdx = i;
            if(closeIdx != originalWord.length()-1){
                isLast = false;  break;
            }
        }
        
        StringBuilder extractWord = new StringBuilder(originalWord.substring(start, closeIdx+1));
        boolean hasSpace = extractWord.toString().contains((" "));
        
        addReverseWord(reverseWord, extractWord, hasSpace, isLast);
        return hasSpace||isLast ?closeIdx:closeIdx-1;
    }

    private static void addReverseWord(StringBuilder reverseWord, StringBuilder tmp, boolean hasSpace, boolean isLast) {
        if(isLast){
            reverseWord.append(tmp.reverse());
        } else  {
            reverseWord.append(tmp.deleteCharAt(tmp.length() - 1).reverse());
        }
        if (hasSpace){
            reverseWord.append(" ");
        }
    }

    private static int extractTag(int start, StringBuilder originalWord, StringBuilder reverseWord) {
        int closeIdx = Integer.MIN_VALUE;
        for (int i = start; i < originalWord.length(); i++) {
            if(originalWord.charAt(i)=='>'){closeIdx = i;}
            if(closeIdx>0){break;}
        }
        reverseWord.append(originalWord.substring(start, closeIdx + 1));
        return closeIdx;
    }
}




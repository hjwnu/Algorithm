import java.util.*;
import java.io.*;

public class Main {

    static int white =0;
    static int blue = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[][] paper= setPaper(br, length);
        cutPaper(paper);

        System.out.println(white);
        System.out.println(blue);
    }

    private static String[][] setPaper(BufferedReader br, int length) throws IOException {
        String[][] paper = new String[length][length];
        for(int i =0 ; i < length;i++){
            String line = br.readLine();
            paper[i] = line.split(" ");
        }
        return paper;
    }

    private static void cutPaper(String[][] paper) {
        if(isSameColor(paper)){return;}

        int half = paper.length / 2 ;
        String[][] cutPaper = new String[half][half];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int x = 0; x < half; x++) {
                    for (int y = 0; y < half; y++) {
                        cutPaper[x][y] = paper[x + i * half][y + j * half];
                    }
                }
                cutPaper(cutPaper);
            }
        }

    }
    private static boolean isSameColor(String[][] cutPaper) {
        boolean isWhite = true;
        boolean isBlue = true;

        for (int i = 0; i < cutPaper.length; i++) {
            for (int j = 0; j < cutPaper[i].length; j++) {
                if (cutPaper[i][j].equals("1")) {
                    isWhite = false;
                } else {
                    isBlue = false;
                }
            }
        }

        if (isWhite) { white++; return true; } 
        else if (isBlue) { blue++; return true; } 
        else { return false; }
    }
}
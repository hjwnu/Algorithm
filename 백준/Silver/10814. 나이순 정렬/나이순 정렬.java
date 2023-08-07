import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] sorting = new String[N][2];

        for(int i = 0; i < N;i++){
            String input = br.readLine();
            String[] tmp =input.split(" ");
            sorting[i][0] = tmp[0];
            sorting[i][1] = tmp[1];
        }
        Arrays.sort(sorting, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0])-Integer.parseInt((o2[0]));
            }
        });

        for (String[] str : sorting) {
            System.out.println(str[0] + " "+ str[1]);
        }
    }
}
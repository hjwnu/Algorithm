import java.io.*;
import java.util.*;

public class Main {
    static boolean[] know;
    static boolean[][] link;
    static boolean[] visited;
    static int people;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        people = Integer.parseInt(st.nextToken());
        know = visited = new boolean[people + 1];
        link = new boolean[people + 1][people + 1];
        int partyNum = Integer.parseInt(st.nextToken());
        firstGetKnows(br);

        int[][] party = getLink(br, partyNum);
        for(int i = 1; i <= people;i++) {
            if(know[i]) {
                visited[i] = true;
                getKnows(i);
            }
        }
        printCountLieParty(partyNum, party);
    }

    
    private static void firstGetKnows(BufferedReader br) throws IOException {
        StringTokenizer st;
        st  = new StringTokenizer(br.readLine());
        int knowNum = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < knowNum;i++){
            know[Integer.parseInt(st.nextToken())]  = true;
        }
    }
    private static int[][] getLink(BufferedReader br, int partyNum) throws IOException {
        StringTokenizer st;
        int[][] party = new int[partyNum][];
        for(int i = 0; i < partyNum; i++){
            st  = new StringTokenizer(br.readLine());
            int[] temp = new int[Integer.parseInt(st.nextToken())];
            for(int j = 0 ; j < temp.length; j++){
                int person = Integer.parseInt(st.nextToken());
                temp[j] = person;
            }
            for(int j = 0; j <temp.length; j ++){
                for(int k = j+1 ; k < temp.length; k++){
                    link[temp[j]][temp[k]] = link[temp[k]][temp[j]] = true;
                }
            }
            party[i]= temp;
        }
        return party;
    }

        private static void getKnows(int start){
        for (int i = 1; i < link.length; i++) {
            if (link[start][i] &&!visited[i]) {
                know[i]=visited[i] = true;
                getKnows(i);
            }
        }
    }

    private static void printCountLieParty(int num, int[][] party) {
        for(int i = 0; i < party.length; i ++){
            for(int j = 0; j < party[i].length; j++){
                if(know[party[i][j]]){
                    num--;  break;}
            }
        }
        System.out.println(num);
    }

}

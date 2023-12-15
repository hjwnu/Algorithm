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
        firstCheckKnows(br);

        int[][] party = checkLink(br, partyNum);
        for(int i = 1; i <= people;i++) {
            if(know[i]) {
                visited[i] = true;
                checkKnows(i);
            }
        }
        boolean[] canLie = getCanLieParty(partyNum, party);

        printAns(canLie);
    }
    private static void checkKnows(int start){
        for (int i = 1; i < link.length; i++) {
            if (link[start][i] &&!visited[i]) {
                know[i]=visited[i] = true;
                checkKnows(i);
            }
        }
    }
    private static int[][] checkLink(BufferedReader br, int partyNum) throws IOException {
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

    private static void firstCheckKnows(BufferedReader br) throws IOException {
        StringTokenizer st;
        st  = new StringTokenizer(br.readLine());
        int knowNum = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < knowNum;i++){
            know[Integer.parseInt(st.nextToken())]  = true;
        }
    }

    private static void printAns(boolean[] canLie) {
        int ans = 0;
        for(boolean b : canLie) if(b) ans++;

        System.out.println(ans);
    }

    private static boolean[] getCanLieParty(int num, int[][] party) {
        boolean[] canLie = new boolean[num];
        for(int i = 0; i < party.length; i ++){
            canLie[i] = true;
            for(int j = 0; j < party[i].length; j++){
                if(know[party[i][j]]){
                    canLie[i] = false;  break;}
            }
        }
        return canLie;
    }

    public static void check(int[] party){
        for (int i = 0; i < party.length; i++) {
            if(know[party[i]]){
                for(int j = 0 ; j < party.length;j++){
                    know[party[j]] = true;
                }
                break;
            }
        }
    }

}
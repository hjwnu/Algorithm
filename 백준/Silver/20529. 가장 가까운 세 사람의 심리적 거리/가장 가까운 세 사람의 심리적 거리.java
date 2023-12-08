import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static String[] students;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for(int i =0 ; i < total ; i++){
            int people = Integer.parseInt(br.readLine());
            visited = new boolean[people];
            students = br.readLine().split(" ");
            if(people > 32){System.out.println(0);}
            else{
                 min = Integer.MAX_VALUE;
                findMinDistance(0,3);
                System.out.println(min);
            }
        }
    }

    static public void findMinDistance(int start, int selected){
        if(min==0){return;}
        if(selected==0){
            List<String> select = new ArrayList<>();
            for(int i =0;  i < students.length;i++){
                if(visited[i]){ select.add(students[i]); }
                if(select.size()==3)break;
            }
           min = Math.min(getDistance(select),min);
            return;
        }
        for(int i =start; i < students.length;i++){
            if(min==0){return;}
            visited[i] = true;
            findMinDistance(i+1,selected-1);
            visited[i] = false;
        }
    }

    static public int getDistance(List<String> select){
        int cnt =0;
        String A = select.get(0);
        String B = select.get(1);
        String C = select.get(2);
        if(A.equals(B)&&B.equals(C)&&C.equals(A)){return 0;}
        for(int i =0 ; i < 4 ; i++){
            if(A.charAt(i)!=B.charAt(i)){cnt++;}
            if(B.charAt(i)!=C.charAt(i)){cnt++;}
            if(C.charAt(i)!=A.charAt(i)){cnt++;}
        }
        return cnt;
    }
}
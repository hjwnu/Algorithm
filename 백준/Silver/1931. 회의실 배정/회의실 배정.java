import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int use =0;
        List<int[]> meetingTime = new ArrayList<>();
        for(int i =0 ; i < total;i++){
            meetingTime.add(inputToIntArr(br.readLine()));
        }
        meetingTime.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        int endTime = 0;
        for (int i = 0; i < total; i++) {
            if (endTime <= meetingTime.get(i)[0]) {
                endTime= meetingTime.get(i)[1];
                use++;
            }
        }
        System.out.println(use);
    }
    public static int[] inputToIntArr(String input){
        String[] temp = input.split(" ");
        int[] arr = new int[temp.length];
        for(int i =0; i < temp.length;i++){
            arr[i] = Integer.parseInt(temp[i]);
        }

        return arr;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] total = inputToIntArr(br.readLine());
        int deud = total[0]; int bo = total[1];
        Map<String, Integer> deudbos = new HashMap<>();
        int cnt =0;
        for(int i =0 ; i < deud+bo; i++){
            String input = br.readLine();
            if(deudbos.containsKey(input)){
                cnt++;
                deudbos.put(input, deudbos.get(input)+1);
            } else {
            deudbos.put(input, 1);
            }
        }
        System.out.println(cnt);
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : deudbos.entrySet()){
            if(entry.getValue()==2){
                ans.add(entry.getKey());
            }
        }
        ans.sort(null);
        for(String name : ans){
            System.out.println(name);
        }
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
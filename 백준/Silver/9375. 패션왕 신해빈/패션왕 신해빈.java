import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for(int i = 1; i <= total;i++){
            int totalItem = Integer.parseInt(br.readLine());
            Map<String, Integer> itemCategory = new HashMap<>();
            for(int j = 1; j <= totalItem;j++){
                String[] item = br.readLine().split(" ");
                itemCategory.put(item[1], itemCategory.getOrDefault(item[1],0)+1);
            }
            
            int answer = 1;
            for(String category : itemCategory.keySet()){
                answer *= itemCategory.get(category)+1;
            }
            System.out.println(answer-1);
        }
    }
}

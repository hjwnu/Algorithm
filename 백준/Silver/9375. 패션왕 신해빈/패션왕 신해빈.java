import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for(int i = 1; i <= total;i++){
            int totalItem = Integer.parseInt(br.readLine());
            Map<String, Integer> itemCategory = new HashMap<>();
            String tempCategory = "";
            for(int j = 1; j <= totalItem;j++){
                String[] item = br.readLine().split(" ");
                tempCategory = item[1];
                itemCategory.put(tempCategory, itemCategory.getOrDefault(tempCategory,0)+1);
            }
            
            if(itemCategory.size()==1){
                System.out.println(itemCategory.get(tempCategory));
            } else {
                int answer = 1;
                for(String category : itemCategory.keySet()){
                    answer *= itemCategory.get(category)+1;
                }
                System.out.println(answer-1);
            }
        }
    }
}
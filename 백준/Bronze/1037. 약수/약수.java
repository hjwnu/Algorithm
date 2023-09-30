import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        if(total==1){
            int n = sc.nextInt();
            System.out.println(n*n);
        } else if(total==2){
            System.out.println(sc.nextInt()*sc.nextInt());
        } else{
        List<Integer> numbers = new ArrayList<>();
        while(sc.hasNext()){
            numbers.add(sc.nextInt());
        }
        Collections.sort(numbers);
        int min = numbers.get(0);
        int max = numbers.get(numbers.size()-1);
        System.out.println(min*max);
        }
    }
}
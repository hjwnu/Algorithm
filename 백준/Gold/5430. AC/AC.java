import java.util.Scanner;
import java.util.LinkedList;
import java.util.Deque;
public class Main{
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int cnt =1;
        while(cnt <=T){

            String a = sc.next();
            int len = sc.nextInt();
            String b = sc.next();
            a = a.replace("RR","");
            b = b.substring(1, b.length() - 1);
            String[] tmp = b.split(",");
            Deque<Integer> q = new LinkedList<>();
            for(int i =0 ; i < len;i++){
                q.add(Integer.parseInt(tmp[i]));
            }
            int error =0;
            boolean reverse =false;
            for(char ch : a.toCharArray()){
                if(ch=='R'){reverse = !reverse;}
                else{
                    if(!reverse) {
                        if (!q.isEmpty()) {q.pollFirst();}
                        else {error = -1; break;}
                    }
                    else{
                        if (!q.isEmpty()) {q.pollLast();}
                        else {error = -1; break;}
                    }
                }
            }

            if (error == -1) {System.out.println("error");}
            else {
                    printAns(q,reverse);
                    System.out.println(sb);}
            cnt++;
            }
        }
    
    public static void printAns(Deque<Integer> q, boolean reverse) {
		sb = new StringBuilder();
		sb.append('[');
		
		if(q.size() > 0) {
			
			if(!reverse) {
				
				sb.append(q.pollFirst());
				while(!q.isEmpty()) {
					sb.append(',').append(q.pollFirst());
				}
			}
			else {	
				sb.append(q.pollLast());	
				while(!q.isEmpty()) {
					sb.append(',').append(q.pollLast());
				}
			}
		}
		
		sb.append(']');	
	}
}
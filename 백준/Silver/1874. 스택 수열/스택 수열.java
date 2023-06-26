import java.util.*;

//1부터 스택에 집어 넣음.
//만약 지금 넣은게 타겟이라면 pop.
//아니라면 push.

public class Main{
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //입력받기. 큐에 만들 수열 저장. 리스트에 +,- 저장.
        int n = sc.nextInt();
        Queue<Integer> target_q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        List<String> ans = new ArrayList<>();

        for(int i=0; i < n; i++){
            target_q.add(sc.nextInt());
        }

        st.push(-1);
        // 1부터 스택에 집어넣음.
        // 만들 수열 순서대로 맨앞에서부터 peek.
        // 하나씩 집어넣다가, 집어넣은 수가 target과 같다면, pop 후 스택 내 추가로 만들 숫자가 없을때까지 반복
        // 마지막 숫자 집어넣고, target 확인 후 반복문 종료.
        for(int i =1; i <= n; i++){
            int target = target_q.peek();
            st.push(i); ans.add("+");
            while(st.peek()==target){
                st.pop(); target_q.poll(); ans.add("-");
                if(!target_q.isEmpty()){target = target_q.peek();} else{break;}
            }
        }

        // 타겟큐가 모두 소진됐다면 수열이 만들어졌음. 아직 남아있다면 못만들고 끝났음.
        if(target_q.size()==0){
            for(int i =0; i < ans.size();i++){
                System.out.println(ans.get(i));
            }
        }
        else{ System.out.println("NO");}
    }
}
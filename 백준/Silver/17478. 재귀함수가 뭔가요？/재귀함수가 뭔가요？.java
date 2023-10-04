import java.util.*;

public class Main{
    static List<String> sentences = new ArrayList<>();
    static List<String> endingSentences = new ArrayList<>();
    static String endSentence = "라고 답변하였지.";
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int recurNum = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        fillArr();
        fillEnd();
        recursive(0,recurNum, "");
    }

    public static void recursive(int count,int recurNum,String str){
        StringBuilder sb = new StringBuilder(str);
        if(count==recurNum){
            for(String sentence : endingSentences){
                sb.append(sentence);
                System.out.println(sb.toString());
                sb = new StringBuilder(str);
            }
            return;}

        for(String sentence : sentences){
            sb.append(sentence);
            System.out.println(sb.toString());
            sb = new StringBuilder(str);
        }
        recursive(count+1,recurNum, "____".repeat(count+1));
        sb = new StringBuilder(str);
        sb.append(endSentence);
        System.out.println(sb.toString());
    }

    public static void fillArr(){
        sentences.add("\"재귀함수가 뭔가요?\"");
        sentences.add("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        sentences.add("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        sentences.add("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
    }

    private static void fillEnd() {
        endingSentences.add("\"재귀함수가 뭔가요?\"");
        endingSentences.add("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        endingSentences.add("라고 답변하였지.");
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int targetPaper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numTC = Integer.parseInt(br.readLine());
        for(int TC =0 ; TC < numTC ; TC++){
            Queue<Integer> papers = makePapers(inputToIntArr(br.readLine()));
            if(papers.size()==1){
                br.readLine();
                System.out.println(1);
            }
            else {
                List<Integer> priors = setPrior(inputToIntArr(br.readLine()));
                int max = getMaxValue(priors);
                int order = 0;
                while (!papers.isEmpty()) {
                    if (max == priors.get(0)) {
                        int target = papers.poll();
                        priors.remove(0);
                        order++;
                        if (targetPaper == target) {
                            break;
                        }
                        max = getMaxValue(priors);
                    } else {
                        papers.add(papers.poll());
                        priors.add(priors.remove(0));
                    }

                }
                System.out.println(order);
            }
        }
    }

    public static int getMaxValue(List<Integer> priors) {
        int max = Integer.MIN_VALUE;
        for(int i : priors){
            max = Math.max(i,max);
        }
        return max;
    }

    public static List<Integer> setPrior( int[] prior) {
        List<Integer> priors = new ArrayList<>();
        for(int i = 0; i < prior.length; i++){
            priors.add(prior[i]);
        }
        return priors;
    }

    public static Queue<Integer> makePapers(int[] paper) {
        int totalPaper = paper[0];
        targetPaper = paper[1];
        Queue<Integer> papers = new LinkedList<>();
        for(int i = 0; i < totalPaper ; i++){
            papers.add(i);
        }
        return papers;
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
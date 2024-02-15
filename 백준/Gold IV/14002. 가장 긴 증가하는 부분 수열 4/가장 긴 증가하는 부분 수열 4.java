import java.util.*;
import java.io.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        if( total == 1 ) {
            int answer = Integer.parseInt(br.readLine());
            System.out.println(total);
            System.out.println(answer); return;
        }
        int[] arr = new int[total];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] maxLenArr = new int[total];
        maxLenArr[0] = 1;
        int count = 0;
        for (int i = 1; i < total; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && maxLenArr[j] >= max) max = maxLenArr[j];
            }
            maxLenArr[i] = max+1;
            count = Math.max(count, maxLenArr[i]);
        }

        int depth = count;
        Stack<Integer> reverseTrace = new Stack<>();
        for (int i = total - 1; i >= 0; i--) {
            if(depth == maxLenArr[i]) {
                reverseTrace.push(arr[i]);
                depth--;
            }
        }
        System.out.println(count);
        while (!reverseTrace.isEmpty()) System.out.print(reverseTrace.pop() + " ");
    }
}
import java.io.*;
import java.util.*;

class Main {
    static class Lecture {
        int start, end;
        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(s, t);
        }

        Arrays.sort(lectures, (a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            return a.end - b.end;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Lecture lec : lectures) {
            if (!pq.isEmpty() && pq.peek() <= lec.start) {
                pq.poll();
            }
            pq.add(lec.end);
        }

        System.out.println(pq.size());
    }
}

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] cnt = new int[257];
        int minH = 256, maxH = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                cnt[h]++;
                if (h < minH) minH = h;
                if (h > maxH) maxH = h;
            }
        }

        long bestTime = Long.MAX_VALUE;
        int bestHeight = -1;

        for (int target = 0; target <= 256; target++) {
            long remove = 0;
            long add = 0;

            for (int h = 0; h <= 256; h++) {
                int c = cnt[h];
                if (c == 0) continue;

                if (h > target) remove += (long)(h - target) * c;
                else if (h < target) add += (long)(target - h) * c;
            }

            if ((long)B + remove < add) continue;

            long time = 2L * remove + add;

            if (time < bestTime || (time == bestTime && target > bestHeight)) {
                bestTime = time;
                bestHeight = target;
            }
        }

        System.out.println(bestTime + " " + bestHeight);
    }
}

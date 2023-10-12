import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        int[] arr = new int[N]; //입력받을 자연수만큼의 배열 크기 생성
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr); // 이분 탐색을 위해서 배열을 정렬

        int M = in.nextInt();
        for(int i = 0; i < M; i++) {
            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0
            if(binarySearch(arr, in.nextInt()) >= 0) {
                sb.append(1 + "\n");
            }
            else {
                sb.append(0 + "\n");
            }
        }
       System.out.println(sb);
    }
    public static int binarySearch(int[] arr, int target) {
        int low = 0; 
        int high = arr.length - 1; 

        while(low <= high) {
            int mid = (low + high) / 2;
            // target값이 중간 위치의 값보다 작을 경우
            if(target < arr[mid]) {
                high = mid - 1;
            }
            // target값이 중간 위치의 값보다 클 경우
            else if(target > arr[mid]) {
                low = mid + 1;
            }
            // target값과 중간 위치의 값이 같을 경우
            else {
                return mid;
            }
        }
        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;
    }
}

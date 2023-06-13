package coplit;

public class rotatedArraySearch {
    public static void main(String[] args) {
        int output = rotatedSearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output);
    }

    public static int rotatedSearch(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;
        while (left <= right) {
           int mid = left + (right - left) / 2;
           if (rotated[mid] == target) {return mid;}
//            왼쪽 부분 배열이 정렬되어 있는 경우
            if (rotated[left] <= rotated[mid]) {
                if (rotated[left] <= target && target < rotated[mid]) {
                    right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
//                오른쪽 부분 배열이 정렬되어 있는 경우
                if (rotated[mid] < target && target <= rotated[right]) {
                    left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return -1;
    }
}


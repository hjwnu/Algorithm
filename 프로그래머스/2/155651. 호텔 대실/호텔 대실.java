import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
		Arrays.sort(book_time, (a,b) -> {
			if(a[0].equals(b[0])) return a[1].compareTo(b[1]);
			return a[0].compareTo(b[0]);
		});
        
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (String[] strings : book_time) {
			if (! pq.isEmpty() && pq.peek() <= toInt(strings[0])) pq.poll();
			pq.add(toInt(strings[1])+10);
		}

		return pq.size();
	}


	public static int toInt(String time){
		int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3,5));
		return h * 60 + m;
	}
}
import java.util.*;

class Solution {
        static String trg;
		static int answer = 0;
		static boolean[] visited;
		static String[] list;
		public int solution (String begin, String target, String[] words) {
			if(begin.equals(target)) return 0;
			if(!Arrays.asList(words).contains(target)) return 0;
			visited = new boolean[words.length];
			trg = target;
			list = words;
			dfs(begin, 0, 0);

			return answer;
		}

		public static void dfs (String begin, int loca, int cur){
			if(begin.equals(trg)) {
				answer = cur;
				return;
			}

			for(int i = 0 ; i < list.length;i++){
				if(visited[i]) continue;
				int diff = 0;
				String word = list[i];
				for(int j = 0; j < word.length(); j++){
					if(word.charAt(j) == begin.charAt(j)) diff++;
				}
				if(diff == word.length() - 1){
					if(!visited[i]) {
						visited[i] = true;
						dfs(word, i, cur+1);
						visited[i]  = false;
					}

				}
			}
		}
	}
/*

1. begin -> target과 맞는 지 검증 : 맞으면 그대로 0 return
2. 다르면 words 단어 하나씩 꺼내서, 알파벳 1개만 다른지 검증.
3. 1개만 다른 단어가 생기면, begin을 그 단어로 갱신하고, 방문처리. 단계 변수 +1
4. 1~3 반복
*/

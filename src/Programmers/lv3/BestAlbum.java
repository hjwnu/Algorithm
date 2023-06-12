package Programmers.lv3;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"Kclassic", "pop", "jpop", "Aclassic", "Kpop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
//        plays 값을 키로 맵에 저장, 밸류는 인덱스
//        plays 값 역순 정렬 후 인덱스 재조정
//        맵 값에 따라 genres 수정
//        아래 메서드로 재생횟수 가장 많은 장르 선별 후
//        배열에 징르 별로 앞에서부터(역순 정렬 된 상태) 두개 씩 저장

        return Plays;
//        int[] answer = new int[genres.length];
//        Map<String, Integer> genreplay = new HashMap<>();
//        for (int i =0; i < genres.length; i++){
//            genreplay.put(genres[i],genreplay.getOrDefault(genres[i],0)+plays[i]);
//        }
//        List<Map.Entry<String, Integer> > list =
//                new LinkedList<Map.Entry<String, Integer>>(genreplay.entrySet());
//
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
//            public int compare(Map.Entry<String, Integer> o1,
//                               Map.Entry<String, Integer> o2){
//                return (o2.getValue()).compareTo(o1.getValue());
//            }
//        });
//
//        List<String> most = new ArrayList<>();
//        for (Map.Entry<String, Integer> aa : list) {
//            most.add(aa.getKey());
//        }
//        System.out.println(most.get(0));
//        return answer;
//    }
    }
}

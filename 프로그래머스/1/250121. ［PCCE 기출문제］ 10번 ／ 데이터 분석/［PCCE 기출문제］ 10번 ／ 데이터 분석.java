import java.util.*;

class Solution {
    private static Map<String,Integer> extMap;
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        getExtMap();

        List<int[]> list = new ArrayList<>();
        int extIdx = extMap.get(ext);
        for(int i = 0 ; i < data.length ; i++){
            if(data[i][extIdx] < val_ext)
                list.add(data[i]);
        }
        int sortIdx = extMap.get(sort_by);
        list.sort(Comparator.comparingInt(o -> o[sortIdx]));

        return list.toArray(new int[0][]);
    }

    private static void getExtMap(){
        extMap = new HashMap<>();
        extMap.put("code",0);
        extMap.put("date",1);
        extMap.put("maximum",2);
        extMap.put("remain",3);
    }
}
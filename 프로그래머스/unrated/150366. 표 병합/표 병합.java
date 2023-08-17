import java.util.*;
class Solution {
    static String[][] table= new String[51][51];
    static int len = table.length;
    static String[][] isMerged = new String[51][51];
    static int mergedGroupNum = 1;
    
    public static String[] solution(String[] commands) {
        for(String[] t : table){
            Arrays.fill(t, "");
        }
        for(int i= 0; i < len; i++){
            for(int j= 0; j < len;j++){
                StringBuilder sb = new StringBuilder(i+","+j);
                isMerged[i][j] = sb.toString();
            }
        }
        List<String> ans = new ArrayList<>();
        for(String str : commands){
            String[] tmp = str.split(" ");
            String command = tmp[0];
            switch(command){
                case "UPDATE":
                    if(tmp.length==4){ 
                        update(tmp[1],tmp[2],tmp[3]); 
                    } else { update(tmp[1],tmp[2]); } 
                    break;
                case "MERGE": merge(tmp[1],tmp[2],tmp[3],tmp[4]); break;
                case "UNMERGE": unmerge(tmp[1],tmp[2]); break;
                case "PRINT": ans.add(print(tmp[1],tmp[2])); break;
            }
        }
        String[] cell = ans.toArray(new String[]{});
        return cell;
    }
    public static int toInt(String str){
        return Integer.parseInt(str);
    }
    
    public static void update(String first, String second, String value){
        int x = toInt(first); int y = toInt(second);
        String cell = isMerged[x][y];
        if(cell.charAt(0)=='M'){ // 병합된 셀을 바꾸면, 병합된 모든 셀 값 변경
            updateMergeGroup(cell, value);
        } 
        else { table[x][y] = value; } // 병합이 안 되었다면, 1개 셀만 변경
    }
    
    public static void updateMergeGroup(String mergedCell, String value){
        for(int i =1; i < len; i++){
            for(int j =1; j < len; j++){
                if(isMerged[i][j].equals(mergedCell)){ table[i][j] = value; }
            }
        }
    }
    
    public static void update(String value1, String value2){
        for(int i =1; i < len; i++){
            for(int j =1; j < len; j++){
                if(table[i][j].equals(value1)){ table[i][j] = value2; }
            }
        }
    }
    
    public static void merge(String first, String second,
                             String third, String fourth){
        if(first.equals(third)&&second.equals(fourth)){return;}
        
        int x1 = toInt(first); int y1 = toInt(second);
        int x2 = toInt(third); int y2 = toInt(fourth);
        String cell1 = isMerged[x1][y1]; String value1 = table[x1][y1];
        String cell2 = isMerged[x2][y2]; String value2 = table[x2][y2];
        
        if((cell1.equals(cell2))){return;} // 두 좌표가 이미 같은 병합그룹이면 패스
        
        // 두 셀 중, value2만 값을 가지고 있다면 value1을 value2로. 
        // 두 셀 중 value1만 가지고 있거나, 둘 다 가지고 있다면 value2를 value1로.
        String value = value1.equals("")?value2:value1;
        StringBuilder sb = new StringBuilder("M");
        
        if(cell1.charAt(0)=='M'&&cell2.charAt(0)=='M'){ // 두 좌표 모두 각각의 병합그룹
            sb.append(cell1);
            mergeGroup(cell1, cell2, value, sb.toString());
        } else if(cell1.charAt(0)=='M'||cell2.charAt(0)=='M'){ // 한 쪽만 병합된 상태
            String mergedCell = cell1.charAt(0)=='M'? cell1:cell2;
            isMerged[x1][y1] = isMerged[x2][y2] = mergedCell;
            updateMergeGroup(mergedCell, value);
        } else{ // 두 쪽 모두 병합 없는 상태
            sb.append(cell1);
            isMerged[x1][y1] = isMerged[x2][y2] = sb.toString();
            table[x1][y1] = table[x2][y2] = value;
        }
    }
    
    public static void mergeGroup(String cell1, String cell2, String value, String M){
        for(int i =1; i < len; i++){
            for(int j =1; j < len; j++){
                if(isMerged[i][j].equals(cell1)||isMerged[i][j].equals(cell2)){ 
                    isMerged[i][j]=M; table[i][j] = value; 
                }
            }
        }
    }
    
    public static void unmerge(String first, String second){
        int x = toInt(first); int y = toInt(second);
        String value = table[x][y];
        unmergeGroup(isMerged[x][y]);
        table[x][y] = value;
    }

    public static void unmergeGroup(String mergedCell){
        for(int i =1; i < len; i++){
            for(int j =1; j < len; j++){
                if(isMerged[i][j].equals(mergedCell)){
                    StringBuilder sb = new StringBuilder(i+","+j);
                    isMerged[i][j] = sb.toString();
                    table[i][j] = "";
                }
            }
        }   
    }
    
    public static String print(String first, String second){
        int x = toInt(first); int y = toInt(second);
        return table[x][y].equals("")? "EMPTY":table[x][y];
    }
}
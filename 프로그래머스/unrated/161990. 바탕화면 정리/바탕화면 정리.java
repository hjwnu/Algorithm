class Solution {
    public int[] solution(String[] wallpaper) {
        int xmin=51, xmax=0, ymin=51, ymax=0;
        for(int i =0 ; i < wallpaper.length;i++){
           for(int j =0; j < wallpaper[0].length();j++){
               if(wallpaper[i].charAt(j)=='#') {
                xmin = Math.min(j, xmin); ymin = Math.min(i,ymin);
                xmax = Math.max(j, xmax); ymax = Math.max(i,ymax);
               }
           }
        }
        return new int[]{ymin, xmin, ymax+1,xmax+1};
    }
}
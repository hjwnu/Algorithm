import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0){return cities.length*5;}
        
        List<String> cache = new ArrayList<>();
        int runTime = 0;
        for(String city : cities){
            city = city.toUpperCase();
            if(cache.contains(city)){
                runTime += 1; // cache hit
                cache.remove(city);
                cache.add(city); 
            } 
            else{
                runTime += 5; // cache miss
            
                if(cache.size()==cacheSize){cache.remove(0);}
                cache.add(city);    
            } 
            
        }
        return runTime;
    }
}
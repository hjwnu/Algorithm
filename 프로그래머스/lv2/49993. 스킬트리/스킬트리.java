import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        Queue<Character> must = new LinkedList<>();
        Queue<Character> custom = new LinkedList<>();
    
        
        int idx= 0; int ans =0;
        while(idx < skill_trees.length){
            for(char ch : skill.toCharArray()){must.add(ch);}
            for(char ch : skill_trees[idx++].toCharArray()){custom.add(ch);}
            
            while(!custom.isEmpty()){
                if(!must.contains(custom.peek())){custom.poll();}
                else{
                    if(must.peek().equals(custom.peek())){custom.poll(); must.poll();}
                    else{break;}
                }
            }
            if(custom.isEmpty()){ans++; must = new LinkedList<>();}
            else{custom = new LinkedList<>(); must = new LinkedList<>();}
        }
        return ans;
    }
}
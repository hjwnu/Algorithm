import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        Queue<Character> must = new LinkedList<>();
        Queue<Character> custom = new LinkedList<>();
    
        int idx= 0; int ans =0;
        while(idx < skill_trees.length){
            for(char ch : skill.toCharArray()){must.add(ch);} //필수 선행스킬 큐에 초기화
            for(char ch : skill_trees[idx++].toCharArray()){custom.add(ch);} //각 스킬트리를 큐에 초기화
            
            while(!custom.isEmpty()){
                Character nextSkill = custom.peek();
                Character nextMustSkill = must.peek();
                if(!must.contains(nextSkill)){custom.poll();} // 필수 스킬이 아니면 그냥 빼기
                else{ // 필수 선행스킬 순서와 스킬트리의 다음 스킬이 맞을 경우.
                    if(nextMustSkill.equals(nextSkill)){ custom.poll(); must.poll(); }
                    else{break;}
                }
            }
            if(custom.isEmpty()){ans++; must = new LinkedList<>();} // 커스텀 스킬트리가 빈 상태로 필수선행스킬이 모두 비워지지 않은 경우를 고려해 초기화해서 새로 비교
            else{custom = new LinkedList<>(); must = new LinkedList<>();} // 둘다 안비었으니 초기화해 새로 비교
        }
        return ans;
    }
}
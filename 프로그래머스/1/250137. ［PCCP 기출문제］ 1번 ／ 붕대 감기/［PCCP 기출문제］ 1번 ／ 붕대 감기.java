class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastAttack = Integer.MIN_VALUE;
        for(int i = 0 ; i < attacks.length;i++){
            lastAttack = Math.max(attacks[i][0], lastAttack);
        }
        int maxHealth = health;
        int continueTime = 0;
        int attackNum = 0;
        for(int time = 1 ; time <= lastAttack; time++){
            if(time == attacks[attackNum][0]){ 
                continueTime = 0;
                health -= attacks[attackNum][1];
                if(health <=0) return -1;
                attackNum++;
            } else {
                if(health < maxHealth){
                    continueTime++;
                    int recovery;
                    if(continueTime==bandage[0]) {
                        continueTime =0;
                        recovery = bandage[1]+bandage[2];
                    } else recovery = bandage[1];
                    if(health+recovery > maxHealth) health = maxHealth;
                    else health += recovery; 
                }
            }
        }
        return health;
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int curLeft = 10; // "*" = 10, "0" = 11, "#" = 12
        int curRight = 12;
        for(int i =0 ; i < numbers.length; i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                answer += "L"; curLeft = numbers[i];
            }
            else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                answer += "R"; curRight = numbers[i];
            }
            else{
                if(numbers[i]==0){numbers[i]=11;}
                int lDistance = leftD(numbers[i], curLeft); // 왼손 거리 계산
                int rDistance = rightD(numbers[i], curRight); // 오른손 거리 계산
                
                //가까운 쪽 손으로 누르기, 거리가 같다면 주사용 손으로 누르기.
                if(lDistance>rDistance){answer += "R"; curRight=numbers[i];}
                else if(lDistance<rDistance){answer += "L"; curLeft=numbers[i];}
                else{
                    if(hand.equals("left")){answer += "L"; curLeft=numbers[i];}
                    else{answer += "R"; curRight=numbers[i];}
                }
                
            }
        }
     return answer;
    }
    public int leftD(int numbers, int curLeft){
        int leftDistance = Math.abs(numbers-curLeft); 
        
        switch(leftDistance%2){
            case 1:if(leftDistance>3){leftDistance=3;} 
                   else if(leftDistance>=1){leftDistance=1;} break;

            case 0:if(leftDistance>6){leftDistance=4;}
                   else if(leftDistance>=2){leftDistance=2;} break;
        }
        
        return leftDistance;
    }    
    
    public int rightD(int numbers, int curRight){
        int rightDistance = Math.abs(numbers-curRight);
        switch(rightDistance%2){
            case 1:if(rightDistance>4){rightDistance=3;}
                   else if(rightDistance>=1){rightDistance=1;} break;

            case 0:if(rightDistance>7){rightDistance=4;}
                   else if(rightDistance>=2){rightDistance=2;} break;
        }
        
        return rightDistance;
    }   
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int curLeft = 10; // "*" = 10, "0" = 11, "#" = 12
        int curRight = 12;
        for(int i =0 ; i < numbers.length; i++){
            switch(numbers[i]){
                case 1: case 4: case 7: answer += "L"; curLeft = numbers[i]; break;
                case 3: case 6: case 9: answer += "R"; curRight = numbers[i]; break;
                default:
                    if(numbers[i]==0){numbers[i]=11;}
                    
                    String temp = whichHand(leftD(numbers[i], curLeft), 
                                        rightD(numbers[i], curRight), 
                                        hand);
                    
                    if(temp.equals("L")){curLeft = numbers[i];}
                    else{curRight = numbers[i];}
                    answer += temp;
                    break;
            }
        }
     return answer;
    }
    
    public String whichHand(int l, int r, String hand){
        return l==r? hand.equals("left")? "L":"R" : l>r? "R" : "L";
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
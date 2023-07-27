import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int curLeft = 10; // "*" = 10, "0" = 11, "#" = 12
        int curRight = 12;
        
        for(int i =0 ; i < numbers.length; i++){
            switch(numbers[i]){
                case 1: case 4: case 7: answer.append("L"); curLeft = numbers[i]; break;
                case 3: case 6: case 9: answer.append("R"); curRight = numbers[i]; break;
                default:
                    if(numbers[i]==0){numbers[i]=11;}
                    
                    //현재 눌러야할 키패드로부터 각각 왼손, 오른손 거리를 구하고 주 사용 손을 반영해 무엇을 입력할지 결정.
                    int leftD = distance(numbers[i], curLeft);
                    int rightD = distance(numbers[i], curRight);
                    String curHand = whichHand(leftD,rightD,hand);
                    answer.append(curHand);
                    
                    // 사용된 손의 현재 위치 저장 
                    if(curHand.equals("L")){curLeft = numbers[i];} 
                    else{curRight = numbers[i];}
                    break;
            }
        }
     return answer.toString();
    }
    
    public String whichHand(int l, int r, String hand){
        return l==r? (hand.equals("left")? "L":"R") : (l>r? "R" : "L");
        // 두 거리가 같다면 주 사용 손으로,                  다르다면 거리가 가까운 손으로 입력 
    }
    
    public int distance(int numbers, int curLo){
        int dis = Math.abs(numbers-curLo); 
        
        switch(dis%2){
            case 1:if(dis>3){dis=3;} // 2번 버튼과의 숫자 차이가 3보다 큰 홀수(7-2=5, 9-2=7, 11(0번버튼)-2=9)라면, 거리는 3이다. 5번 버튼과의 숫자차이가 (10(*버튼)-5=5, 12(#버튼)-5=7)라면 거리는 역시 3. 이외 8번, 0번 버튼에도 이 규칙은 동일하게 적용된다.
                   else if(dis>=1){dis=1;} break; // 가운데 버튼과의 숫자 차이가 1,3이면 거리는 1이다. 

            case 0:if(dis>6){dis=4;} // 2번 버튼과의 숫자 차이가 6보다 큰 짝수(10-2=8, 12-2=10)라면, 거리는 4이다. 5번,8번 버튼과의 거리가 4인 버튼은 없다.
                   else if(dis>=2){dis=2;} break;
        }
        
        return dis;
    }    
}
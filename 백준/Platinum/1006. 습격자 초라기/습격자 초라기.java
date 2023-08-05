import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, W;
    static int[] first, second, a,b,c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            int result = Integer.MAX_VALUE;
            String[] NW = br.readLine().split(" ");
            N = Integer.parseInt(NW[0]); // 구역의 개수
            W = Integer.parseInt(NW[1]); // 특수 소대원의 수

            String[] firstLine = br.readLine().split(" ");
            String[] secondLine = br.readLine().split(" ");

            first = new int[N];
            second = new int[N];

            // 구역 별 적의 수 배열 초기화
            for (int i = 0; i < N; i++) {
                first[i] = Integer.parseInt(firstLine[i]);
                second[i] = Integer.parseInt(secondLine[i]);
            }
            
            a = new int[N]; a[0] =1;
            b = new int[N]; b[0] =1;
            c = new int[N+1]; c[0] =0;
            
            calculateMinSpecialForces(0);
            result = Math.min(result,c[N]);
            if( N > 1){
                if(first[0]+first[N-1]<=W && second[0]+second[N-1]<=W){
                    a[1]=1; b[1]=1; c[1]=0; 
                    calculateMinSpecialForces(1);
                    result = Math.min(result,c[N-1]+2);
                }
                if(first[0]+first[N-1]<=W){
                    a[1]=2; b[1]=second[0]+second[1]>W?2:1;
                    c[1]=1; 
                    calculateMinSpecialForces(1);
                    result = Math.min(result,b[N-1]+1);
                }
                if(second[0]+second[N-1]<=W){
                    a[1]=first[0]+first[1]>W?2:1;
                    b[1]=2; c[1]=1; 
                    calculateMinSpecialForces(1);
                    result = Math.min(result, a[N-1]+1);
                }
            }
            System.out.println(result);
        }

        br.close();
    }

    private static void calculateMinSpecialForces(int startIdx) {
       for(int i = startIdx; i < N; i++){
           c[i+1] = Math.min(a[i]+1,b[i]+1);
          
           // c팀이 인접한 두개의 구역을 점령할 수 있는 경우
           if(first[i] + second[i] <= W){c[i+1] = Math.min(c[i+1],c[i]+1);}
           
           // c팀이 인접한 두개의 구역 * 2 를 점령할 수 있는 경우
           if( i>0 && first[i-1]+first[i] <= W && second[i-1]+second[i]<=W){c[i+1] = Math.min(c[i+1], c[i-1]+2);}
           
           //a,b팀 인덱스 조정
           if(i < N-1){
               a[i+1]=c[i+1]+1;
               b[i+1]=c[i+1]+1;
               
               // a팀이 인접한 두개 구역 점령
               if(first[i]+first[i+1]<=W){a[i+1] = Math.min(a[i+1], b[i]+1);}
               // b팀이 인접한 두개 구역 점령
               if(second[i]+second[i+1]<=W){b[i+1] = Math.min(b[i+1], a[i]+1);}
               
           }
       }
    }
}
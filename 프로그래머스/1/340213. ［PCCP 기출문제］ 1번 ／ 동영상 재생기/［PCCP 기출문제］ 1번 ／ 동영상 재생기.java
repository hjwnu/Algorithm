class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Opening opening = new Opening(op_start.replace(":",""), op_end.replace(":",""));
        Video video = new Video(video_len.replace(":",""), pos.replace(":",""), opening);
        for(String command : commands){
            video.move(command);
        }
        
        StringBuilder answer = new StringBuilder(String.valueOf(video.current));
        while(answer.length() != 4){
            answer.insert(0, "0");
        }
        answer.insert(2,":");
        return answer.toString();
    }
}

class Video {
    int total;
    int current;
    Opening opening;
    
    public Video(String total, String current, Opening opening){
        this.total = Integer.parseInt(total);
        this.current = Integer.parseInt(current);
        this.opening = opening;
    }
    
    public void move(String command){
        openingSkip();
        switch(command){
            case "prev": 
                minusTenSec();
                break;
            case "next":
                plusTenSec();
                break;
        }
        openingSkip();
    }
    
    public void openingSkip(){
        if(this.opening.start <= this.current 
          && this.current <= this.opening.end){
            this.current = this.opening.end;
        }
    }
    
    private void plusTenSec(){
        current += 10;
        if(current%100 >= 60 && current%100 <= 99){
            current += 40;
        }
        if(current >= total){
            current = total;
        }    
    }
    
    private void minusTenSec(){
        current -= 10;
        if(current%100 >= 60 && current%100 <= 99){
            current -= 40;
        }
        if(current <= 0){
            current = 0;
        } 
    }
}

class Opening {
    int start;
    int end;
    
    public Opening(String op_start, String op_end){
        this.start = Integer.parseInt(op_start);
        this.end = Integer.parseInt(op_end);
    }
}

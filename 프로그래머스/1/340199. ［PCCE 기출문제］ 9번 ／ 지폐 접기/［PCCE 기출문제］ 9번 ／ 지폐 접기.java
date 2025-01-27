class Solution {
    public int solution(int[] wallet, int[] bill) {
        Wallet wallet1 = new Wallet(wallet[0], wallet[1]);
        Bill bill1 = new Bill(bill[0], bill[1]);

        int answer = 0;
        while(!wallet1.canBeInWallet(bill1)){
            bill1.fold();
            answer++;
        }
        return answer;
    }
}

class Wallet extends Rectangle {

        public Wallet(int max, int min) {
            super(max, min);
        }

        public boolean canBeInWallet(Bill bill){
            return this.max >= bill.max && this.min >= bill.min;
        }
    }

    class Bill extends Rectangle {

        public Bill(int max, int min) {
            super(max, min);
        }

        public void fold(){
            max /= 2;
            checkMinMax();
        }
    }

    class Rectangle {
        protected int max;
        protected int min;
        public Rectangle(int max, int min) {
            if(max < min){
                this.max = min;
                this.min = max;
                return;
            }
            this.max = max;
            this.min = min;
        }

        public void checkMinMax(){
            if(this.min > this.max){
                int temp = min;
                this.min = max;
                this.max = temp;
            }
        }
    }
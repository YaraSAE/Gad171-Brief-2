import java.util.Random;

public class Die {
        int minDiceNbr = 1;
        int maxDiceNbr;
        int numberOnDie;
        static int counter = 0;
        static int number;
        
        public Die(){
            counter++;
            number = counter;
        }
    
        public void roll(){
            Random random = new Random();
            numberOnDie = minDiceNbr + random.nextInt(maxDiceNbr - minDiceNbr + 1);
        }

        public int getNumber() {
            return number;
        }
        public int getNumberOnDie() {
            return numberOnDie;
        }

        
        public static boolean allDiceAreEqual(Die[] dice) {
            int i = 0;
            while((i < dice.length) && (dice[0].numberOnDie == dice[i].numberOnDie)){
                i++;
            }
            if(i < dice.length) return false;
            return true;
        }
    }
    class D6 extends Die{
        D6(){
            maxDiceNbr = 3;
        }
    }
    class D3 extends Die{
        D3(){
            maxDiceNbr = 6;
    }
}


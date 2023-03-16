
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player {
    private int previoustileIndex;
    private int nextTileIndex;
    private static int count = 0;
    private int number;
    private Results results;
    private Random random;
    private Integer numberOfRoundsTillPlayerDecidesToLeave;
    private Integer money;
    private Integer startingMoney;

    public Player(){
        results = new Results();
        count++;
        number = count;
        random = new Random();
        numberOfRoundsTillPlayerDecidesToLeave = null; //The player is not in jail
        money = startingMoney;
    }
    
    public int getNextTileIndex() {
        return nextTileIndex;
    }

    public int getPrevioustileIndex() {
        return previoustileIndex;
    }
    public Results getResults() {
        return results;
    }
    public int getNumber() {
        return number;
    }
    public int getMoney(){
        return money;
    }
    public void pay(int amount) {
        money -= amount;
    }
    public void receive(int amount) {
        money += amount;
    }
    public void setNextTileIndex(int nextTileIndex) {
        this.nextTileIndex = nextTileIndex;
    }


    public void setPreviousTileIndex(int previoustileIndex) {
        this.previoustileIndex = previoustileIndex;
    }
    

    public String takeCardFromPile(String[] pile){
        return pile[0];
    }
    

    public void returnCardAtTheBackOfThePile(String[] pile){
        String temp = pile[0]; 
        for (int i = 0; i < pile.length - 1; i++) {
            pile[i] = pile[i + 1]; 
        }
        pile[pile.length - 1] = temp;
    }
    

    public void processOfTakingCardFromBoard(String[] pile, Board board) {
        String card = takeCardFromPile(pile);
        //System.out.println(card);
        //System.out.println("The pile was\n " + Arrays.toString(pile));
        if (card == "Advance to Go")
            nextTileIndex = 0;
        if (card == "Advance to Illinois Avenue")
            nextTileIndex = 1;
        if (card == "Advance to St. Charles Place")
            nextTileIndex = 2;
        if ((card == "Go directly to Jail") 
            || ( card == "Go directly to Jail - do not pass Go, do not collect $200")) {
                processGoingToJail();
                processLeavingJail();
                leaveJail();
            }
            
        if (card == "Take a walk on the Boardwalk")
            nextTileIndex = 39;
        if (card == "Advance token to nearest Railroad"){
            int temp = nextTileIndex + 1;
            while((board.getTiles()[temp].getName() != "Kings Cross Station")
                && (board.getTiles()[temp].getName() != "Marylebone Station") 
                && (board.getTiles()[temp].getName() != "Fenchurch St. Station")
                && (board.getTiles()[temp].getName() != "SLiverpool St. Station")){
                temp++;
                if(temp == board.getTiles().length)
                    temp = 0;
            }
        
            nextTileIndex = temp;
        }
        if (card == "Advance token to nearest Utility"){
            int temp = nextTileIndex + 1;
            while((board.getTiles()[temp].getName() != "Electric Company") 
                && (board.getTiles()[temp].getName() != "Water Works")){
                temp++;
                if(temp == board.getTiles().length)
                    temp = 0;
            }
            nextTileIndex = temp;
        }
        returnCardAtTheBackOfThePile(pile);
        //System.out.println("The pile now is\n " + Arrays.toString(pile));
    }


    public void processGoingToJail(){
        //System.out.println("                      Player " + number + " goes to jail");
        setNextTileIndex(10);
        getResults().addOneToSteppedTile(getNextTileIndex());
    }
    public void processLeavingJail(){
        int temp = random.nextInt(100);
        if (temp < 70) {
            numberOfRoundsTillPlayerDecidesToLeave = null;
        } else if (temp < 80) {
            numberOfRoundsTillPlayerDecidesToLeave = Integer.valueOf(1);
        } else if (temp < 85) {
            numberOfRoundsTillPlayerDecidesToLeave = Integer.valueOf(2);
        } else {
            numberOfRoundsTillPlayerDecidesToLeave = Integer.valueOf(3);
      }
    }
    public void leaveJail(){
        numberOfRoundsTillPlayerDecidesToLeave = null;
    }

    public void play(Die[] dice, Board board){
        int maxRepeatedDoubles = 3;
        int diceOutcome = 0;
        for(int i = 0; i < dice.length; i++){
            dice[i].roll();
            diceOutcome += dice[i].numberOnDie;
        }

        setNextTileIndex(getPrevioustileIndex() + diceOutcome);
        if(getNextTileIndex() >= board.getTiles().length){
            setNextTileIndex(getNextTileIndex() - board.getTiles().length);
        }
        
        for(int i = 1; i <= dice.length; i++) {
            //System.out.print("Die " + i + " ");
        }
        //System.out.println("Outcome");
        for(int i = 0; i < dice.length; i++){
            //System.out.print(dice[i].getNumberOnDie() + "      ");
        }
        //System.out.print(diceOutcome);
        if(Die.allDiceAreEqual(dice)) {
            //System.out.println("double!!!!!!!!");
            if (numberOfRoundsTillPlayerDecidesToLeave == null) //If the player is not in jail
                maxRepeatedDoubles--;
            else {
                leaveJail(); 
            }
            if(maxRepeatedDoubles == 0){
                //System.out.println("                      Player " + number + " goes to jail");
                setNextTileIndex(10);
                maxRepeatedDoubles = 3;
                getResults().addOneToSteppedTile(getNextTileIndex());
            }
        }
        else maxRepeatedDoubles = 3;
        if (numberOfRoundsTillPlayerDecidesToLeave != null) { //if the player is in jail
            numberOfRoundsTillPlayerDecidesToLeave = numberOfRoundsTillPlayerDecidesToLeave - 1;
            if (numberOfRoundsTillPlayerDecidesToLeave.equals(0)) {
                leaveJail();
            }
        }
        else {
            //System.out.println("  Player " + number + " is at " + 
                //board.getTiles()[getPrevioustileIndex()] + " and is moving to " 
                //+ board.getTiles()[getNextTileIndex()]);
            getResults().addOneToSteppedTile(getNextTileIndex());
            if(board.getTiles()[getNextTileIndex()].getName() == "Go to Jail"){
                processGoingToJail();
            }
            else if(board.getTiles()[getNextTileIndex()].getName() == "Chance"){
                //System.out.println("Player " + number + " gets a chance card that is:");
                processOfTakingCardFromBoard(board.getChanceCards(), board);
            }
            else if(board.getTiles()[getNextTileIndex()].getName() == "Community Chest"){
                //System.out.println("Player " + number + " gets Community Chest card that is:");
                processOfTakingCardFromBoard(board.getCommunityChestCards(), board);
            }
            
        setPreviousTileIndex(getNextTileIndex());
        //System.out.println();
        }
    }
}

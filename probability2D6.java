
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class probability2D6 {
    public static void main(String [] args) {
        final int numberOfPlayers = 2;
        final int numberOfRounds = 10000;
        Die[] dice  = new Die[2];
        dice[0] = new D6();
        dice[1] = new D6();
        Player[] players = new Player[numberOfPlayers];
        for(int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
        Board board = new Board();
        Tile[] tiles = board.getTiles(); 
        for(int j = 0; j < players.length; j++) {
            players[j].setPreviousTileIndex(0);
        }
        for (int i = 0; i < numberOfRounds; i++){
            for(int j = 0; j < players.length; j++) {
                //System.out.println("Player " + players[j].getNumber() + " is playing");
                players[j].play(dice, board);
            }
        }
        for(int j = 0; j < players.length; j++) {
            System.out.println("Player " + players[j].getNumber() + " results are:");
            players[j].getResults().printResults();
            for(int i = 0; i < 100; i++){
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
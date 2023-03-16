import java.util.Comparator;
import java.util.Arrays;

public class Results {
    private Board board;
    private Tile tiles[];

    public Results(){
        board = new Board();
        tiles = board.getTiles();
    }
    
    public void addOneToSteppedTile(int indexOfSteppedTile){
        board.getTiles()[indexOfSteppedTile].incrementTimesSteppedOnTile();
    }
    public void printResults(){
        Arrays.sort(tiles, new Comparator<Tile>() {
            @Override
            public int compare(Tile tile1, Tile tile2) {
                return Integer.compare(tile2.getTimesSteppedOnTile(), tile1.getTimesSteppedOnTile());
            }
        });
        for (int i = 0; i < tiles.length; i++) {
            System.out.println(tiles[i].getName() + " " + tiles[i].getTimesSteppedOnTile());
        }
    }
}

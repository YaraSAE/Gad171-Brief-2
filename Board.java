
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Board {
    private Tile[] tiles;
    private String[] chanceCards;
    private String[] communityChestCards;
    private int numberOfHouses = 32;
    private int numberOfHotels = 12;
   
    public Board(){
        tiles = new Tile[40];
        chanceCards = new String [] {"Advance to Go",
        "Advance to Illinois Avenue", "Advance to St. Charles Place", "Advance token to nearest Utility",
        "Advance token to nearest Utility", "Advance token to nearest Railroad", "Advance token to nearest Railroad",
        "Bank pays you dividend of $50", "Bank pays you dividend of $50","Get out of Jail free","Get out of Jail free",
        "Go back 3 spaces", "Go directly to Jail", "Go directly to Jail", "Go directly to Jail",
        "Make general repairs on all your property","Pay poor tax of $15","Take a trip to Reading Railroad",
        "Take a walk on the Boardwalk", "You have been elected Chairman of the Board - pay each player $50",
        "Your building loan matures - collect $150", "You have won a crossword competition - collect $100"};
        communityChestCards = new String [] {"Advance to Go", "Bank error in your favor - collect $200",
        "Doctor's fees - pay $50", "Get out of Jail free", "Get out of Jail free","Go directly to Jail - do not pass Go, do not collect $200",
        "Grand Opera Night - collect $50 from every player", "Holiday Fund matures - collect $100","Income tax refund - collect $20",
        "It is your birthday - collect $10 from every player","Life insurance matures - collect $100",
        "Pay hospital fees of $100", "Pay school fees of $50","Receive $25 consultancy fee",
        "You are assessed for street repairs - $40 per house, $115 per hotel","You have won second prize in a beauty contest - collect $10",
        "You inherit $100"};


        chanceCards = shuffleChanceCards();
        communityChestCards = shuffleCommunityChestCards();

        tiles[0] = new Tile("Go");
        tiles[1] = new Land("Old Kent road", 60, "Brown",50, 50, 2, 10, 30, 90, 160, 250, 30);
        tiles[2] = new Tile("Community Chest");
        tiles[3] = new Land("Whitechapel road", 60 ,"Brown", 50, 50, 4, 20, 60, 180, 320, 450, 30);
        tiles[4] = new Tile("Income Tax");
        tiles[5] = new Station("Kings Cross Station", 200, 25, 50, 100, 200, 100);
        tiles[6] = new Land("The Angel Islington", 100, "Light Blue",50 , 50, 6, 30, 90, 270, 400, 550, 50);
        tiles[7] = new Tile("Chance");
        tiles[8] = new Land("Euston road", 100, "Light Blue", 50, 50, 6, 30, 90, 270, 400, 550, 50);
        tiles[9] = new Land("Pentonville road", 120, "Light Blue", 50, 50, 8, 40, 100, 300, 450, 550, 100);
        tiles[10] = new Tile("jail");
        tiles[11] = new Land("Pall Mall", 140, "Pink", 100, 100, 10, 50, 150, 450, 625, 750, 70);
        tiles[12] = new Utility("Electric Company", 150, 75);
        tiles[13] = new Land("Whitehall road", 140, "Pink", 100, 100, 10, 50, 150, 450, 625, 750, 70);
        tiles[14] = new Land("Northumbled Avenue", 160, "Pink", 100, 100, 12, 60, 180, 500, 700, 900, 80);
        tiles[15] = new Station("Marylebone Station", 200, 25, 50, 100, 200, 100);
        tiles[16] = new Land("Bow Street", 180, "Orange", 100, 100, 14, 70, 200, 550, 750, 950, 90);
        tiles[17] = new Tile("Community Chest");
        tiles[18] = new Land("Marlborough Street", 180, "Orange", 100, 100, 14, 70, 200, 550, 750, 950, 90);
        tiles[19] = new Land("Vine Street", 200, "Orange", 100, 100, 16, 80, 220, 600, 800, 100, 100);
        tiles[20] = new Tile("Free Parking");
        tiles[21] = new Land("Strand", 220, "Red", 150, 150, 18, 90, 250, 700, 875, 1050, 110);
        tiles[22] = new Tile("Chance");
        tiles[23] = new Land("Fleet Street", 220, "Red", 150, 150, 18, 90, 250, 700, 875, 1050, 110);
        tiles[24] = new Land("Trafalgar Square", 240, "Red", 150, 150, 20, 100, 300, 750, 925, 1100, 120);
        tiles[25] = new Station("Fenchurch St. Station", 200, 25, 50, 100, 200, 100);
        tiles[26] = new Land("Leicester Square", 260, "Yellow", 150, 150, 22, 110, 330, 800, 975, 1150, 130);
        tiles[27] = new Land("Coventry Street", 260, "Yellow", 150, 150, 22, 110, 330, 800, 975, 1150, 130);
        tiles[28] = new Utility("Water Works", 150, 75);
        tiles[29] = new Land("Piccadilly", 280, "Yellow", 150, 150, 24, 120, 360, 850, 1025, 1200, 140);
        tiles[30] = new Tile("Go to Jail");
        tiles[31] = new Land("Regent Street", 300, "Green", 200, 200, 26, 130, 390, 900, 1100, 1275, 150);
        tiles[32] = new Land("Oxford Street", 300, "Green", 200, 200, 26, 130, 390, 900, 1100, 1275, 150);
        tiles[33] = new Tile("Community Chest");
        tiles[34] = new Land("Bond Street", 320, "Green", 200, 200, 28, 150, 450, 1000, 1200, 1400, 160);
        tiles[35] = new Station("Liverpool St. Station", 200, 25, 50, 100, 200, 100);
        tiles[36] = new Tile("Chance");
        tiles[37] = new Land("Park Lane", 350, "Dark Blue", 200, 200, 35, 175, 500, 1100, 1300, 1500, 175);
        tiles[38] = new Tile("Income Tax");
        tiles[39] = new Land("Mayfair", 400, "Dark Blue", 200, 200, 50, 200, 600, 1400, 1700, 2000, 200);
    }

    public Tile[] getTiles(){
        return tiles;
    }

    public String[] getChanceCards(){
        return chanceCards;
    }
    public String[] getCommunityChestCards() {
        return communityChestCards;
    }
    public String[] shuffleChanceCards(){
        Collections.shuffle(Arrays.asList(chanceCards));
        return chanceCards;
    }
    public String [] shuffleCommunityChestCards(){
        Collections.shuffle(Arrays.asList(communityChestCards));
        return communityChestCards;
    }
}

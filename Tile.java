public class Tile {
    final private String name;
    private int timeSteppedOnTile;

    public Tile(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    public int getTimesSteppedOnTile() {
        return timeSteppedOnTile;
    }
    public void incrementTimesSteppedOnTile() {
        this.timeSteppedOnTile++;
    }
}

class Land extends Tile {
    final private String color;
    final private int price;
    final private int costOfBuildingAHouse;
    final private int costOfBuildingAHotel;
    final private int costOfLandingOntileIfEmpty;
    final private int costOfLandingOntileIfHasOneHouse;
    final private int costOfLandingOntileIfHasTwoHouses;
    final private int costOfLandingOntileIfHasThreeHouses;
    final private int costOfLandingOntileIfHasfourHouses;
    final private int costOfLandingOntileIfHasHotel;
    final private int mortgage;
    private int costOfLandingOnTileCurrently;

    public Land(String name, int price, String color,int costOfBuildingAHouse,int costOfBuidlingAHotel,
                int costOfLandingOntileIfEmpty,int costOfLandingOntileIfHasOneHouse,
                int costOfLandingOntileIfHasTwoHouses,int costOfLandingOntileIfHasThreeHouses,
                int costOfLandingOntileIfHasfourHouses,int costOfLandingOntileIfHasHotel, int mortgage){
                    super(name);
                    this.price = price;
                    this.color = color;
                    this.costOfBuildingAHouse = costOfBuildingAHouse;
                    this.costOfBuildingAHotel = costOfBuidlingAHotel;
                    this.costOfLandingOntileIfEmpty = costOfLandingOntileIfEmpty;
                    this.costOfLandingOntileIfHasOneHouse = costOfLandingOntileIfHasOneHouse;
                    this.costOfLandingOntileIfHasTwoHouses = costOfLandingOntileIfHasTwoHouses;
                    this.costOfLandingOntileIfHasThreeHouses = costOfLandingOntileIfHasThreeHouses;
                    this.costOfLandingOntileIfHasfourHouses = costOfLandingOntileIfHasfourHouses;
                    this.costOfLandingOntileIfHasHotel = costOfLandingOntileIfHasHotel;
                    this.costOfLandingOnTileCurrently = costOfLandingOntileIfEmpty;
                    this.mortgage = mortgage;

    }
    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public int getCostOfBuildingAHouse() {
        return costOfBuildingAHouse;
    }
    public int getCostOfBuildingAHotel() {
        return costOfBuildingAHotel;
    }
    public int getCostOfLandingOntileIfEmpty() {
        return costOfLandingOntileIfEmpty;
    }

    public int getCostOfLandingOntileIfHasOneHouse() {
        return costOfLandingOntileIfHasOneHouse;
    }

    public int getCostOfLandingOntileIfHasTwoHouses() {
        return costOfLandingOntileIfHasTwoHouses;
    }
    
    public int getCostOfLandingOntileIfHasThreeHouses() {
        return costOfLandingOntileIfHasThreeHouses;
    }
    public int getCostOfLandingOntileIfHasfourHouses() {
        return costOfLandingOntileIfHasfourHouses;
    }
    public int getCostOfLandingOntileIfHasHotel() {
        return costOfLandingOntileIfHasHotel;
    }
    public int getMortgage() {
        return mortgage;
    }
}

class Station extends Tile {
    final private int price;
    final private int costOfRent;
    final private int costOfWhenOwnsTwo;
    final private int costOfWhenOwnsThree;
    final private int costOfWhenOwnsFour;
    final private int mortgage;
    

    public Station(String name, int price, int costOfRent, int costOfWhenOwnsTwo,int  costOfWhenOwnsThree,
                 int costOfWhenOwnsFour, int mortgage) {
        super(name);
        this.price = price;
        this.costOfRent = costOfRent;
        this.costOfWhenOwnsTwo = costOfWhenOwnsTwo;
        this.costOfWhenOwnsThree = costOfWhenOwnsThree;
        this.costOfWhenOwnsFour = costOfWhenOwnsFour;
        this.mortgage = mortgage;
    }

    public int getPrice() {
        return price;
    }
    public int getCostOfRent() {
        return costOfRent;
    }
    public int getCostOfWhenOwnsTwo() {
        return costOfWhenOwnsTwo;
    }
    public int getCostOfWhenOwnsThree() {
        return costOfWhenOwnsThree;
    }
    public int getCostOfWhenOwnsFour() {
        return costOfWhenOwnsFour;
    }
    public int getMortgage() {
        return mortgage;
    }
}
class Utility extends Tile {
    final private int price;
    final private int mortgage;
    
    public Utility(String name, int price, int mortgage) {
        super(name);
        this.price = price;
        this.mortgage = mortgage;
    }
    public int getPrice() {
        return price;
    }
    public int getMortgage() {
        return mortgage;
    }
    
}


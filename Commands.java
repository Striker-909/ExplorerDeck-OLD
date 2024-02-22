import java.util.ArrayList;
public class Commands {
  int stone = 0;
  int wood = 0;
  int water = 0;
  int soil = 0;
  int mineral = 0;
  int game = 0;
  int iron = 0;
  int gold = 0;
  public void commsResources () {
    System.out.println("Press r to display your resources.");
  }
  public boolean checkResources (ArrayList<Integer> stuff, int search, int num) {
    int numUm = 0;
    for (int ii = 0; ii < stuff.size(); ii++) {
      if (stuff.get(ii) == search) {
        numUm++;
      }
    }
    if (numUm >= num) {
      return true;
    } else {
      return false;
    }
  }
  public void displayResources() {
    System.out.println("You have:");
    System.out.println(stone + " Stone");
    System.out.println(wood + " Wood");
    System.out.println(water + " Water");
    System.out.println(soil + " Soil");
    System.out.println(mineral + " Mineral");
    System.out.println(game + " Game");
    System.out.println(iron + " Iron");
    System.out.println(gold + " Gold");
    stone = 0;
    wood = 0;
    water = 0;
    soil = 0;
    mineral = 0;
    game = 0;
    iron = 0;
    gold = 0;
  }
  
  public void resourcePlus (int n) {
    switch (n) {
      case 1: stone++;
        break;
      case 2: wood++;
        break;
      case 3: water++;
        break;
      case 4: soil++;
        break;
      case 5: mineral++;
        break;
      case 6: game++;
        break;
      case 7: iron++;
        break;
      case 8: gold++;
        break;
    }
  }
  public void choose (boolean smalls) {
    if (smalls) {
      System.out.println("Press b to build or r to see your resources.");
    } else {
      System.out.println("Press e to explore, b to build or r to see your resources.");
    }
  }
  public void rules() {
    System.out.println("-----------------------");
    System.out.println("The objective of the game is to explore all 25 cards that make up the idea, creating a comprehensive map. First, divide a piece of paper into 25 boxes, 5 by 5. Each of these boxes will contain one explorer card you draw throughout the game. Put the starting card anywhere on the edge of your map. Whenever you draw an new card you can put it into any box next to a box you have already explored. Each card you explore will provide you with some resources. There is a limit to how much you can explore. You can increase this limit by building transportation.");
    System.out.println(" ");
    System.out.println("There are three main counters in the game: your population, your food supply, and your housing. You begin with 40 people, 200 food, and 50 housing. Each person eats 1 food each day. Any person that doesn't get food will die. At the end of every season (7 days) the population will increase by 40%. Each housing stores 5 food, if there is too much food the excess will be destroyed. If all your people die, you lose the game.");
    System.out.println(" ");
    System.out.println("At the end of each turn there will be an event card. These cards are pulled randomly and correspond to the season. The season you start in is spring.");
    System.out.println(" ");
    System.out.println("There are four types of structures you can build. All structures require resources to build. Farms will take in resources and return food. Producion will use resources and food to create more resources. Housing will use resources and return housing. Transportation will use resources to increase your exploration limit.");
  }
}
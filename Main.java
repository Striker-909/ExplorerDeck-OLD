import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Card theCard = new Card();
    Random rand = new Random();
    Commands comms = new Commands();
    Event action = new Event();
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> supplies = new ArrayList<Integer>();
    int cardCount = 1;
    int cardCountReal = 1;
    int randomSelected;
    int numSelected = 0;
    int food = 200;
    int foodDay = 0;
    int people = 40;
    int housing = 50;
    int maxCards = 25;
    int day = 1;
    int lastSeason = 0;
    int season = 0;
    int cardsNeeded = 24;
    boolean infin = false;
    boolean small = false;
    boolean boat = false;
    boolean endTurn = false;
    boolean startNextTurn = true;
    //start
    System.out.println("You're awakened by a great moaning of the sea-worn oak planks that are supposed to hold the boat together. You groggily wonder if the ship had miraculously arrived at harbor three weeks ahead of time. But as you poke your head on to the deck you discover it is not so. You have landed on the sandy beach of some wild island. There are a few trees around and the soil is fertile, but the land is otherwise empty. As you search the boat you discover there are 40 survivors including yourself, and rations for less than a week. Will you explore the island and unlock it treasures, or will you die to starvation? Only time will tell. You discovered the Starter Beach. Here you can find stone, wood, water, and soil.");
    System.out.println("To see the rules, press r.");
    String choice = scan.nextLine();
    if (choice.equalsIgnoreCase("r")) {
      comms.rules();
      System.out.println("-----------------------");
    }
    System.out.println("Select your game mode. Press n to play in normal mode. Here your goal is discover all 25 cards. Press i to play infinte mode. Here the cards are unending and your goal is to survive as long as you can. Press s to play small island mode. Here you are limited to just one card and one of each resource to start. Press e to play escape mode. Here your goal is to build a boat to escape the island with unending cards.");
    choice = scan.nextLine();
    if (choice.equalsIgnoreCase("n")) {
      cardsNeeded = 24;
    } else if (choice.equalsIgnoreCase("i")) {
      infin = true;
      cardsNeeded = 2147483646;
    } else if (choice.equalsIgnoreCase("s")) {
      small = true;
      supplies.add(5);//mineral
      supplies.add(6);//game
      supplies.add(7);//iron
      supplies.add(8);//gold
      cardsNeeded = 2147483646;
    } else if (choice.equalsIgnoreCase("e")) {
      boat = true;
      infin = true;
      cardsNeeded = 2147483646;
    }
    if (!small) {
      theCard.intCard();
    }
    System.out.println("If you have one, enter a booster code. You only get one booster per game");
    int boost = -1;
    choice = scan.nextLine();
    if (choice.equalsIgnoreCase("wasteland-92740")) {
      boost = 0;
      theCard.wastelands();
      System.out.println("The wastelands booster adds 8 explorer cards. These cards only give one resource because they are wastelands. They will not replace other cards, only add new ones to the deck. In normal mode you will still only need to discover 25 cards to win.");
    } else if (choice.equalsIgnoreCase("catz-49275")) {
      boost = 1;
      theCard.catz();
      System.out.println("You stay with the catz every night; The fire provides a cozy light; The stories told; are very old; But you didn't know that catz bite. The catz booster adds 5 lymric explorer cards. They will not replace other cards, only add new ones to the deck. In normal mode you will still only need to discover 25 cards to win.");
    } else if (choice.equalsIgnoreCase("dino-56514")) {
      boost = 2;
      theCard.dino();
      System.out.println("ROOOAR! The dino booster adds 5 dinosaur themed explorer cards. They will not replace other cards, only add new ones to the deck. In normal mode you will still only need to discover 25 cards to win.");
    }
    System.out.println("-----------------------");
    supplies.add(1);//stone
    supplies.add(2);//wood
    supplies.add(3);//water
    supplies.add(4);//soil
    while (cardCount < cardsNeeded && cardCount > 0) {
      System.out.println("It is day " + day +". You have " + people + " people, " + food + " food and " + housing + " housing.");
      comms.choose(small);
      choice = scan.nextLine();
      while (choice.equalsIgnoreCase("e") || choice.equalsIgnoreCase("b") || choice.equalsIgnoreCase("r")) 
    {
    if (choice.equalsIgnoreCase("e") && !small) {
      //explore
      if (cardCount <= maxCards) {
        randomSelected = rand.nextInt(theCard.cardNum.size());
        numSelected = theCard.cardNum.get(randomSelected);
        theCard.discoverCard(numSelected, boost);
        System.out.println(theCard.cardBasic.get(randomSelected));
        if (theCard.freeSpace) {
          theCard.freeSpace = false;
          System.out.println("Select 3 resources to add: Stone = 1, Wood = 2, Water = 3, Soil = 4, Mineral = 5, Game = 6, Iron = 7, Gold = 8.");
          for (int ii = 0; ii < 3; ii++) {
            choice = scan.nextLine();
               if (choice.equalsIgnoreCase("1")) {
                  theCard.cardResources.add(1);
               } else if (choice.equalsIgnoreCase("2")) {
                  theCard.cardResources.add(2);
               } else if (choice.equalsIgnoreCase("3")) {
                  theCard.cardResources.add(3);
               } else if (choice.equalsIgnoreCase("4")) {
                  theCard.cardResources.add(4);
               } else if (choice.equalsIgnoreCase("5")) {
                  theCard.cardResources.add(5);
               } else if (choice.equalsIgnoreCase("6")) {
                  theCard.cardResources.add(6);
               } else if (choice.equalsIgnoreCase("7")) {
                  theCard.cardResources.add(7);
               } else if (choice.equalsIgnoreCase("8")) {
                  theCard.cardResources.add(8);
               }
          }
        }
        while (theCard.cardResources.size() > 0) {
          supplies.add(theCard.cardResources.get(0));
          theCard.cardResources.remove(0);
        }
        if (!infin) {
        theCard.discardCard(randomSelected);
        }
      cardCount++;
        cardCountReal++;
      choice = "end";
        if (theCard.drawAgain) {
          choice = "e";
          endTurn = false;
          maxCards++;
          System.out.println("-------NEW--CARD-------");
      } else {
        food = food + foodDay;
        food = food - people;
        if (food < 0) {
          people = people + food;
          food = 0; 
        }
          if (food > 5 * housing) {
          food = housing * 5;
        }
        endTurn = true;
        day++;
          }
        theCard.drawAgain = false;
      } else {
      System.out.println("You don't have enough transportation to explore further. Press b to build or r to see your resources.");
        endTurn = false;
      choice = scan.nextLine();
      }
    } else if (choice.equalsIgnoreCase("b")) {
      //build
      System.out.println("Press f to build a farm, press p to build production, press h to build housing, press t to build transportation.");
      choice = scan.nextLine();
      if (choice.equalsIgnoreCase("f")) {
        System.out.println("Choose what type of farm you want to build:");
        System.out.println("Press 1 to build a field (20 food per day) for 1 soil.");
          System.out.println("Press 2 to build a improved field (80 food per day) for 2 soil, 1 water and 1 mineral.");
        System.out.println("Press 3 to build a fishery (30 food per day) for 1 water and 1 wood.");
          System.out.println("Press 4 to build a improved fishery (100 food per day) for 2 water, 1 stone, 1 iron and 1 mineral.");
        System.out.println("Press 5 to build a hunting cabin (50 food per day) for 1 wood, 1 game and 1 iron.");
          System.out.println("Press 6 to build a improved hunting cabin (120 food per day) for 2 game, 1 gold, 1 stone and 1 mineral.");
        choice = scan.nextLine();
        if (choice.equalsIgnoreCase("1")) {
          if (comms.checkResources(supplies, 4, 1)) {
          supplies.remove((Object) 4);
          foodDay = foodDay + 20;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("2")) {
          if (comms.checkResources(supplies, 4, 2) && comms.checkResources(supplies, 3, 1) && comms.checkResources(supplies, 5, 1)) {
          supplies.remove((Object) 4);
          supplies.remove((Object) 4);
          supplies.remove((Object) 3);
          supplies.remove((Object) 5);
          foodDay = foodDay + 80;
          } else {
            choice = "z";
          }
        } if (choice.equalsIgnoreCase("3")) {
          if (comms.checkResources(supplies, 2, 1) && comms.checkResources(supplies, 3, 1)) {
          supplies.remove((Object) 2);
          supplies.remove((Object) 3);
          foodDay = foodDay + 30;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("4")) {
          if (comms.checkResources(supplies, 7, 1) && comms.checkResources(supplies, 3, 2) && comms.checkResources(supplies, 1, 1) && comms.checkResources(supplies, 5, 1)) {
          supplies.remove((Object) 3);
          supplies.remove((Object) 3);
          supplies.remove((Object) 1);
          supplies.remove((Object) 5);
          supplies.remove((Object) 7);
          foodDay = foodDay + 100;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("5")) {
          if (comms.checkResources(supplies, 7, 1) && comms.checkResources(supplies, 2, 1) && comms.checkResources(supplies, 6, 1)) {
          supplies.remove((Object) 2);
          supplies.remove((Object) 6);
          supplies.remove((Object) 7);
          foodDay = foodDay + 50;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("6")) {
          if (comms.checkResources(supplies, 8, 1) && comms.checkResources(supplies, 6, 2) && comms.checkResources(supplies, 1, 1) && comms.checkResources(supplies, 5, 1)) {
          supplies.remove((Object) 6);
          supplies.remove((Object) 6);
          supplies.remove((Object) 1);
          supplies.remove((Object) 5);
          supplies.remove((Object) 8);
          foodDay = foodDay + 120;
          } else {
            choice = "z";
          }
        }
      } else if (choice.equalsIgnoreCase("p")) {
        System.out.println("Choose what type of production you want to build:");
        System.out.println("Press 1 to build a lumberyard (Adds 2 wood) for 1 wood and 15 food per day.");
        System.out.println("Press 2 to build a improved lumberyard (Adds 3 wood) for 1 wood and 1 mineral and 35 food per day.");
        System.out.println("Press 3 to build a quarry (Adds 2 stone) for 1 stone and and 20 food per day.");
        System.out.println("Press 4 to build a improved quarry (Adds 3 stone) for 1 stone and 1 mineral and 50 food per day.");
        System.out.println("Press 5 to build a iron mine (Adds 2 iron) for 1 iron and 40 food per day.");
        System.out.println("Press 6 to build a iron factory (Adds 3 iron) for 1 iron and 1 mineral and 100 food per day.");
        System.out.println("Press 7 to build a gold mine (Adds 2 gold) for 1 gold and 55 food per day.");
          System.out.println("Press 8 to build a gold factory (Adds 3 gold) for 1 gold and 1 mineral and 125 food per day.");
        choice = scan.nextLine();
        if (choice.equalsIgnoreCase("1")) {
          if (comms.checkResources(supplies, 2, 1) ) { 
          supplies.add(2);
          foodDay = foodDay - 15;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("2")) {
           if (comms.checkResources(supplies, 2, 1) && comms.checkResources(supplies, 5, 1)) {
          supplies.add(2);
          supplies.add(2);
          foodDay = foodDay - 35;
          } else {
            choice = "z";
          }
        } if (choice.equalsIgnoreCase("3")) {
          if (comms.checkResources(supplies, 1, 1)) {
          supplies.add(1);
          foodDay = foodDay - 20;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("4")) {
        if (comms.checkResources(supplies, 1, 1) && comms.checkResources(supplies, 5, 1) ) {
          supplies.add(1);
          supplies.add(1);
          foodDay = foodDay - 50;
          } else {
            choice = "z";
          }
          foodDay = foodDay - 50;
        } else if (choice.equalsIgnoreCase("5")) {
      if (comms.checkResources(supplies, 7, 1)) {
          supplies.add(7);
          foodDay = foodDay - 40;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("6")) {
        if (comms.checkResources(supplies, 7, 1) && comms.checkResources(supplies, 5, 1)) {
          supplies.add(7);
          supplies.add(7);
          foodDay = foodDay - 100;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("7")) {
      if (comms.checkResources(supplies, 8, 1)) {
          supplies.add(8);
          foodDay = foodDay - 55;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("8")) {
  if (comms.checkResources(supplies, 8, 1) && comms.checkResources(supplies, 5, 1) ) {
          supplies.add(8);
          supplies.add(8);
          foodDay = foodDay - 125;
          } else {
            choice = "z";
          }
        }
      } else if (choice.equalsIgnoreCase("h")) {
        System.out.println("Choose what type of housing you want to build:");
        System.out.println("Press 1 to build a wooden house (Adds 5 housing) for 1 wood.");
          System.out.println("Press 2 to build a large wooden house (Adds 15 housing) for 2 wood.");
        System.out.println("Press 3 to build a stone house (Adds 10 housing) for 1 stone.");
          System.out.println("Press 4 to build a large stone house (Adds 25 housing) for 2 stone.");
        System.out.println("Press 5 to build a town hall (Adds 50% more housing) for 1 wood, 1 stone and 1 iron.");
          System.out.println("Press 6 to build a large town hall (Adds 100% more housing) for 2 stone, 2 iron, 1 gold and 1 wood.");
        choice = scan.nextLine();
        if (choice.equalsIgnoreCase("1")) {
          if (comms.checkResources(supplies, 2, 1)) {
          supplies.remove((Object) 2);
          housing = housing + 5;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("2")) {
          if (comms.checkResources(supplies, 2, 2)) {
          supplies.remove((Object) 2);
          supplies.remove((Object) 2);
          housing = housing + 15;
          } else {
            choice = "z";
          }
        } if (choice.equalsIgnoreCase("3")) {
          if (comms.checkResources(supplies, 1, 1)) {
          supplies.remove((Object) 1);
          housing = housing + 10;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("4")) {
          if (comms.checkResources(supplies, 1, 2)) {
          supplies.remove((Object) 1);
          supplies.remove((Object) 1);
          housing = housing + 25;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("5")) {
          if (comms.checkResources(supplies, 2, 1) && comms.checkResources(supplies, 7, 1) && comms.checkResources(supplies, 1, 1)) {
          supplies.remove((Object) 1);
          supplies.remove((Object) 7);
            supplies.remove((Object) 2);
          housing = (int)(Math.round(housing * 1.5));
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("6")) {
          if (comms.checkResources(supplies, 2, 1) && comms.checkResources(supplies, 1, 2) && comms.checkResources(supplies, 7, 2) && comms.checkResources(supplies, 8, 1)) {
          supplies.remove((Object) 2);
          supplies.remove((Object) 1);
          supplies.remove((Object) 1);
          supplies.remove((Object) 7);
          supplies.remove((Object) 7);
          supplies.remove((Object) 8);
          housing = housing * 2;
          } else {
            choice = "z";
          }
        }
      } else if (choice.equalsIgnoreCase("t")) {
        System.out.println("Choose what type of transportation you want to build:");
        System.out.println("Press 1 to build a wooden path (Adds 1 to limit) for 1 wood.");
        System.out.println("Press 2 to build a wooden road (Adds 3 to limit) for 2 wood.");
        System.out.println("Press 3 to build a stone path (Adds 2 to limit) for 1 stone.");
        System.out.println("Press 4 to build a stone road (Adds 5 to limit) for 2 stone.");
        System.out.println("Press 5 to build a boat path (Adds 4 to limit) for 1 wood and 1 water.");
        System.out.println("Press 6 to build a improved boat path (Adds 9 to limit) for 2 water, 1 iron and 1 wood.");
        System.out.println("Press 7 to build a railroad (Adds 6 to limit) for 1 iron, 1 stone and 1 wood.");
          System.out.println("Press 8 to build a improved railroad (Adds 13 to limit) for 1 gold, 2 iron and 2 stone.");
        if (boat) {
          System.out.println("Press 9 to build the escape boat for 5 wood, 4 stone, 2 water, 1 soil, 2 mineral, 2 game, 4 iron, 3 gold, 1000 food and 200 housing");
        }
        choice = scan.nextLine();
        if (choice.equalsIgnoreCase("1")) {
          if (comms.checkResources(supplies, 2, 1)) {
          supplies.remove((Object) 2);
          maxCards = maxCards + 1;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("2")) {
          if (comms.checkResources(supplies, 2, 2)) {
          supplies.remove((Object) 2);
          supplies.remove((Object) 2);
          maxCards = maxCards + 3;
          } else {
            choice = "z";
          }
        } if (choice.equalsIgnoreCase("3")) {
          if (comms.checkResources(supplies, 1, 1)) {
          supplies.remove((Object) 1);
          maxCards = maxCards + 2;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("4")) {
          if (comms.checkResources(supplies, 1, 2)) {
          supplies.remove((Object) 1);
          supplies.remove((Object) 1);
          maxCards = maxCards + 5;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("5")) {
          if (comms.checkResources(supplies, 2, 1) && comms.checkResources(supplies, 3, 1)) {
          supplies.remove((Object) 3);
          supplies.remove((Object) 2);
          maxCards = maxCards + 4;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("6")) {
          if (comms.checkResources(supplies, 2, 1) && comms.checkResources(supplies, 3, 2) && comms.checkResources(supplies, 7, 1)) {
          supplies.remove((Object) 2);
          supplies.remove((Object) 3);
          supplies.remove((Object) 3);
          supplies.remove((Object) 7);
          maxCards = maxCards + 9;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("7")) {
          if (comms.checkResources(supplies, 1, 1) && comms.checkResources(supplies, 7, 1) && comms.checkResources(supplies, 2, 1)) {
          supplies.remove((Object) 1);
          supplies.remove((Object) 2);
          supplies.remove((Object) 7);
          maxCards = maxCards + 6;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("8")) {
          if (comms.checkResources(supplies, 8, 1) && comms.checkResources(supplies, 7, 2) && comms.checkResources(supplies, 1, 2)) {
          supplies.remove((Object) 1);
          supplies.remove((Object) 1);
          supplies.remove((Object) 7);
          supplies.remove((Object) 7);
          supplies.remove((Object) 8);
          maxCards = maxCards + 13;
          } else {
            choice = "z";
          }
        } else if (choice.equalsIgnoreCase("9") && boat) {
          if (comms.checkResources(supplies, 1, 4) && comms.checkResources(supplies, 2, 5) && comms.checkResources(supplies, 3, 2) && comms.checkResources(supplies, 4, 1) && comms.checkResources(supplies, 5, 2) && comms.checkResources(supplies, 6, 2) && comms.checkResources(supplies, 7, 4) && comms.checkResources(supplies, 8, 3) && food >= 1000 && housing >= 200) {
          cardCount = 2147483647;
          } else {
            choice = "z";
          }
        }
      }
      if (choice == "z") {
        System.out.println("You don't have enough resources to do that.");
      comms.choose(small);
        endTurn = false;
        choice = scan.nextLine();
      } else {
      food = food + foodDay;
      food = food - people;
      if (food < 0) {
        people = people + food;
        food = 0;
      }
        if (food > 5 * housing) {
          food = housing * 5;
        }
      endTurn = true;
      day++;
    }
    } else if (choice.equalsIgnoreCase("r")) {

      //resources
      while (theCard.cardResources.size() > 0) {
          supplies.add(theCard.cardResources.get(0));
          theCard.cardResources.remove(0);
        }
      for (int ii = 0; ii < supplies.size(); ii++) {
          comms.resourcePlus(supplies.get(ii)); 
      }
      comms.displayResources();
      comms.choose(small);
      endTurn = false;
      choice = scan.nextLine();
    } else if (choice.equalsIgnoreCase("e") && small) {
      System.out.println("You've explored as far as you can.");
      comms.choose(small);
      endTurn = false;
      choice = scan.nextLine();
    }
      //end condition
      if (theCard.cardBasic.size() <= 0) {
        small = true;
      }
      if (food <= 0) {
        people = 0;
      }
      if (people <= 0) {
        cardCount = 0;
        endTurn = false;
      }
      if (cardCount > cardsNeeded) {
        endTurn = false;
      }
      if (endTurn) {
        System.out.println("---------EVENT---------");
      randomSelected = rand.nextInt(14);
      int randomEvent = ((randomSelected) + (season * 14));
      action.allEvents(randomEvent);
      System.out.println(action.textE);
      if (randomSelected == 13) {
        if (people > housing) {
          people = housing;
        }
      } else {
        people = (people + action.peopleE[randomEvent]);
      }
      food = (food + action.foodE[randomEvent]);
      housing = (housing + action.housingE[randomEvent]);
      supplies.add(action.resourceAdd[randomEvent]);
      supplies.remove((Object) action.resourceRemove[randomEvent]);
      if (food <= 0) {
        people = 0;
      }
      if (people <= 0) {
        cardCount = 0;
        endTurn = false;
      }
      //System.out.println(randomEvent);
      //seasons
      int seasonCount = ((day - 1)/7);
      season = (seasonCount%4);
      System.out.println("-----------------------");
      //System.out.println(season);
      if (season != lastSeason) {
        people = (int)(people * 1.4);
        switch (season) {
          case 0: System.out.println("Today is the first day of spring. Your population will grow by 40%.");
            break;
          case 1: System.out.println("Today is the first day of summer. Your population will grow by 40%");
            break;
          case 2: System.out.println("Today is the first day of fall. Your population will grow by 40%");
            break;
          case 3: System.out.println("Today is the first day of winter. Your population will grow by 40%");
            break;
        }
        endTurn = true;
      }
      lastSeason = season;
      }
      //0 Spring, 1 Summer, 2 Fall, 3 Winter
      //System.out.println(season);
      //start random event
      
      }
    }
    double percentExplored = (cardCountReal / 0.25);
    String win;
    String lose;
    if (boat) {
      infin = false;
    }
    if (infin || small) {
      lose = ".";
      win = "discovered the entire infinte island. I have no clue how you discovered the entire 2,147,483,647 cards of the";
    } else if (boat) {
      win = "escaped the";
      lose = "before you could escape the island.";
    } else {
      win = "discovered the entire";
      lose = "before you could discover all of the island.";
    }
    System.out.println("-----------------------");
    if (people <= 0) {
      System.out.println("Your entire population has starved to death " + lose + " You survived " + day + " days and explored " + Math.round(percentExplored) + "% of the island. This adventure ends here, but fortunately you can just play again.");
    } else {
      System.out.println("Congrats, you " + win +  " island in " + day + " days. You also developed a whole world. Do what you will with this new existance.");
    }
    System.out.println("Story, Code, Game, and Concept by Striker-909. This is my intellectual property, please do not copy or reproduce.");
  }
}

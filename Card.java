import java.util.ArrayList;
import java.util.Random;

public class Card {
  public boolean drawAgain = false;
  public boolean freeSpace = false;
  private int randomNum;
  public ArrayList<Integer> cardResources = new ArrayList<Integer>();
  public ArrayList<String> cardBasic = new ArrayList<String>();
  public ArrayList<Integer> cardNum = new ArrayList<Integer>();
  Random rand = new Random();

  public void intCard() {
    cardBasic.add("A range of mountains rises above the horizon. Its gentle slopes roll to the earth, covered in large pines, green against the brilliant white of fresh snow. You discovered the Wooded Slopes. Here you can find stone, wood, and ore.");//1
    cardBasic.add("Low rolling hills cover a vast meadow, large mammals graze the plain. The soil is fertile and good for growing, but there are no trees or mountains to hide the chill of the wind. You discovered the Hilly Plain. Here you can find stone, soil, and game.");//2
    cardBasic.add("Mountains reach across the land, crawling towards the sea. The cold sun grazes their peaks, glaring into your vision. These mountains may just be the oldest thing on this lonely island. You discovered the Mountain Range. Here you can find stone and ore.");//3
    cardBasic.add("You have never seen something so tall, even before landing on this island. Its peak soars so, so high, piercing through fluffy clouds. You know you could never climb to the top. You discovered the Tallest Mountain. Here you can find stone, mineral, and ore.");//4
    cardBasic.add("A river flows out of a quiet spring, hiden away in a mountain pass. Its stream can be followed across the island, nearly spliting it in two. You still hold superstitions that great beasts sleep below mountain lakes. You discovered the Mountain Spring. Here you can find stone, water, and mineral. *Tip* There are five river cards including this one. Once you have them all you can fill in the gaps to create a river.");//5
    cardBasic.add("The ground itself is ripped by a canyon so wide you can't see to the other side. You imagine that from above it looks like a giant's scar. It's so deep you can't even see the bottom, just dark echos. You discovered the Great Chasm. Here you can find extra stone and ore.");//6
    cardBasic.add("The mountains fold back like they are cowering from some greater evil. The warm valley between the peaks is protected from wind and snow. A hidaway where where you could disappear. You discovered the Mountain Valley. Here you can find stone and soil.");//7
    cardBasic.add("The woods you find are dark and deep, mysterious fog carpeting the ground. The dirt is cold but full of life. A deer stalks from behind a tree, stands for a second, then gallops off. You discovered the Thick Forest. Here you can find wood, soil, and game.");//8
    cardBasic.add("Giant trees reach their spindly limbs to the heavens, grasping at the sky. Birds fly, screaming, through the boughs. You can see the whole island from this vantage. You discovered the the Giant Trees. Here you can find extra wood and explore an additional card.");//9
    cardBasic.add("A rock tumbles off an edge falling, falling, falling. You don't hear it hit the ground, mearly the shush of it hitting the leaves. An entire forest as falled into the earth. You have discovered the Sunken Forest. Here you can find wood and ore.");//10
      cardBasic.add("Birds chirp from the sun kissed branches, their sweet melodies fill the air. Small critters scramble through the afternoon, chattering to their young. Fallen leaves coat the forest floor. You discovered the Decidious Woods. Here you can find wood, soil, and game.");//11
    cardBasic.add("Birds squwak, diving between the waves. Sea stars pulse in tidepools, small crabs crawl on and off sand. You are reminded of the warm beach where you would play for hours in your childhood. You discovered the Shoreline. Here you can find water and soil.");//12
    cardBasic.add("A strangly shaped pocket of water blocks your path. You are mesmerised by the slowly lapping waves. You don't know why it seems off, but there's definitely something wrong. You discovered the Strange Lake. Here you can find extra water and mineral.");//13
    cardBasic.add("An inland sea holds a small islet in its center. There is something on the isle, but you can't quite make it out. You try to swim across the lake, but the waves push you back to shore. You discovered the Island in the Lake. Here you can find water and ore.");//14
    cardBasic.add("After sundown the fireflys start to flick on and off. The crickets singing their little songs completes the ambience. Frogs croak, saying hello to the moon. You discovered the Wetlands. Here you can find wood, water, and soil. *Tip* There are five river cards including this one. Once you have them all you can fill in the gaps to create a river.");//15
    cardBasic.add("The river breaks into thousands of fractals, tiny streams furrowing the ground. The river becomes salty and joins the sea. Thick silty soil coats the ground. You discovered the River Delta. Here you can find water, soil, and mineral. *Tip* There are five river cards including this one. Once you have them all you can fill in the gaps to create a river.");//16
    cardBasic.add("The river curves, flows, and curves back on itself. It seems to have a mind of his own, avoiding this patch of land for no clear reason. You see shimmering flakes in the silt at the bottom. You have discovered the Horseshoe Bend. Here you can find water and ore. *Tip* There are five river cards including this one. Once you have them all you can fill in the gaps to create a river.");//17
    cardBasic.add("The river splits into two paths, a crossroads of sorts. The plain surrounding the river is rich and fertile. You follow one of the two streams. You discovered the River Fork. Here you can find water and extra soil and explore an additional card. *Tip* There are five river cards including this one. Once you have them all you can fill in the gaps to create a river.");//18
    cardBasic.add("Sand covers the world as far as the eye can see. The only break in the monotony is the occasional desert flower. If you went too far into the wastes, you may never return. You discovered the Endless Dunes. Here you can find extra mineral and ore.");//19
    cardBasic.add("Cold wind rips across the tundra, snow blowing nearly sideways. The whole world is white on white on white. If you were to look hard enough you could nearly see the small snowy critters. You discovered the Snowy Tundra. Here you can find game and ore.");//20
    cardBasic.add("A giant creation of logs woven together like thread dominates the horizon. From above it appears to be the nest of some giant bird. Three eggs lay in the nest, enough to feed a city. You discovered the Giant Nest. Here you can find wood and extra game.");//21
    cardBasic.add("A narrow tunnel splinters off into many, trailing to all corners of the island. The roof is held up by rotting supports and the walls are lined with iron. When you finally reemerge from the dark the sun is blinding. You discovered the Abandoned Mine. Here you can find extra iron and explore a new card.");//22
    cardBasic.add("Crumbling stones line a hillside, as if placed there by a giant eons ago. Moss covers a trapdoor buried in the soil. The hidden cellar is full of gold and glimmering walls. You discovered the Ancient Ruins. Here you can find mineral and extra gold.");//23
    cardBasic.add("Remember, this is your world to control. You have the ultimate say in every action. Do what you will with this card. You have discovered the Free Card. Here you can find whatever you want.");//24
    for (int ii = 1; ii <= cardBasic.size(); ii++) {
      cardNum.add(ii);
    }
  }
  public void wastelands() {
    cardBasic.add("Wind screams across the barren flat, echoing across the plain. There is no life, no grass, no trees. There is nothing here except for then endless rocky expanse. You discovered the Stoney Wastes. Here you can find stone.");
    cardBasic.add("A cleaved forest lies ruined, wood slowly rotting away. Many years ago it fell, all at once. It is impossible to know why. You discovered the Wooded Wastes. Here you can find wood.");
    cardBasic.add("The sun shines, reflecting off the endless blue, glistening. The sea smells of wind and salt. It reminds of something, but you can't recall what. You discovered the Open Ocean. Here you can find water.");
    cardBasic.add("A vast plain covers the world all the way to the horizon. The dirt is dry and dusty, because no life has touched this loam. Wind blows the dust into a great cloud, blotting out the sun. You discovered the Dusty Wastes. Here you can find soil.");
    cardBasic.add("The ground has crystalized, geometric patterns fractalizing infinitely. Just looking down breaks you vision, like looking into a kaleidoscope. You can see yourself, split and fragmented, in the reflection. You discovered the Crystalized Wastes. Here you can find mineral.");
    cardBasic.add("You can smell it before you see it. The ground is littered with hunks of rotting meat, flies buzz through the air. There was some mass extinction here, but it certianly was recent and unnatural. You discovered the Rotting Wastes. Here you can find game.");
    cardBasic.add("A shining mound towers above the glittering plain. The sharp ground rips into your boots, lacerating the soles of your feet. The sun refecting off the metal blinds you, forcing you to the ground. You found the Metal Wastes. Here you can find ore.");
    cardBasic.add("A skyscraping ladder stands free of any support. You climb to the top, seeing the ladder change material every couple meters. From the top you see the entire island, from sea to shining sea. You discovered the Ladder. Here you can explore a new card.");
    for (int ii = cardNum.size() + 1; ii <= cardBasic.size(); ii++) {
      cardNum.add(ii);
    }
  } 
  public void catz() {
    cardBasic.add("In the forest you find a flame; the catz surround it, they seem quite tame; the catz are nice; they offer you mice; Here you can find wood and game.");
    cardBasic.add("The catz sit primly on the loam, these are the grounds where they roam; did they move these boulders; upon kitten shoulders? Here you can find soil and stone.");
    cardBasic.add("The kittenz roll over on the floor; the catz watch the babies that they adore; The bath is far too scary and deep; but something shimmers underneath; here you can find water and ore.");
    cardBasic.add("You ask the wise cat how to be good; the cat is tall when on two feet stood; You must serch for that that shine; for the shine you must mine; here you can find mineral and wood");
    cardBasic.add("The day is hot, so hot that it boils; the catz work all day, an endless toil; they sink into the flood, turning dirt into mud, here you can find game and soil");
    for (int ii = cardNum.size() + 1; ii <= cardBasic.size(); ii++) {
      cardNum.add(ii);
    }
  }
  public void dino() {
    cardBasic.add("A tail splashes and thrashes in the salty sea. Suddenly, a giant head emerges, riping through the waves. Salt and quartz crusts the body, like barnacles clinging to a ship's hull. You discovered the Salty Sea Dino. Here you can find water and mineral.");
    cardBasic.add("Giant footsteps stamp through the forest, uprooting trees in their wake. New green sprouts burst through the dirt where the feet once stood. A roar echos in the distance. You discovered the Giant Forest Dino. Here you can find wood and soil.");
    cardBasic.add("Smol dinos scream on the broken edge. You close your eyes and stumble backwards, nearly falling off the cliff. You hear the crunch of some creature's demise, but it isn't yours. You discovered the Stoney Cliff Dinos. Here you can find stone and game.");
    cardBasic.add("A feathered dino squawks at your side, asking you ride it. Warily, you climb on its back, not expect the speed at which its powerful legs run. It takes you to a glittering spire that dominates the sky. You discovered the Shiny Explorer Dino. Here you can find ore and explore another card.");
    cardBasic.add("A glimmering nest catches your eye sitting alone and unguarded. You sneak in and take the eggs of soild gold. You turn around and glimpse your end: the mother standing over you. You found the Shiny Egg Dino. Here you can find gold and iron.");
    for (int ii = cardNum.size() + 1; ii <= cardBasic.size(); ii++) {
      cardNum.add(ii);
    }
  }

  public void discoverCard(int n, int booster) {
    randomNum = 7 + (rand.nextInt(2));
    /*
    1 = stone
    2 = wood
    3 = water
    4 = soil
    5 = mineral
    6 = game
    7 = iron
    8 = gold
    */
    switch (n) {
      case 1: cardResources.add(1);
        cardResources.add(2);
        cardResources.add(randomNum);
        break;
      case 2: cardResources.add(1);
        cardResources.add(4);
        cardResources.add(6);
        break;
      case 3: cardResources.add(1);
        cardResources.add(randomNum);
        break;
      case 4: cardResources.add(1);
        cardResources.add(5);
        cardResources.add(randomNum);
        break;
      case 5: cardResources.add(1);
        cardResources.add(3);
        cardResources.add(5);
        break;
      case 6: cardResources.add(1);
        cardResources.add(1);
        cardResources.add(randomNum);
        break;
      case 7: cardResources.add(1);
        cardResources.add(4);
        break;
      case 8: cardResources.add(2);
        cardResources.add(4);
        cardResources.add(6);
        break;
      case 9: cardResources.add(2);
        cardResources.add(2);
        drawAgain = true;
        break;
      case 10: cardResources.add(2);
        cardResources.add(randomNum);
        break;
      case 11: cardResources.add(2);
        cardResources.add(4);
        cardResources.add(6);
        break;
      case 12: cardResources.add(3);
        cardResources.add(4);
        break;
      case 13: cardResources.add(3);
        cardResources.add(3);
        cardResources.add(5);
        break;
      case 14: cardResources.add(3);
        cardResources.add(randomNum);
        break;
      case 15: cardResources.add(2);
        cardResources.add(3);
        cardResources.add(4);
        break;
      case 16: cardResources.add(3);
        cardResources.add(4);
        cardResources.add(5);
        break;
      case 17: cardResources.add(3);
        cardResources.add(randomNum);
        break;
      case 18: cardResources.add(3);
        cardResources.add(4);
        cardResources.add(4);
        drawAgain = true;
        break;
      case 19: cardResources.add(5);
        cardResources.add(5);
        cardResources.add(randomNum);
        break;
      case 20: cardResources.add(6);
        cardResources.add(randomNum);
        break;
      case 21: cardResources.add(2);
        cardResources.add(6);
        cardResources.add(6);
        break;
      case 22: cardResources.add(7);
        cardResources.add(7);
        drawAgain = true;
        break;
      case 23: cardResources.add(5);
        cardResources.add(8);
        cardResources.add(8);
        break;
      case 24: freeSpace = true;
        break;
      case 25:
        if (booster == 0) {
          cardResources.add(1);
        } else if (booster == 1) {
          cardResources.add(2);
          cardResources.add(6);
        } else if (booster == 2) {
          cardResources.add(3);
          cardResources.add(5);
        }
        break;
      case 26:
        if (booster == 0) {
          cardResources.add(2);
        } else if (booster == 1) {
          cardResources.add(1);
          cardResources.add(4);
        } else if (booster == 2) {
          cardResources.add(2);
          cardResources.add(4);
        }
        break;
      case 27:
        if (booster == 0) {
          cardResources.add(3);
        } else if (booster == 1) {
          cardResources.add(3);
          cardResources.add(randomNum);
        } else if (booster == 2) {
          cardResources.add(1);
          cardResources.add(6);
        }
        break;
      case 28:
        if (booster == 0) {
          cardResources.add(4);
        } else if (booster == 1) {
          cardResources.add(2);
          cardResources.add(5);
        } else if (booster == 2) {
          cardResources.add(randomNum);
          drawAgain = true;
        }
        break;
      case 29:
        if (booster == 0) {
          cardResources.add(5);
        } else if (booster == 1) {
          cardResources.add(4);
          cardResources.add(6);
        } else if (booster == 2) {
          cardResources.add(7);
          cardResources.add(8);
        }
        break;
      case 30:
        if (booster == 0) {
          cardResources.add(6);
        }
        break;
      case 31:
        if (booster == 0) {
          cardResources.add(randomNum);
        }
        break;
      case 32:
        if (booster == 0) {
          drawAgain = true;
        }
        break;
    }
  }

  public void discardCard (int n) {
    cardBasic.remove(n);
    cardNum.remove(n);
    cardResources.clear();
  }
}

  

/**
 * Write a description of class Monster here.
 * 
 * @author (Griffin Holloway) 
 * @version (5/16/16)
 */
public class Monster
{
    private String monsters;
    private int health;
    private int strength;
    private int speed;
    private int defense;
    private Monster[]monster = new Monster[11];
   public Monster(String m, int k, String[]l){
        monsters = m;
        System.out.println("Type boss # your on: '1', '2', '3', '4', '5', or Final?");
        if(monsters.equals("1"))
        {
        do{
            System.out.println("Type name of which boss to fight: Scorpion or Spider");
            if(monsters.equalsIgnoreCase("Spider"))
            {
                health=10;
                strength = 4;
                defense = 3;
                speed = 7;
            }
            else if(monsters.equalsIgnoreCase("Scorpion"))
            {
                health=7;
                strength = 6;
                defense = 5;
                speed = 3;
            } 
            else
                    System.out.println("Error: Not a Valid Monster");
      }while(!monsters.equals("quit"));
    }
    else if(monsters.equals("2"))
    {
        do{
            System.out.println("Type name of which boss to fight: 'Troll' or 'Giant'");
            if(monsters.equalsIgnoreCase("Troll"))
            {
                health=5;
                strength = 4;
                defense = 6;
                speed = 10;
            }
            else if(monsters.equalsIgnoreCase("Giant"))
            {
                health=12;
                strength = 9;
                defense = 4;
                speed = 2;
            }
            else
                    System.out.println("Error: Not a Valid Monster");
      }while(!monsters.equals("quit"));
    }
     else if(monsters.equals("3"))
     {
      do{
            System.out.println("Type name of which boss to fight: 'Skeleton Pirate' or Apperition");
            if(monsters.equalsIgnoreCase("Skeleton Pirate"))
            {
                health=5;
                strength=8;
                defense=3;
                speed=7;
            }
            if(monsters.equalsIgnoreCase("Apperition"))
            {
                health=3;
                strength=9;
                defense=1;
                speed=6;
            }
            else
                System.out.println("Error: Not a Valid Monster");
      }while(!monsters.equals("quit"));
    }
    else if(monsters.equals("4"))
    {
      do{
            System.out.println("Type name of which boss to fight: 'Troll' or 'Giant'");
            if(monsters.equalsIgnoreCase("Troll"))
            {
                health=5;
                strength = 4;
                defense = 6;
                speed = 10;
            }
            else if(monsters.equalsIgnoreCase("Giant"))
            {
                health=12;
                strength = 9;
                defense = 4;
                speed = 2;
            }
            else
                    System.out.println("Error: Not a Valid Monster");
      }while(!monsters.equals("quit"));
    }
    else if(monsters.equals("5"))
    {
      do{
            System.out.println("Type name of which boss to fight: 'Foot Soldier' or 'Hell GateKeeper'");
            if(monsters.equalsIgnoreCase("Undead Foot Soldier"))
            {
                health=7;
                strength = 7;
                defense = 10;
                speed = 6;
            }
            else if(monsters.equalsIgnoreCase("Hell GateKeeper"))
            {
                health=12;
                strength = 9;
                defense = 4;
                speed = 7;
            }
            else
                    System.out.println("Error: Not a Valid Monster");
      }while(!monsters.equals("quit"));
    }
  }
    
}
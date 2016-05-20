import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    static Scanner scan = new Scanner(System.in);
    static Player player;
    static Map map = new Map();
    static String choice;
    static Items[]it = new Items[5];
    static ArrayList<String> itemsFound = new ArrayList<String>();

    static boolean isDead = false;

    public static void main(String[]args){
        Player info = new Player();
        boolean ok = false;

        System.out.println("Welcome to...");
        System.out.println("               ========    |     |    |=====");
        System.out.println("                  ||       |     |    |");
        System.out.println("                  ||       |=====|    |===");
        System.out.println("                  ||       |     |    |");
        System.out.println("                  ||       |     |    |=====");
        System.out.println("");
        System.out.println("       _______");
        System.out.println("      /               /\\      \\            /  |=======   ");
        System.out.println("     /               /  \\      \\          /   |   ");
        System.out.println("    /               /    \\      \\        /    |   ");
        System.out.println("   |               /------\\      \\      /     |=====   ");
        System.out.println("    \\             /        \\      \\    /      |   ");
        System.out.println("     \\           /          \\      \\  /       |   ");
        System.out.println("      \\______   /            \\      \\/        |=======   ");

        System.out.println("Type 'help' for instructions");
        System.out.println("Otherwise, choose your class");
        do{
            System.out.println("");
            System.out.println("Your choices are: \n Warrior \n Scout \n Brute \n Tank");
            System.out.println("Or type 'about (insert class here)' to see that class's stats");
            choice = scan.nextLine();
            if(choice.equalsIgnoreCase("help")){
                System.out.println("");
                System.out.println("This is an adventure-based RPG (Role-playing game, not Rocket-Propelled Grenade)");
                System.out.println("You will be adventuring down into the cave filled with treasure and monsters");
                System.out.println("If you can beat the boss inside, you win!");
                System.out.println("");
                System.out.println("ABOUT CLASSES:");
                System.out.println("Each class has its own set of stats. 20 total 'points' are distributed thoughout 4 stats:");
                System.out.println(" HP - The amount of health you have. Only potions will heal you.");
                System.out.println(" Attack - How much damage you do");
                System.out.println(" Defense - How much damage you DON'T take");
                System.out.println(" Speed - Determines who attacks first");
                System.out.println("   *Note: Minimum damage taken is 1 dmg");
                System.out.println("");
                System.out.println("ABOUT ITEMS:");
                System.out.println("You can equip 5 items total. These items will affect your stats, and give you an edge in battle!");
                System.out.println("And don't worry, you keep all items you find, so you can mix and match to find what suits you best!");
                System.out.println("  *Note: Potions do not count towards you 5 items total.");
                System.out.println("");
                System.out.println("ABOUT THE MAP:");
                System.out.println("Type 'map' at any time to see the map!");
                System.out.println("The final boss is at the bottom right corner, marked by 'X'");
                System.out.println("Your location is marked by 'O'");
                System.out.println("");
                System.out.println("Ready? I hope you are! Choose your class:");
                System.out.println("Your choices are: \n Warrior \n Scout \n Brute \n Tank");
                System.out.println("Or type 'about (insert class here)' to see that class's stats");
                choice = scan.nextLine();
            }
            if(choice.equalsIgnoreCase("about warrior"))
            {
                System.out.println("");
                System.out.println(info.getStats("warrior"));
                choice = "";
            }
            else if(choice.equalsIgnoreCase("about scout")){
                System.out.println("");
                System.out.println(info.getStats("scout"));
                choice="";
            }
            else if(choice.equalsIgnoreCase("about brute")){
                System.out.println("");
                System.out.println(info.getStats("brute"));
                choice="";
            }
            else if(choice.equalsIgnoreCase("about tank")){
                System.out.println("");
                System.out.println(info.getStats("tank"));
                choice="";
            }
            else if(choice.equalsIgnoreCase("warrior")){
                player = new Player("warrior",it);
                Items sword = new Items(1,0,0,0,"A Simple Wooden Sword","Wooden Sword");
                player.setItem(0, sword);
                ok = true;
            }
            else if(choice.equalsIgnoreCase("scout")){
                player = new Player("scout",it);
                ok = true;
            }
            else if(choice.equalsIgnoreCase("brute")){
                player = new Player("brute",it);
                ok = true;
            }
            else if(choice.equalsIgnoreCase("tank")){
                player = new Player("tank",it);
                ok = true;
            }
            else
            {
                System.out.println("Not a valid Choice");
                choice = "";
            }
        }while(!ok);
        map.enterRoom(0,0);
        System.out.println();
        map.printMap();

        moveRooms();

        executeRoom();
    }

    public static void moveRooms()
    {
        boolean leftRoom = false;
        do{
            try{
                System.out.println("Which way would you like to go? (U/D/L/R)");
                choice = scan.nextLine();
                if(choice.equalsIgnoreCase("U")){
                    map.leaveRoom(map.getRow(),map.getCol());
                    map.enterRoom(map.getRow()-1,map.getCol());
                    leftRoom = true;
                }
                else if(choice.equalsIgnoreCase("D")){
                    map.leaveRoom(map.getRow(),map.getCol());
                    map.enterRoom(map.getRow()+1,map.getCol());
                    leftRoom = true;
                }
                else if(choice.equalsIgnoreCase("L")){
                    map.leaveRoom(map.getRow(),map.getCol());
                    map.enterRoom(map.getRow(),map.getCol()-1);
                    leftRoom = true;
                }
                else if(choice.equalsIgnoreCase("R")){
                    map.leaveRoom(map.getRow(),map.getCol());
                    map.enterRoom(map.getRow(),map.getCol()+1);
                    leftRoom = true;
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("You can't go that way!");  
                leftRoom = false;
            }
        }while(!leftRoom);
        map.printMap();
    }

    public static void executeRoom()
    {

        it = player.getItems();
        Random gen = new Random();
        int whoAttacks = 2;
        int canRun = 0;
        boolean ran = false;
        int dmgDone = 0;
        int dmgTaken = 0;
        int strModifier = 0;
        int spdModifier = 0;
        int defModifier = 0;

        Monster monster = new Monster(1);
        monster=monster.spawnMonster(monster);

        System.out.println("A "+monster.getName()+" appeared");

        System.out.println("Get Ready to Battle");
        do{
            if(player.getSpd()>monster.getSpeed()){
                System.out.println("You are attacking!");
                System.out.println("What do you want to do? (Attack, Run)");
                choice = scan.nextLine();
                if(choice.equalsIgnoreCase("Attack"))
                {
                    for(int i = 0;i<it.length;i++){
                        if(it[i]!=null){
                            if(it[i].getStr()>0){
                                strModifier+=it[i].getStr();
                            }
                        }
                    }
                    dmgDone+=player.getStr();
                    dmgDone+=strModifier;
                    dmgDone-=monster.getDef();
                    dmgDone = dmgDone*-1;
                    monster.setHP(dmgDone);
                    System.out.println("The monster has "+monster.getHP()+" health remaining.");
                    dmgDone=0;
                    strModifier = 0;
                    if(monster.getHP()<=0)
                    {
                        System.out.println("You defeated the "+monster.getName()+"!");
                    }
                    System.out.println("The "+monster.getName()+" attacks!");
                    for(int i = 0;i<it.length;i++){
                        if(it[i]!=null){
                            if(it[i].getDef()>0){
                                defModifier+=it[i].getDef();
                            }
                        }
                    }
                    dmgTaken=monster.getStr();
                    dmgTaken-=player.getDef();
                    dmgTaken-=defModifier;
                    if(dmgTaken<1)
                        dmgTaken=1;
                    dmgTaken=dmgTaken*-1;                
                    player.changeHp(dmgTaken);
                    System.out.println("You have "+player.getHp()+" HP remaining");
                    dmgTaken = 0;
                    defModifier = 0;
                    if(player.getHp()<=0)
                        System.out.println("You were defeated...");
                }
                else if(choice.equalsIgnoreCase("Run"))
                {
                    canRun = gen.nextInt(2);
                    if(canRun==0)
                        System.out.println("Couldn't Run!");
                    else if(canRun==1){
                        System.out.println("Barely got away!");
                        ran = true;
                    }
                }
                else
                    System.out.println("Not a valid choice! You lose your turn!");
            }
            else if(player.getSpd()<monster.getSpeed()){
                System.out.println("The "+monster.getName()+" attacks!");
                for(int i = 0;i<it.length;i++){
                    if(it[i]!=null){
                        if(it[i].getDef()>0){
                            defModifier+=it[i].getDef();
                        }
                    }
                }
                dmgTaken=monster.getStr();
                dmgTaken-=player.getDef();
                dmgTaken-=defModifier;
                if(dmgTaken<1)
                    dmgTaken=1;
                dmgTaken=dmgTaken*-1;                
                player.changeHp(dmgTaken);
                System.out.println("You have "+player.getHp()+" HP remaining");
                dmgTaken = 0;
                defModifier = 0;
                if(player.getHp()<=0)
                    System.out.println("You were defeated...");

                System.out.println("You are attacking!");
                System.out.println("What do you want to do? (Attack, Run)");
                choice = scan.nextLine();
                for(int i = 0;i<it.length;i++){
                    if(it[i]!=null){
                        if(it[i].getStr()>0){
                            strModifier+=it[i].getStr();
                        }
                    }
                }
                dmgDone+=player.getStr();
                dmgDone+=strModifier;
                dmgDone-=monster.getDef();
                dmgDone = dmgDone*-1;
                monster.setHP(dmgDone);
                System.out.println("The monster has "+monster.getHP()+" health remaining.");
                dmgDone=0;
                strModifier = 0;
                if(monster.getHP()<=0)
                {
                    System.out.println("You defeated the "+monster.getName()+"!");
                }
            }
            else if(choice.equalsIgnoreCase("Run"))
            {
                canRun = gen.nextInt(2);
                if(canRun==0)
                    System.out.println("Couldn't Run!");
                else if(canRun==1){
                    System.out.println("Barely got away!");
                    ran = true;
                }
            }
            else
                System.out.println("Not a valid choice! You lose your turn!");
        }while(player.getHp()>0&&monster.getHP()>0&&!ran);
    }
}


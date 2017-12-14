import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
/**
 * Game class and gameplay of The Cave
 * 
 * @author Ryan Lake
 * @version 1.2
 */
public class Game
{
    static Scanner scan = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);
    static Player player;
    static Map map = new Map();
    static String choice;
    static String difficulty;
    static Items[]it = new Items[5];
    static ArrayList<Items> allItems = new ArrayList<Items>();
    static ArrayList<Items> itemsFound = new ArrayList<Items>();

    static boolean isDead = false;
    
    static Items swordOfAndrew = new Items(12,5,4,8,"This epic sword was thought to be lost. After all, it was in my bedroom.","The Blade of Andrew");

    public static void main(String[]args){
        createAllItems();
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

        do{
            System.out.println();
            System.out.println("Type 'help' for instructions");
            if(difficulty==null)
                System.out.println("Otherwise, choose your difficulty. (Easy/Hard)");
            else{
                System.out.println("Otherwise, choose your class");
                System.out.println("Your choices are: \n Warrior \n Scout \n Brute \n Tank \n Assassin");
                System.out.println("Or type 'about (insert class here)' to see that class's stats");
            }
            choice = scan.nextLine();

            if(choice.equalsIgnoreCase("help")){
                System.out.println("");
                System.out.println("This is an adventure-based RPG (Role-Playing Game, not Rocket-Propelled Grenade)");
                System.out.println("You will be adventuring down into the cave filled with treasure and monsters");
                System.out.println("If you can beat the boss inside, you win!");
                System.out.println("");
                System.out.println("ABOUT CLASSES:");
                System.out.println("Each class has its own set of stats. 15 total 'points' are distributed thoughout 4 stats:");
                System.out.println("  HP - The amount of health you have.");
                System.out.println("  Attack - How much damage you do");
                System.out.println("  Defense - How much damage you DON'T take");
                System.out.println("  Speed - Determines who attacks first");
                System.out.println("      *Note: Minimum damage taken or inflicted is 1 dmg");
                System.out.println("");
                System.out.println("ABOUT ITEMS:");
                System.out.println("You can equip 5 items total. These items will affect your stats, and give you an edge in battle!");
                System.out.println("And don't worry, you keep all items you find, so you can mix and match to find what suits you best!");
                System.out.println("  *Note: Potions do not count towards you 5 items total.");
                System.out.println("");
                System.out.println("ABOUT THE MAP:");
                System.out.println("The final boss is at the bottom right corner, marked by 'X'");
                System.out.println("Your location is marked by 'O'");
                System.out.println("Enemies get harder as you get closer to the boss.");
                System.out.println("Move around in the map by pressing U(UP), D(Down), L(Left), or R(Right)");
                System.out.println("");
                System.out.println("ABOUT DIFFICULTY:");
                System.out.println("There are two difficulties: Easy or Hard");
                System.out.println("In EASY Mode, your HP resets every battle.");
                System.out.println("In HARD Mode, your HP doesn't reset. Potions are the only way to heal.");   
                System.out.println("");
                System.out.println("Ready? I hope you are! Choose your difficulty: (Easy/Hard)");
                choice = scan.nextLine();
                if(choice.equalsIgnoreCase("easy"))
                    difficulty = "easy";
                else if(choice.equalsIgnoreCase("hard"))
                    difficulty = "hard";
                else
                    System.out.println("Not a valid choice. Defaulting to Easy..."); difficulty = "easy";
                System.out.println("");
                System.out.println("Now choose your Class.");
                System.out.println("Your choices are: \n Warrior \n Scout \n Brute \n Tank \n Assassin");
                System.out.println("Or type 'about (insert class here)' to see that class's stats");
                choice = scan.nextLine();
            }
            if(choice.equalsIgnoreCase("easy")||choice.equalsIgnoreCase("hard"))
            {
                if(choice.equalsIgnoreCase("easy")){
                    difficulty = "easy";  
                    System.out.println("Difficulty set to easy.");
                    System.out.println("Now choose your Class. ");
                    System.out.println("Your choices are: \n Warrior \n Scout \n Brute \n Tank \n Assassin");
                    System.out.println("Or type 'about (insert class here)' to see that class's stats");
                    choice = scan.nextLine();
                    System.out.println();
                }
                else if(choice.equalsIgnoreCase("hard"))
                {
                    difficulty = "hard"; 
                    System.out.println("Difficulty set to hard.");
                    System.out.println("Now choose your Class. ");
                    System.out.println("Your choices are: \n Warrior \n Scout \n Brute \n Tank \n Assassin");
                    System.out.println("Or type 'about (insert class here)' to see that class's stats");
                    choice = scan.nextLine();
                    System.out.println();
                }
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
            else if(choice.equalsIgnoreCase("about assassin")){
                System.out.println("");
                System.out.println(info.getStats("assassin"));
                choice="";
            }
            else if(choice.equalsIgnoreCase("warrior")){
                player = new Player("warrior",it);
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
            else if(choice.equalsIgnoreCase("assassin")){
                player = new Player("assassin",it);
                ok = true;
            }
            else
            {
                System.out.println("Not a valid Choice");
                choice = "";
            }
        }while(!ok);
        map.startPoint(0,0);
        System.out.println();

        gameplay();
    }

    public static void moveRooms()
    {
        boolean leftRoom = false;
        do{
            try{
                System.out.println("Which way would you like to go? (U/D/L/R or Potion)");
                choice = scan.nextLine();
                if(choice.equalsIgnoreCase("U")){
                    map.enterRoom(map.getRow()-1,map.getCol(),map.getRow(),map.getCol());
                    leftRoom = true;
                }
                else if(choice.equalsIgnoreCase("D")){
                    map.enterRoom(map.getRow()+1,map.getCol(),map.getRow(),map.getCol());
                    leftRoom = true;
                }
                else if(choice.equalsIgnoreCase("L")){
                    map.enterRoom(map.getRow(),map.getCol()-1,map.getRow(),map.getCol());
                    leftRoom = true;
                }
                else if(choice.equalsIgnoreCase("R")){
                    map.enterRoom(map.getRow(),map.getCol()+1,map.getRow(),map.getCol());
                    leftRoom = true;
                }
                else if(choice.equalsIgnoreCase("potion"))
                {
                    if(player.getPotions()>0)
                    {
                        player.setPotions(-1);
                        player.changeHp(player.getHp()+5);
                        System.out.println("You drink the potion and feel better.");
                    }
                    else if(player.getPotions()<=0)
                    {
                        System.out.println("You don't have any potions!");
                    }
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
        Random gen = new Random();
        it = player.getItems();
        int whoAttacks = 2;
        int canRun = 0;
        boolean ran = false;
        int dmgDone = 0;
        int dmgTaken = 0;
        int strModifier = 0;
        int spdModifier = 0;
        int defModifier = 0;
        int HpModifier = 0;
        int battleSpd = 0;
        int battleHp = 0;
        isDead = false;

        if(difficulty.equalsIgnoreCase("easy"))
            player.changeHp(player.getMaxHp());

        //---------------FIGHTING----------------------

        Monster monster = new Monster(1);
        monster = spawnMob(monster);
        monster = monster.spawnMonster(monster);

        System.out.println("A "+monster.getName()+" appeared");

        System.out.println("Get Ready to Battle");

        for(int i = 0;i<it.length;i++){
            if(it[i]!=null){
                if(it[i].getSpd()>0){
                    spdModifier+=it[i].getSpd();
                }
            }
        }

        for(int i = 0;i<it.length;i++){
            if(it[i]!=null){
                if(it[i].getHp()>0){
                    HpModifier+=it[i].getHp();
                }
            }
        }

        battleSpd = player.getSpd()+spdModifier;
        battleHp = player.getHp()+HpModifier;

        do{
            if(battleSpd>monster.getSpeed()){
                if(isDead==false){
                    System.out.println("You are attacking!");
                    System.out.println("What do you want to do? (Attack, Run, Potion)");
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
                        if(dmgDone<=0)
                            dmgDone = 1;
                        dmgDone = dmgDone*-1;
                        monster.setHP(dmgDone);
                        if(monster.getHP()<0)
                            monster.setHPtoZero();
                        System.out.println("The monster has "+monster.getHP()+" health remaining.");
                        dmgDone=0;
                        if(monster.getHP()<=0)
                        {
                            System.out.println("You defeated the "+monster.getName()+"!");
                        }

                        if(monster.getHP()>0){
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
                            battleHp+=dmgTaken;
                            System.out.println("You have "+battleHp+" HP remaining");
                            dmgTaken = 0;
                            if(battleHp<=0){
                                System.out.println("You were defeated...");
                                isDead = true;
                            }
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
                    else if(choice.equalsIgnoreCase("potion"))
                    {
                        if(player.getPotions()>0)
                        {
                            player.setPotions(-1);
                            battleHp+=5;
                            System.out.println("You drink the potion and feel better.");
                            System.out.println("You have "+player.getPotions()+" potions remaining");
                        }
                        else if(player.getPotions()<=0)
                        {
                            System.out.println("You don't have any potions! You lost your turn while looking for them!");
                        }
                    }
                    else
                        System.out.println("Not a valid choice! You lose your turn!");
                }
            }
            else if(battleSpd<=monster.getSpeed()){
                if(monster.getHP()>0){
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
                    battleHp+=dmgTaken;
                    System.out.println("You have "+battleHp+" HP remaining");
                    dmgTaken = 0;
                    defModifier = 0;

                    if(battleHp<=0){
                        System.out.println("You were defeated...");
                        isDead=true;
                    }
                }
                if(isDead==false){
                    System.out.println("You are attacking!");
                    System.out.println("What do you want to do? (Attack, Run, Potion)");
                    choice = scan.nextLine();
                    if(choice.equalsIgnoreCase("Attack")){
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
                        if(dmgDone>1)
                            dmgDone = 1;
                        dmgDone = dmgDone*-1;
                        monster.setHP(dmgDone);
                        if(monster.getHP()<0)
                            monster.setHPtoZero();
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
                    else if(choice.equalsIgnoreCase("potion"))
                    {
                        if(player.getPotions()>0)
                        {
                            player.setPotions(-1);
                            battleHp+=5;
                            System.out.println("You drink the potion and feel better.");
                            System.out.println("You have "+player.getPotions()+" potions remaining");
                        }
                        else if(player.getPotions()<=0)
                        {
                            System.out.println("You don't have any potions! You lost your turn while looking for them!");
                        }
                    }
                    else
                        System.out.println("Not a valid choice! You lose your turn!");
                }
            }
        }while(battleHp>0&&monster.getHP()>0&&!ran);
        player.changeHp(battleHp);

        //-------------------------------------------TREASURE-----------------------------------------------
        int loot1=0;
        int loot2=0;
        int potions = 0;
        int equipSlot = 0;
        String equipItem = "";
        boolean isEmpty = true;
        boolean equipped = false;
        boolean done = false;
        int epicChance = 0;

        if(player.getHp()>0&&!ran){
            System.out.println("Press Enter to Continue");
            choice = scan.nextLine();
            System.out.println();
            System.out.println("You find a treasure chest in the back of the room.");
            epicChance = gen.nextInt(100)+1;
            if(epicChance == 72){
                System.out.println("You found the Blade of Andrew!");
                System.out.println(swordOfAndrew.getStats(swordOfAndrew));
                itemsFound.add(swordOfAndrew);
            }
            loot1 = gen.nextInt(35);
            do{
                loot2 = gen.nextInt(35);
            }while(loot1==loot2);
            potions = gen.nextInt(6);
            System.out.println("You found "+potions+" potion(s)!");
            System.out.println("You found a "+allItems.get(loot1).getStats(allItems.get(loot1)));
            System.out.println("You found a "+allItems.get(loot2).getStats(allItems.get(loot2)));
            player.setPotions(potions);
            itemsFound.add(allItems.get(loot1));
            itemsFound.add(allItems.get(loot2));
            loot1=0;
            loot2=0;
            System.out.println();
            System.out.println("Your current stats:");
            System.out.println("Battle Hp: "+battleHp);
            System.out.println("Attack Strength: "+(player.getStr()+strModifier));
            System.out.println("Defense: "+(player.getDef()+defModifier));
            System.out.println("Speed: "+battleSpd);
            System.out.println("Potions: "+player.getPotions());
            System.out.println();
            do{
                System.out.println("Would you like to equip any items? (Y/N)");
                choice=scan.nextLine();
                if(choice.equalsIgnoreCase("Y")){
                    System.out.println();
                    System.out.println("Your inventory: ");
                    for(int i = 0;i<it.length;i++)
                    {
                        if(it[i]!=null){
                            System.out.println("Slot "+(i+1)+": "+it[i].getName());
                        }
                        if(it[i]==null)
                            System.out.println("Slot "+(i+1)+": Empty");
                    } 
                    System.out.println();
                    System.out.println("Would you like to view an equipped item's stats? (Y/N)");
                    choice = scan.nextLine();
                    if(choice.equalsIgnoreCase("Y")){
                    do{
                        System.out.println("Enter the name of desired item");
                        choice = scan.nextLine();
                        for(int i = 0; i <it.length; i++){
                            if(it[i]!=null&&it[i].getName().equalsIgnoreCase(choice))
                                System.out.println(it[i].getStats(it[i]));
                        }
                        if(it[0]==null&&it[1]==null&&it[2]==null&&it[3]==null&&it[4]==null)
                            System.out.println("Error: No items in inventory!");
                        System.out.println("Would you like to see another item's stats? (Y/N)");
                        choice = scan.nextLine();
                        if(choice.equalsIgnoreCase("Y"))
                            System.out.println("Ready to check another item");
                        else if(choice.equalsIgnoreCase("N"))
                            done = true;
                        else
                            System.out.println("Not a valid choice. Defaulting to 'NO'"); done = true;
                    }while(!done);
                    done = false;
                    }
                    else if(choice.equalsIgnoreCase("N"))
                        System.out.println("Moving on then...");
                    else
                        System.out.println("Not a valid choice. Defaulting to 'NO'");
                        
                    choice = "Y";
                    try{
                        equipped = false;
                        System.out.println("Which spot would you like to equip an item in? (1-5)");
                        input.reset();
                        equipSlot = input.nextInt();
                        equipSlot = equipSlot - 1;

                        System.out.println("Which item do you want to equip?");
                        equipItem = scan.nextLine();
                        for(int i = 0; i < itemsFound.size(); i++){
                            if(i < it.length && i<itemsFound.size() && it[i]!=null && it[i].getName().equalsIgnoreCase(equipItem)){
                                System.out.println("You've already equipped that item!");
                                equipped = true;
                                break;
                            }
                            else if(i<itemsFound.size() && itemsFound.get(i).getName().equalsIgnoreCase(equipItem)){
                                it[equipSlot] = itemsFound.get(i);
                                System.out.println("Item successfully equipped");
                                equipped = true;
                                break;
                            }
                        }
                        if(!equipped){
                            System.out.println("You haven't found that item!");
                        }

                    }
                    catch(InputMismatchException e){
                        System.out.println("Error: Not an inventory slot.");
                        equipSlot = 0;
                        input.next();
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Error: Not able to equip item in requested spot.");
                        equipSlot = 0;
                        equipItem = "";
                        scan.next();
                        input.next();
                    }
                }
                else if(choice.equalsIgnoreCase("N")){
                    System.out.println("Moving on then...");
                }

            }while(!choice.equalsIgnoreCase("n"));

            System.out.println();
            System.out.println("Your inventory: ");

            for(int i = 0;i<it.length;i++)
            {
                if(it[i]!=null){
                    System.out.println("Slot "+(i+1)+": "+it[i].getName());
                    isEmpty = false;
                }
                if(it[i]==null){
                    System.out.println("Slot "+(i+1)+": Empty");
                }
            }
            if(isEmpty){
                    System.out.println("Your inventory is empty.");
            }
            System.out.println();

        }
    }

    public static void createAllItems()
    {   
        //Index goes from 0-34, 35 total Items

        Items woodSword = new Items(1,0,0,0,"A simple wooden sword","Wooden Sword");
        Items woodShield = new Items(0,0,1,0,"A flimsy wooden shield","Wooden Shield");
        Items bow = new Items(2,-1,-1,0,"A small recurve bow","Bow");
        Items chainmail = new Items(0,-1,3,2,"Sturdy Chainmail Armor","Chainmail Armor");
        Items ironSword = new Items(3,0,1,0,"A strong iron sword","Iron Sword");
        Items goodShield = new Items(0,0,3,2,"A sturdy iron kite shield","Iron Shield");
        Items staff = new Items(4,1,0,3,"A powerful magical staff","Magic Staff");
        Items goodStaff = new Items(5,2,1,2,"A very powerful magical staff","Powerful Staff");
        Items greatStaff = new Items(6,2,1,3,"An incredibly powerful magical relic","Staff of Destruction");
        Items magicShield = new Items(0,2,4,5,"A mysterious magical shield","Magic Shield");
        Items mace = new Items(4,-3,0,0,"A big spiked mace","Mace");
        Items chestplate = new Items(0,-1,4,5,"A hardened iron chestpiece","Iron Chestplate");
        Items longbow = new Items(5,-3,0,0,"A powerful longbow","Longbow");
        Items humanShield = new Items(0,-1,2,10,"Yeah, it's dark, but it's a human shield!","Human Shield");
        Items rocks = new Items(1,0,0,0,"They're rocks. What do you expect?","Rocks");
        Items speedBoots = new Items(0,5,0,0,"You don't know how, but they make you fast...","Boots of Speed");
        Items doomBow = new Items(10,-4,-4,0,"Lots of damage. But it comes with a price...","Doom Bow");
        Items heart = new Items(0,1,2,5,"A strange glowing heart-shaped locket","Heart Charm");
        Items masterSword = new Items(5,0,1,0,"Good thing Link was kind enough to 'lend' it to you...","The Master Sword");
        Items boneSword = new Items(3,0,0,0,"A sword made of...bones?","Bone Sword");
        Items spear = new Items(2,0,0,0,"A spear. All there is to it.","Spear");
        Items battleaxe = new Items(3,-2,0,0,"A mighty battleaxe","Battleaxe");
        Items mom = new Items(3,3,3,5,"Momma always makes you do better! <3 (Don't ask how she's in a chest...)","Mom");
        Items gun = new Items(5,-2,-2,0,"A gun?!?!","Gun");
        Items knives = new Items(3,-1,-1,0,"They're knives. You throw them. (Hopefully accurately...)","Throwing Knives");
        Items confetti = new Items(4,0,0,0,"For some reason a confetti popper seems to work wonders on monsters...","Confetti Popper");
        Items ductTape = new Items(2,0,0,0,"Have you ever had this stuff ripped off? It hurts!","Duct Tape");
        Items ductTapeArmor = new Items(0,-1,2,3,"Duct Tape fixes anything-including flesh wounds","Duct Tape Armor");
        Items truthSword = new Items(4,4,4,4,"This blade is said to fell any monster","The Blade of Truth");
        Items light = new Items(2,0,0,0,"THE LIGHT! IT BUUUUURRRRNNNNS!","The Light");
        Items stick = new Items(1,0,-1,0,"I suppose you could poke them to death","Stick");
        Items fireSpell = new Items(5,0,0,0,"Powerful fire magic","Fire Spell");
        Items healthSpell = new Items(0,0,2,10,"This magic makes you feel amazing!","Health Spell");
        Items imagination = new Items(0,0,0,0,"Just imagine you're hurting them!","Imagination");
        Items dog = new Items(3,0,1,2,"C'mere boy! C'mere! No! Over here!","Fido");
        
        
        
        allItems.add(woodSword);
        allItems.add(woodShield);
        allItems.add(bow);
        allItems.add(chainmail);
        allItems.add(ironSword);
        allItems.add(goodShield);
        allItems.add(staff);
        allItems.add(goodStaff);
        allItems.add(greatStaff);
        allItems.add(magicShield);
        allItems.add(mace);
        allItems.add(chestplate);
        allItems.add(longbow);
        allItems.add(humanShield);
        allItems.add(rocks);
        allItems.add(speedBoots);
        allItems.add(doomBow);
        allItems.add(heart);
        allItems.add(masterSword);
        allItems.add(boneSword);
        allItems.add(spear);
        allItems.add(battleaxe);
        allItems.add(mom);
        allItems.add(gun);
        allItems.add(knives);
        allItems.add(confetti);
        allItems.add(ductTape);
        allItems.add(ductTapeArmor);
        allItems.add(truthSword);
        allItems.add(light);
        allItems.add(stick);
        allItems.add(fireSpell);
        allItems.add(healthSpell);
        allItems.add(imagination);
        allItems.add(dog);
    }

    public static Monster spawnMob(Monster m){
        boolean hi = false;
        if((map.getRow()==0&&map.getCol()==1)||(map.getRow()==1&&map.getCol()==1)||(map.getRow()==1&&map.getCol()==0))
            m.setLvl(1);
        else if((map.getRow()==2&&map.getCol()==0)||(map.getRow()==2&&map.getCol()==1)||(map.getRow()==2&&map.getCol()==2)||(map.getRow()==1&&map.getCol()==2)||(map.getRow()==0&&map.getCol()==2))
            m.setLvl(2);
        else if((map.getRow()==3&&map.getCol()==0)||(map.getRow()==3&&map.getCol()==1)||(map.getRow()==3&&map.getCol()==2)||(map.getRow()==3&&map.getCol()==3)||(map.getRow()==2&&map.getCol()==3)||(map.getRow()==1&&map.getCol()==3)||(map.getRow()==0&&map.getCol()==3))
            m.setLvl(3);
        else if((map.getRow()==4&&map.getCol()==0)||(map.getRow()==4&&map.getCol()==1)||(map.getRow()==4&&map.getCol()==2)||(map.getRow()==4&&map.getCol()==3))
            m.setLvl(4);
        else if((map.getCol()==4&&map.getRow()==0)||(map.getCol()==4&&map.getRow()==1)||(map.getCol()==4&&map.getRow()==2)||(map.getCol()==4&&map.getRow()==3))
            m.setLvl(5);
        else if(map.getRow()==4 && map.getCol()==4)
            hi = true;

        return m;
    }

    public static void finalBoss(){
        Monster monster = new Monster();

        int whoAttacks = 2;
        int canRun = 0;
        boolean ran = false;
        int dmgDone = 0;
        int dmgTaken = 0;
        int strModifier = 0;
        int spdModifier = 0;
        int defModifier = 0;
        int HpModifier = 0;
        int battleSpd = 0;
        int battleHp = 0;

        System.out.println("You walk into a room lit only by torches.");
        System.out.println("Suddenly, the doorway you came through collapses.");
        System.out.println("\"Hello?\" you call out slightly shakily.");
        System.out.println("From a dark opening in the far wall, a hulking shadow appears.");
        if(it[0]!=null)
            System.out.println("Brandishing your "+it[0].getName()+", you step forward.");
        else
            System.out.println("You step forward bravely");
        System.out.println("\"Who awakens me?!\" a deep voice booms.");
        System.out.println("(Type your response)");
        choice = scan.nextLine();
        System.out.println("\"You call yourself "+choice+"?!\"");
        System.out.println("\"Very well, "+choice+".\"");
        System.out.println("He steps forward, revealing a huge humanoid figure, 10 feet tall, covered in scars and decorated with skulls.");
        System.out.println("\"I am Ralk the Beheader.\" he booms. \"All tremble before me.\"");
        System.out.println("\"Why have you awakened me?\"");
        System.out.println("(Type your response)");
        choice = scan.nextLine();
        System.out.println("\"HA HA HA HA!! None have ever accomplished that feat\"");
        System.out.println("\"You amuse me, mortal. However, you must die now.\"");
        System.out.println("");
        System.out.println("Ralk the Beheader appears!");

        System.out.println("Get Ready to Battle");

        if(difficulty.equalsIgnoreCase("easy"))
            player.changeHp(player.getMaxHp());

        for(int i = 0;i<it.length;i++){
            if(it[i]!=null){
                if(it[i].getSpd()>0){
                    spdModifier+=it[i].getSpd();
                }
            }
        }
        for(int i = 0;i<it.length;i++){
            if(it[i]!=null){
                if(it[i].getHp()>0){
                    HpModifier+=it[i].getHp();
                }
            }
        }
        battleSpd = player.getSpd()+spdModifier;
        battleHp = player.getHp()+HpModifier;

        do{
            if(battleSpd>monster.getSpeed()){
                if(!isDead){
                    System.out.println("You are attacking!");
                    System.out.println("What do you want to do? (Attack, Run, Potion)");
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
                        if(monster.getHP()<0)
                            monster.setHPtoZero();
                        System.out.println("Ralk the Beheader has "+monster.getHP()+" health remaining.");
                        dmgDone=0;
                        strModifier = 0;
                        if(monster.getHP()<=0)
                        {
                            System.out.println("You defeated "+monster.getName()+"!");
                        }

                        if(monster.getHP()>0){
                            System.out.println(monster.getName()+" attacks!");
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
                            battleHp+=dmgTaken;
                            System.out.println("You have "+battleHp+" HP remaining");
                            dmgTaken = 0;
                            defModifier = 0;
                            if(battleHp<=0)
                                System.out.println("You were defeated...");
                        }
                    }
                    else if(choice.equalsIgnoreCase("Run"))
                    {
                        System.out.println("There's nowhere to run!");
                    }
                    else if(choice.equalsIgnoreCase("potion"))
                    {
                        if(player.getPotions()>0)
                        {
                            player.setPotions(-1);
                            battleHp+=5;
                            System.out.println("You drink the potion and feel better.");
                        }
                        else if(player.getPotions()<=0)
                        {
                            System.out.println("You don't have any potions! You lost your turn while looking for them!");
                        }
                    }
                    else
                        System.out.println("Not a valid choice! You lose your turn!");
                }
            }
            else if(battleSpd<=monster.getSpeed()){
                if(monster.getHP()>0){
                    System.out.println(monster.getName()+" attacks!");
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
                    battleHp+=dmgTaken;
                    System.out.println("You have "+battleHp+" HP remaining");
                    dmgTaken = 0;
                    defModifier = 0;

                    if(battleHp<=0){
                        System.out.println("You were defeated...");
                        isDead=true;
                    }
                }
                if(!isDead){
                    System.out.println("You are attacking!");
                    System.out.println("What do you want to do? (Attack, Run, Potion)");
                    choice = scan.nextLine();
                    if(choice.equalsIgnoreCase("Attack")){
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
                        if(monster.getHP()<0)
                            monster.setHPtoZero();
                        System.out.println("Ralk the Beheader has "+monster.getHP()+" health remaining.");
                        dmgDone=0;
                        strModifier = 0;
                        if(monster.getHP()<=0)
                        {
                            System.out.println("You defeated "+monster.getName()+"!");
                        }
                    }
                    else if(choice.equalsIgnoreCase("Run"))
                    {
                        System.out.println("There's nowhere to run!");
                    }
                    else if(choice.equalsIgnoreCase("potion"))
                    {
                        if(player.getPotions()>0)
                        {
                            player.setPotions(-1);
                            battleHp+=5;
                            System.out.println("You drink the potion and feel better.");
                        }
                        else if(player.getPotions()<=0)
                        {
                            System.out.println("You don't have any potions! You lost your turn while looking for them!");
                        }
                    }
                    else
                        System.out.println("Not a valid choice! You lose your turn!");
                }
            }
        }while(battleHp>0&&monster.getHP()>0&&!ran);
        player.changeHp(battleHp);

        if(!isDead){
            System.out.println();
            System.out.println("After what seems like ages of battle, you finally plunge your weapon into the behemoth's heart.");
            System.out.println("Staggering backwards, he roars in pain, clutching at the weapon lodged in his massive chest.");
            System.out.println("\"How...how...What ARE you?!\"");
            System.out.println("(Type your response)");
            choice = scan.nextLine();
            System.out.println("\"You can't...possibly...be...\"");
            System.out.println("With that, he finally collapses, dead.");
            System.out.println("");
            System.out.println("A door opens in the back of the room as he hits the floor, letting in bright sunlight.");
            System.out.println("You walk through the doorway into another large room, lit by a hole in the ceiling with a ladder hanging from it.");
            System.out.println("Inside is a singular chest on a pedestal, nicer than any others in the rest of the cave.");
            System.out.println("Finally, you've found the treasure you fought so hard for.");
            System.out.println("You walk up to the chest and open the lid.");
            System.out.println("Press enter to continue.");
            choice = scan.nextLine();
            System.out.println("Inside");
            choice = scan.nextLine();
            System.out.println("You");
            choice = scan.nextLine();
            System.out.println("Find...");
            choice = scan.nextLine();
            System.out.println("4 Skittles.");
            choice = scan.nextLine();
            System.out.println("Not 5.");
            choice = scan.nextLine();
            System.out.println("Not 3.");
            choice = scan.nextLine();
            System.out.println("4. Skittles. (In surprisingly good condition)");
            System.out.println("");
            choice = scan.nextLine();
            System.out.println("Oh, and you find tons of gold and jewels!");
            System.out.println("And a bus pass to Morocco...");
            choice = scan.nextLine();
            System.out.println("");
            System.out.println("Stuffing your pockets full, as well as your bag, you finally set off again.");
            System.out.println("You climb the ladder, and finding yourself in a forest, once again look for a new adventure.");
            System.out.println("");
            System.out.println("Thank You For Playing!");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("CREDITS:");
            System.out.println("(Remember: Press Enter to Continue!)");
            System.out.println("");
            System.out.println("~~PROGRAMMING~~");
            choice = scan.nextLine();
            System.out.println(" ~~~Ryan Lake~~~");
            choice = scan.nextLine();
            System.out.println(" ~~~Griffin Holloway~~~");
            choice = scan.nextLine();
            System.out.println("");
            System.out.println("~~SPECIAL THANKS~~");
            choice = scan.nextLine();
            System.out.println(" ~~~Natalie Watts~~~");
            choice = scan.nextLine();
            System.out.println(" ~~~Craig Lake~~~");
            choice = scan.nextLine();
            System.out.println(" ~~~You, the Player!~~~");
            System.out.println();
            System.out.println("THE END");

        }

    }

    //-------------------------GAMEPLAY----------------------------------------------------

    public static void gameplay()
    {
        boolean atBoss = false;
        do{
            map.printMap();
            moveRooms();        
            executeRoom();
            if(map.getRow()==4&&map.getCol()==4)
                atBoss = true;
        }while(!isDead&&!atBoss);

        if(isDead){
            System.out.println("You have failed in your quest.");
            System.out.println("You Lose...");
        }
        if((!isDead)&&(map.getRow()==4&&map.getCol()==4)){
            System.out.println();
            System.out.println("Are you sure you want to face the Final Boss? (Y/N)");
            choice = scan.nextLine();
            if(choice.equalsIgnoreCase("y")){
                finalBoss();
            }
            else if(choice.equalsIgnoreCase("N")){
                System.out.println("Don't come back until you're ready!");
                map.enterRoom(4,3,4,4);
                gameplay();
            }
        }
    }
}

//To print items stats: System.out.println(allItems.get(IndexofdesiredItem)).getStats(allItems.get(IndexOfdesiredItem));

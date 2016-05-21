import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    static Scanner scan = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);
    static Player player;
    static Map map = new Map();
    static String choice;
    static Items[]it = new Items[5];
    static ArrayList<Items> allItems = new ArrayList<Items>();
    static ArrayList<Items> itemsFound = new ArrayList<Items>();

    static boolean isDead = false;

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
        
        //---------------FIGHTING----------------------

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
                    player.changeHp(dmgTaken);
                    System.out.println("You have "+player.getHp()+" HP remaining");
                    dmgTaken = 0;
                    defModifier = 0;
                    if(player.getHp()<=0)
                        System.out.println("You were defeated...");
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
                    
                 
            }
       else if(player.getSpd()<monster.getSpeed()){
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
                player.changeHp(dmgTaken);
                System.out.println("You have "+player.getHp()+" HP remaining");
                dmgTaken = 0;
                defModifier = 0;
                
                if(player.getHp()<=0){
                    System.out.println("You were defeated...");
                    isDead=true;
				}
			}
                System.out.println("You are attacking!");
                System.out.println("What do you want to do? (Attack, Run)");
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

			}
		}while(player.getHp()>0&&monster.getHP()>0&&!ran);
		
		
		//----------------TREASURE-----------------------------------------------
		int loot1=0;
		int loot2=0;
		int equipSlot = 0;
		String equipItem = "";
		boolean isEmpty = true;
		boolean equipped = false;
		
		if(player.getHp()>0){
			System.out.println();
			System.out.println("You find a treasure chest in the back of the room.");
			loot1 = gen.nextInt(25);
			do{
			loot2 = gen.nextInt(25);
			}while(loot1==loot2);
			System.out.println("You found a "+allItems.get(loot1).getStats(allItems.get(loot1)));
			System.out.println("You found a "+allItems.get(loot2).getStats(allItems.get(loot2)));
			itemsFound.add(allItems.get(loot1));
			itemsFound.add(allItems.get(loot2));
			loot1=0;
			loot2=0;
			do{
			System.out.println("Would you like to equip any items? (Y/N)");
			choice=scan.nextLine();
			if(choice.equalsIgnoreCase("Y")){
				System.out.println("Your inventory: ");
				for(int i = 0;i<it.length;i++)
				{
					if(it[i]!=null){
						System.out.print(it[i].getName()+", ");
						isEmpty = false;
					}
					if(isEmpty){
						System.out.println("Your inventory is empty.");
						break;
					}
					
				}	
				System.out.println();
				try{
					equipped = false;
				System.out.println("Which spot would you like to equip an item in? (1-5)");
				input.reset();
				equipSlot = input.nextInt();
				equipSlot -= 1;
				
				
				System.out.println("Which item do you want to equip?");
				equipItem = scan.nextLine();
				for(int i = 0; i < itemsFound.size(); i++){
					if(i<=it.length&&it[i]!=null&&it[i].getName().equalsIgnoreCase(equipItem)){
						System.out.println("You've already equipped that item!");
						equipped = true;
						}
					else if(itemsFound.get(i).getName().equalsIgnoreCase(equipItem)){
						it[equipSlot] = itemsFound.get(i);
						System.out.println("Item successfully equipped");
						equipped = true;
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
			}
			else if(choice.equalsIgnoreCase("N")){
				System.out.println("Moving on then...");
			}
			
		}while(!choice.equalsIgnoreCase("n"));
		
		for(int i = 0;i<it.length;i++)
				{
					if(it[i]!=null){
						System.out.print(it[i].getName()+", ");
						isEmpty = false;
					}
					if(isEmpty){
						System.out.println("Your inventory is empty.");
						break;
					}
					
				}
		
		}
	}
	
	public static void createAllItems()
	{	
		//Index goes from 0-24, 25 total Items
		
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
		Items gun = new Items(5,-2,-2,0,"A gun?!?!","Gun?!?!");
		Items knives = new Items(3,-1,-1,0,"They're knives. You throw them. (Hopefully accurately...)","Throwing Knives");
		
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
		}
}

//To print items stats: System.out.println(allItems.get(IndexofdesiredItem)).getStats(allItems.get(IndexOfdesiredItem));

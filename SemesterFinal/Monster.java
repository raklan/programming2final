import java.util.Random;
/**
 * Write a description of class Monster here.
 * 
 * @author (Griffin Holloway) 
 * @version (5/16/16)
 */
public class Monster
{
    private int monsters;
    private int kind;
    boolean niceHair;
    private String name;
    private int health;
    private int strength;
    private int speed;
    private int defense;
    public Monster(int m)
    {
        kind = m;
        health = 1;
        strength= 0;
        speed= 0;
        defense= 0;
        name = " ";

    }
    public Monster spawnMonster(Monster m)
    {
        niceHair=false;
        Random gen = new Random();
        monsters = gen.nextInt(2);

        do{

            if(kind==1)
            {
                do{
                    if(monsters==0)
                    {
                        health = 1;
                        strength =2 ;
                        defense = 1;
                        speed = 1;
                        name = "Spider";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=2;
                        strength = 1;
                        defense = 1;
                        speed = 1;
                        name="Scorpion";
                        niceHair=true;
                    } 
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==2)
            {
                do{
                    if(monsters==0)
                    {
                        health=3;
                        strength = 3;
                        defense = 2;
                        speed = 2;
                        name="Troll";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=4;
                        strength = 2;
                        defense = 3;
                        speed =1;
                        name="Giant";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==3)
            {
                do{
                    if(monsters==0)
                    {
                        health=5;
                        strength=5;
                        defense=2;
                        speed=3;
                        name="Skeleton Pirate";
                        niceHair=true;
                    }
                    if(monsters==1)
                    {
                        health=8;
                        strength=2;
                        defense=3;
                        speed=2;
                        name="Apperition";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==4)
            {
                do{

                    if(monsters==0)
                    {
                        health=10;
                        strength = 5;
                        defense = 2;
                        speed = 3;
                        name="Garrett";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=8;
                        strength = 7;
                        defense = 3;
                        speed = 1;
                        name="Orc";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==5)
            {
                do{

                    if(monsters==0)
                    {
                        health=13;
                        strength = 7;
                        defense = 8;
                        speed = 2;
                        name="Undead Foot Soldier";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=12;
                        strength = 8;
                        defense = 4;
                        speed = 6;
                        name="Hell GateKeeper";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
             else if(kind==6)
            {
                do{
                    if(monsters==0)
                    {
                        health=25;
                        strength = 5;
                        defense = 3;
                        speed = 2;
                        name="Vampire";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=22;
                        strength = 8;
                        defense = 3;
                        speed =2;
                        name="Werewolf";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==7)
            {
                do{
                    if(monsters==0)
                    {
                        health=30;
                        strength=5;
                        defense=2;
                        speed=3;
                        name="Golem";
                        niceHair=true;
                    }
                    if(monsters==1)
                    {
                        health=25;
                        strength=7;
                        defense=6;
                        speed=2;
                        name="Cave Person";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==8)
            {
                do{

                    if(monsters==0)
                    {
                        health=32;
                        strength = 5;
                        defense = 5;
                        speed = 3;
                        name="Blake";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=27;
                        strength = 7;
                        defense = 6;
                        speed = 5;
                        name="Grey Wolf";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==9)
            {
                do{

                    if(monsters==0)
                    {
                        health=32;
                        strength = 8;
                        defense = 5;
                        speed = 5;
                        name="Undead Foot Soldier";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=28;
                        strength = 9;
                        defense = 8;
                        speed = 5;
                        name="Hell GateKeeper";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==10)
            {
                do{
                    if(monsters==0)
                    {
                        health = 1;
                        strength =2 ;
                        defense = 1;
                        speed = 1;
                        name = "Spider";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=2;
                        strength = 1;
                        defense = 1;
                        speed = 1;
                        name="Scorpion";
                        niceHair=true;
                    } 
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==11)
            {
                do{
                    if(monsters==0)
                    {
                        health=3;
                        strength = 3;
                        defense = 2;
                        speed = 2;
                        name="Troll";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=4;
                        strength = 2;
                        defense = 3;
                        speed =1;
                        name="Giant";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==12)
            {
                do{
                    if(monsters==0)
                    {
                        health=5;
                        strength=5;
                        defense=2;
                        speed=3;
                        name="Skeleton Pirate";
                        niceHair=true;
                    }
                    if(monsters==1)
                    {
                        health=8;
                        strength=2;
                        defense=3;
                        speed=2;
                        name="Apperition";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==13)
            {
                do{

                    if(monsters==0)
                    {
                        health=10;
                        strength = 5;
                        defense = 2;
                        speed = 3;
                        name="Garrett";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=8;
                        strength = 7;
                        defense = 3;
                        speed = 1;
                        name="Orc";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==14)
            {
                do{

                    if(monsters==0)
                    {
                        health=13;
                        strength = 7;
                        defense = 8;
                        speed = 2;
                        name="Undead Foot Soldier";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=12;
                        strength = 8;
                        defense = 4;
                        speed = 6;
                        name="Hell GateKeeper";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
             else if(kind==15)
            {
                do{
                    if(monsters==0)
                    {
                        health=25;
                        strength = 5;
                        defense = 3;
                        speed = 2;
                        name="Vampire";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=22;
                        strength = 8;
                        defense = 3;
                        speed =2;
                        name="Werewolf";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==16)
            {
                do{
                    if(monsters==0)
                    {
                        health=30;
                        strength=5;
                        defense=2;
                        speed=3;
                        name="Golem";
                        niceHair=true;
                    }
                    if(monsters==1)
                    {
                        health=25;
                        strength=7;
                        defense=6;
                        speed=2;
                        name="Cave Person";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==17)
            {
                do{

                    if(monsters==0)
                    {
                        health=32;
                        strength = 5;
                        defense = 5;
                        speed = 3;
                        name="Blake";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=27;
                        strength = 7;
                        defense = 6;
                        speed = 5;
                        name="Grey Wolf";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
            else if(kind==18)
            {
                do{

                    if(monsters==0)
                    {
                        health=32;
                        strength = 8;
                        defense = 5;
                        speed = 5;
                        name="Undead Foot Soldier";
                        niceHair=true;
                    }
                    else if(monsters==1)
                    {
                        health=28;
                        strength = 9;
                        defense = 8;
                        speed = 5;
                        name="Hell GateKeeper";
                        niceHair=true;
                    }
                    else
                        System.out.println("Error: Not a Valid Monster");
                }while(!niceHair);
            }
        }while(!niceHair);
        return m;
    }
    public void setHP(int h)
    {
        health+=h;
    }
    public int getHP()
    {
        return health;
    }
    public int getStr()
    {
        return strength;
    }
     public int getSpeed()
    {
        return speed;
    }
     public int getDef()
    {
        return defense;
    }
    public String getName()
    {
        return name;
    }
}

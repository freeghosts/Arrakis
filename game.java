import java.util.*;

/* Jansi library required as a dependency if using Windows 10, version 1903 or older.
   Download here: https://fusesource.github.io/jansi/download.html */

//import org.fusesource.jansi.AnsiConsole; 

public class game
{
	static final String ClearScreen = "\u001B[2J";

	// colour variables
	static final String RESET = "\u001B[0m";
	static final String BLUE = "\u001B[34;1m";
	static final String CYAN = "\u001B[36;1m";
	static final String GREEN = "\u001B[32;1m";
	static final String DrkGREY = "\u001B[1;30m";
	static final String MAGENTA = "\u001B[35;1m";
	static final String RED = "\u001B[31;1m";
	static final String WHITE = "\u001B[37;1m";
	static final String YELLOW = "\u001B[1;33m";
	static final String BLACKonBLACK = "\u001B[30;40m";
	static final String CYANonCYAN = "\u001B[36;46m";
	static final String REDonRED = "\u001B[31;41m";
	static final String YELLOWonRED = "\u001B[33;41m";

	public static void main (String[] args)
	{
		//AnsiConsole.systemInstall();

		Scanner in = new Scanner(System.in);
		String Choice1 = "";
		String Choice2 = "";
		String Choice3 = "";
		String PlayAgain = "";

		System.out.println(WHITE+"Backstory");
		System.out.println("-------------");
		System.out.println("You are a native Fremen(F) on the desert planet Arrakis. Following the death of");
		System.out.println("the planetologist, Liet-Kynes, you were sent to the southern hemisphere in");
		System.out.println("order to carry on his terraforming experiments. Finished for now, you begin the");
		System.out.println("trek home to Sietch Tabr only to discover that the way is blocked by enemy");
		System.out.println("soldiers from House Harkonnen("+BLUE+"H"+WHITE+"), Liet's brutal killers. You also spot some");
		System.out.println("Imperial Sardaukar("+DrkGREY+"S"+WHITE+"), said to be the fiercest fighters in the universe due to");
		System.out.println("their training on the inhospitable prison world, Salus Secondus. It would be");
		System.out.println("disastrous to your people should the Padishah Emperor learn of your mission to");
		System.out.println("restore Arrakis to a planet rife with water and vegetation. The harsh desert");
		System.out.println("clime plays a key role in the production of melange, the spice upon which much");
		System.out.println("wealth & power, not to mention all interstellar travel, relies. As such, you");
		System.out.println("must destroy any soldiers you meet on your journey. Good luck!");
		System.out.println();
		System.out.println("Continue?  y/n");
		Choice1 = in.nextLine();

		if(Choice1.equals("y") || Choice1.equals("Y"))
		{
			System.out.println(ClearScreen);
			Move(1,1);
			System.out.println("You may come upon various items as you travel, which could help or hinder");
			System.out.println("your journey home. The following key should assist you in deciding which");
			System.out.println("items are worth picking up. And one last thing, as always...\n" + RED + "BE WARY OF SANDWORMS (" + YELLOW + "W" + RED + ")!");
			System.out.println();
			System.out.println(MAGENTA);
			System.out.println("Item	   Symbol  Function");
			System.out.println("--------------------------------------------------");
			System.out.println("thumper	     +	   distract sandworms");
			System.out.println("maker hooks  ?	   ride sandworms");
			System.out.println("water	     ~	   hydration");
			System.out.println("crysknife    !	   Fremen weapon");
			System.out.println("spice	     *	   improve agility");
			System.out.println("atomics      @     illegal to use against humans, but kills an entire worm");
			System.out.println("shield belt  =     effective armor, but sends worms into killing frenzy");
			System.out.println();
			System.out.println(WHITE);
			System.out.println("Continue?  y/n");
			Choice2 = in.nextLine();

			if(Choice2.equals("y") || Choice2.equals("Y"))
			{
				System.out.println(ClearScreen);
				Move(1,1);
				do{
					// creating player initializes World
					Player Fremen = new Player("Fremen",'F',2,2);

					// create an ArrayList of enemies then add some in semi-random locations
					ArrayList<Enemy> Enemies = new ArrayList<Enemy>();

					// add Harkonnen
					int b = (int)(Math.random()*15)+3;
					while (Fremen.World[20][b]!=' ' || Fremen.World[20+1][b]!=' ' || Fremen.World[20][b+1]!=' ' || Fremen.World[20+1][b+1]!=' ')
					{
						b = (int)(Math.random()*15)+3;
					}
					Enemies.add(new Enemy("Harkonnen",20,b));

					b = (int)(Math.random()*15)+3;
					while (Fremen.World[20][b]!=' ' || Fremen.World[20+1][b]!=' ' || Fremen.World[20][b+1]!=' ' || Fremen.World[20+1][b+1]!=' ')
					{
						b = (int)(Math.random()*15)+3;
					}
					Enemies.add(new Enemy("Harkonnen",20,b));

					// add Sarkaukar
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[30][b]!=' ' || Fremen.World[30+1][b]!=' ' || Fremen.World[30][b+1]!=' ' || Fremen.World[30+1][b+1]!=' ')
					{
						b = (int)(Math.random()*15)+3;
					}
					Enemies.add(new Enemy("Sardaukar",30,b));

					b = (int)(Math.random()*15)+3;
					while (Fremen.World[30][b]!=' ' || Fremen.World[30+1][b]!=' ' || Fremen.World[30][b+1]!=' ' || Fremen.World[30+1][b+1]!=' ')
					{
						b = (int)(Math.random()*15)+3;
					}
					Enemies.add(new Enemy("Sardaukar",30,b));

					// add Sandworms
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[38][b]!=' ' || Fremen.World[38+1][b]!=' ' || Fremen.World[38][b+1]!=' ' || Fremen.World[38+1][b+1]!=' ')
					{
						b = (int)(Math.random()*15)+3;
					}
					Enemies.add(new Enemy("Sandworm",38,b));

					b = (int)(Math.random()*15)+3;
					while (Fremen.World[38][b]!=' ' || Fremen.World[38+1][b]!=' ' || Fremen.World[38][b+1]!=' ' || Fremen.World[38+1][b+1]!=' ')
					{
						b = (int)(Math.random()*15)+3;
					}
					Enemies.add(new Enemy("Sandworm",38,b));

					// draw a gaggle of Harkonnen('H') soldiers at a semi-random location
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[20][b]!=' ' || Fremen.World[20+1][b]!=' ' || Fremen.World[20][b+1]!=' ' || Fremen.World[20+1][b+1]!=' ')
					{
						b = (int)(Math.random()*15)+3;
					}
					Enemies.add(new Enemy("Harkonnen",20,b));
					Enemies.add(new Enemy("Harkonnen",20+1,b));
					Enemies.add(new Enemy("Harkonnen",20,b+1));
					Enemies.add(new Enemy("Harkonnen",20+1,b+1));

					// create an ArrayList of items then add some in random locations
					ArrayList<Item> Items = new ArrayList<Item>();

					int a = (int)(Math.random()*35)+4;
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[a][b]!=' ' || Fremen.World[a+1][b]!=' ' || Fremen.World[a][b+1]!=' ' || Fremen.World[a+1][b+1]!=' ')
					{
						a = (int)(Math.random()*35)+4;
						b = (int)(Math.random()*15)+3;
					}
					Items.add(new Item("thumper",a,b));

					a = (int)(Math.random()*35)+4;
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[a][b]!=' ' || Fremen.World[a+1][b]!=' ' || Fremen.World[a][b+1]!=' ' || Fremen.World[a+1][b+1]!=' ')
					{
						a = (int)(Math.random()*35)+4;
						b = (int)(Math.random()*15)+3;
					}
					Items.add(new Item("maker hooks",a,b));

					a = (int)(Math.random()*35)+4;
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[a][b]!=' ' || Fremen.World[a+1][b]!=' ' || Fremen.World[a][b+1]!=' ' || Fremen.World[a+1][b+1]!=' ')
					{
						a = (int)(Math.random()*35)+4;
						b = (int)(Math.random()*15)+3;
					}
					Items.add(new Item("water",a,b));

					a = (int)(Math.random()*35)+4;
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[a][b]!=' ' || Fremen.World[a+1][b]!=' ' || Fremen.World[a][b+1]!=' ' || Fremen.World[a+1][b+1]!=' ')
					{
						a = (int)(Math.random()*35)+4;
						b = (int)(Math.random()*15)+3;
					}
					Items.add(new Item("crysknife",a,b));

					a = (int)(Math.random()*35)+4;
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[a][b]!=' ' || Fremen.World[a+1][b]!=' ' || Fremen.World[a][b+1]!=' ' || Fremen.World[a+1][b+1]!=' ')
					{
						a = (int)(Math.random()*35)+4;
						b = (int)(Math.random()*15)+3;
					}
					Items.add(new Item("spice",a,b));

					a = (int)(Math.random()*35)+4;
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[a][b]!=' ' || Fremen.World[a+1][b]!=' ' || Fremen.World[a][b+1]!=' ' || Fremen.World[a+1][b+1]!=' ')
					{
						a = (int)(Math.random()*35)+4;
						b = (int)(Math.random()*15)+3;
					}
					Items.add(new Item("shield belt",a,b));

					a = (int)(Math.random()*35)+4;
					b = (int)(Math.random()*15)+3;
					while (Fremen.World[a][b]!=' ' || Fremen.World[a+1][b]!=' ' || Fremen.World[a][b+1]!=' ' || Fremen.World[a+1][b+1]!=' ')
					{
						a = (int)(Math.random()*35)+4;
						b = (int)(Math.random()*15)+3;
					}
					Items.add(new Item("atomics",a,b));

					// main while loop (i.e. play game)
					while (!Choice3.equals("q") && Fremen.HP >= 0 && !(Fremen.Xpos >= 38 && Fremen.Ypos >= 17))
					{
						Fremen.PrintWorld();
						System.out.println(WHITE + "a = Left | d = Right | w = Up | s = Down | f = Up Right | v = Down Right\ne = Up Left | c = Down Left | q = Quit");
						System.out.println();
						if (Fremen.HP <= 20)
						{
							System.out.print("Enter your command:                    " + RED + "HP: " + Fremen.HP + GREEN + " Attack: " + Fremen.Attack + " Defense: " + Fremen.Defense + " Speed: " + Fremen.Speed + WHITE ); Move(21,24);
							Choice3 = in.nextLine();
						}
						else
						{
							System.out.print("Enter your command:                    " + GREEN + "HP: " + Fremen.HP + " Attack: " + Fremen.Attack + " Defense: " + Fremen.Defense + " Speed: " + Fremen.Speed + WHITE ); Move(21,24);
							Choice3 = in.nextLine();
						}

						if (Choice3.equals("a"))
							Fremen.MoveLeft();
						else if (Choice3.equals("d"))
							Fremen.MoveRight();
						else if (Choice3.equals("w"))
							Fremen.MoveUp();
						else if (Choice3.equals("s"))
							Fremen.MoveDown();
						else if (Choice3.equals("f"))
							Fremen.MoveUpRight();
						else if (Choice3.equals("v"))
							Fremen.MoveDownRight();
						else if (Choice3.equals("e"))
							Fremen.MoveUpLeft();
						else if (Choice3.equals("c"))
							Fremen.MoveDownLeft();

						// Step through Enemy ArrayList and attack if adjacent to player
						for (int i=0; i<Enemies.size(); i++)
						{
							if ((Enemies.get(i).Ypos == Fremen.Ypos && (Enemies.get(i).Xpos == Fremen.Xpos+1)) || // player is to the left
							(Enemies.get(i).Ypos == Fremen.Ypos && (Enemies.get(i).Xpos == Fremen.Xpos-1)) ||    // player is to the right
							(Enemies.get(i).Xpos == Fremen.Xpos && (Enemies.get(i).Ypos == Fremen.Ypos+1)) ||    // player is above
							(Enemies.get(i).Xpos == Fremen.Xpos && (Enemies.get(i).Ypos == Fremen.Ypos-1)) ||    // player is below
							(Enemies.get(i).Ypos == Fremen.Ypos+1 && (Enemies.get(i).Xpos == Fremen.Xpos+1)) || // player is to upper left
							(Enemies.get(i).Ypos == Fremen.Ypos-1 && (Enemies.get(i).Xpos == Fremen.Xpos+1)) || // player is to lower left
							(Enemies.get(i).Ypos == Fremen.Ypos+1 && (Enemies.get(i).Xpos == Fremen.Xpos-1)) || // player is to upper right
							(Enemies.get(i).Ypos == Fremen.Ypos-1 && (Enemies.get(i).Xpos == Fremen.Xpos-1)))   // player is to lower right
							{
								Enemies.get(i).HP -= Fremen.Attack + ((int) (Math.random() * Enemies.get(i).Defense) + 1); // Player attacks Enemy
								Fremen.HP -= ((int) (Math.random() * Enemies.get(i).Attack) + 1) + Fremen.Defense; // Enemy attacks Player
								if (Enemies.get(i).HP <= 0)    // Enemy dies
								{
									Fremen.World[Enemies.get(i).Xpos][Enemies.get(i).Ypos] = ' ';
									Enemies.remove(i);
								}
							}
						}

						// Step through Item ArrayList to pick up, use, & remove items as player approaches them
						for (int i=0; i<Items.size(); i++)
						{
							if ((Items.get(i).Ypos == Fremen.Ypos && (Items.get(i).Xpos == Fremen.Xpos+1)) || // player is to the left
							(Items.get(i).Ypos == Fremen.Ypos && (Items.get(i).Xpos == Fremen.Xpos-1)) ||   // player is to the right
							(Items.get(i).Xpos == Fremen.Xpos && (Items.get(i).Ypos == Fremen.Ypos+1)) ||   // player is above
							(Items.get(i).Xpos == Fremen.Xpos && (Items.get(i).Ypos == Fremen.Ypos-1)) ||   // player is below
							(Items.get(i).Ypos == Fremen.Ypos+1 && (Items.get(i).Xpos == Fremen.Xpos+1)) || // player is to upper left
							(Items.get(i).Ypos == Fremen.Ypos-1 && (Items.get(i).Xpos == Fremen.Xpos+1)) || // player is to lower left
							(Items.get(i).Ypos == Fremen.Ypos+1 && (Items.get(i).Xpos == Fremen.Xpos-1)) || // player is to upper right
							(Items.get(i).Ypos == Fremen.Ypos-1 && (Items.get(i).Xpos == Fremen.Xpos-1)))   // player is to lower right

							{
								Fremen.World[Items.get(i).Xpos][Items.get(i).Ypos] = ' ';

								if (Items.get(i).Name.equals("thumper"))
									Fremen.Defense += Items.get(i).Value;
								else if (Items.get(i).Name.equals("maker hooks"))
									Fremen.Speed += Items.get(i).Value;
								else if (Items.get(i).Name.equals("water"))
									Fremen.HP += Items.get(i).Value;
								else if (Items.get(i).Name.equals("crysknife"))
									Fremen.Attack += Items.get(i).Value;
								else if (Items.get(i).Name.equals("shield belt"))
									Fremen.Defense -= Items.get(i).Value;
								else if (Items.get(i).Name.equals("atomics"))
									Fremen.Attack -= Items.get(i).Value;
								else if (Items.get(i).Name.equals("spice"))
								{
									Fremen.HP += Items.get(i).Value + 3;
									Fremen.Attack += Items.get(i).Value;
									Fremen.Defense += Items.get(i).Value;
								}
								Items.remove(i);
							}
						}

						// Step through Enemy ArrayList and move towards the player
						for (int i=0; i<Enemies.size(); i++)
						{
							if (Enemies.get(i).Xpos > Fremen.Xpos)
								Enemies.get(i).MoveLeft();
							else
								Enemies.get(i).MoveRight();
							if (Enemies.get(i).Ypos > Fremen.Ypos)
								Enemies.get(i).MoveUp();
							else
								Enemies.get(i).MoveDown();
						}
					}

					if (Fremen.HP <= 0)    // player dies
					{
						System.out.print(ClearScreen);
						Fremen.PrintWorld();
						Move(1,5);
						System.out.println(WHITE + "	HP: " + Fremen.HP);
						System.out.println(CYAN);
						System.out.println(" _______  _______  __   __  _______    _______  __   __  _______  ______");
						System.out.println("|       ||   _   ||  |_|  ||       |  |       ||  | |  ||       ||    _ |");
						System.out.println("|    ___||  |_|  ||       ||    ___|  |   _   ||  |_|  ||    ___||   | ||");
						System.out.println("|   | __ |       ||       ||   |___   |  | |  ||       ||   |___ |   |_||_");
						System.out.println("|   ||  ||       ||       ||    ___|  |  |_|  ||       ||    ___||    __  |");
						System.out.println("|   |_| ||   _   || ||_|| ||   |___   |       | |     | |   |___ |   |  | |");
						System.out.println("|_______||__| |__||_|   |_||_______|  |_______|  |___|  |_______||___|  |_|");
						System.out.println();
						Move(4,17);
						System.out.println(WHITE + "Would you like to play again?  y/n"); Move(4,18);
						PlayAgain = in.nextLine();
					}

					if (Fremen.Xpos >= 38 && Fremen.Ypos >= 17)  // player wins
					{
						System.out.println(ClearScreen);
						Fremen.PrintWorld();
						System.out.println();
						System.out.println(GREEN + "Congratulations! You made it to Sietch Tabr!");
						System.out.println();
						System.out.println("Would you like to play again?  y/n");
						PlayAgain = in.nextLine();
					}

					System.out.println(ClearScreen);
					Move(4,3);
					System.out.println("So long, and thanks for all the fish!");
					System.out.println();

				}while(PlayAgain.equals("y") || PlayAgain.equals("Y"));
			}
			else
			{
				System.out.println(ClearScreen);
				Move(1,1);
				System.out.println("So long, and thanks for all the fish!");
				System.out.println();
			}
		}
		else
		{
			System.out.println(ClearScreen);
			Move(1,1);
			System.out.println("So long, and thanks for all the fish!");
			System.out.println();
		}
	}

	static void Move (int x, int y)
	{
		System.out.print("\u001b["+y+";"+x+"H");
	}
}

class GameObject   // superclass
{
	static char World[][] = new char[41][21];
	int Xpos, Ypos;
	char Avatar;
	static final String ClearScreen = "\u001B[2J";

	// colour variables
	static final String RESET = "\u001B[0m";
	static final String BLUE = "\u001B[34;1m";
	static final String CYAN = "\u001B[36;1m";
	static final String GREEN = "\u001B[32;1m";
	static final String DrkGREY = "\u001B[1;30m";
	static final String MAGENTA = "\u001B[35;1m";
	static final String RED = "\u001B[31;1m";
	static final String WHITE = "\u001B[37;1m";
	static final String YELLOW = "\u001B[1;33m";
	static final String BLACKonBLACK = "\u001B[30;40m";
	static final String CYANonCYAN = "\u001B[36;46m";
	static final String REDonRED = "\u001B[31;41m";
	static final String YELLOWonRED = "\u001B[33;41m";

	void PrintWorld()
	{
		System.out.print(ClearScreen);
		Move(1,1);

		for (int y=1; y<=20; y++)
		{
			for (int x=1; x<=40; x++)
	   		{
				if(World[x][y] == '^') // dunes
					System.out.print(YELLOWonRED);
				else if(World[x][y] == '*') // plants (terraforming experimentation site)
					System.out.print(GREEN);
				else if(World[x][y] == 'H') // Harkonnen
					System.out.print(BLUE);
				else if(World[x][y] == 'S') // Sardaukar
					System.out.print(DrkGREY);
				else if(World[x][y] == 'W') // Sandworm
					System.out.print(YELLOW);
				else if(World[x][y] == '+') // thumper
					System.out.print(MAGENTA);
				else if(World[x][y] == '?') // maker hooks
					System.out.print(MAGENTA);
				else if(World[x][y] == '~') // water
					System.out.print(MAGENTA);
				else if(World[x][y] == '!') // crysknife
					System.out.print(MAGENTA);
				else if(World[x][y] == '=') // shield belt
					System.out.print(MAGENTA);
				else if(World[x][y] == '@') // atomics
					System.out.print(MAGENTA);
				else if(World[x][y] == '$') // spice
					System.out.print(MAGENTA);
				else if(World[x][y] == '#') // hiding place
					System.out.print(REDonRED);
				else if(World[x][y] == '%') // passageway
					System.out.print(BLACKonBLACK);
				else if(World[x][y] == '&') // Sietch Tabr
					System.out.print(CYANonCYAN);
				else
					System.out.print(WHITE);

		  		System.out.print(World[x][y]);
				if (x < 40)
			 		System.out.print(" ");
			 	System.out.print(RESET);
	   		}
			System.out.println();
		}
	}

	void Move (int x, int y)
	{
		System.out.print("\u001b["+y+";"+x+"H");
	}
}

class Enemy extends GameObject   // subclass
{
	String Race;
	int HP, Attack, Defense;

	Enemy(String NewRace, int NewXpos, int NewYpos) // constructor
	{
		Race = NewRace; Xpos = NewXpos; Ypos = NewYpos;

		if (Race.equals("Harkonnen")) // blue
		{
			Avatar = 'H'; HP = 10; Attack = 1; Defense = 2;
		}
		if (Race.equals("Sardaukar")) // grey
		{
			Avatar = 'S'; HP = 20; Attack = 2; Defense = 2;
		}
		if (Race.equals("Sandworm")) // yellow
		{
			Avatar = 'W'; HP = 30; Attack = 4; Defense = 3;
		}

		World[Xpos][Ypos] = Avatar;
	}

	void MoveRight()
	{
		if (World[Xpos+1][Ypos] == ' ')
		{
			World[Xpos][Ypos] = ' ';
			Xpos++;
			World[Xpos][Ypos] = Avatar;
		}
	}
	void MoveLeft()
	{
		if (World[Xpos-1][Ypos] == ' ')
		{
			World[Xpos][Ypos] = ' ';
			Xpos--;
			World[Xpos][Ypos] = Avatar;
		}
	}
	void MoveUp()
	{
		if (World[Xpos][Ypos-1] == ' ')
		{
			World[Xpos][Ypos] = ' ';
			Ypos--;
			World[Xpos][Ypos] = Avatar;
		}
	}
	void MoveDown()
	{
		if (World[Xpos][Ypos+1] == ' ')
		{
			World[Xpos][Ypos] = ' ';
			Ypos++;
			World[Xpos][Ypos] = Avatar;
		}
	}
}

class Player extends GameObject   // subclass
{
	String Name;
	int HP, Attack, Defense, Speed;

	Player(String NewName, char NewAvatar, int NewXpos, int NewYpos) // constructor
	{
		Name = NewName; Avatar = NewAvatar; Xpos = NewXpos; Ypos = NewYpos;
		HP = 100; Attack = 5; Defense = 5; Speed = 1;

		// set entire world to spaces
		for (int x=1; x<=40; x++)
		{
		   for (int y=1; y<=20; y++)
			  World[x][y] = ' ';
		}
		// line perimeter of world with dunes(^)
		for (int x=1; x<=40; x++)
		{
			World[x][1] = '^';  World[x][20] = '^';
		}
		for (int y=1; y<=20; y++)
		{
			World[1][y] = '^';  World[40][y] = '^';
		}

		// draw clusters of dunes(^)
		World[26][4] = '^';
		World[25][5] = '^'; World[26][5] = '^'; World[27][5] = '^';
		World[25][6] = '^'; World[27][6] = '^';

		World[9][12] = '^'; World[10][12] = '^';
		World[8][13] = '^'; World[9][13] = '^'; World[10][13] = '^';
		World[7][14] = '^'; World[8][14] = '^'; World[9][14] = '^'; World[10][14] = '^';
		World[6][15] = '^'; World[7][15] = '^'; World[8][15] = '^'; World[9][15] = '^'; World[10][15] = '^';

		// more dunes!
		for (int x=18; x<=37; x++)
		{
			World[x][19] = '^';
		}
		for (int x=20; x<=36; x++)
		{
			World[x][18] = '^';
		}
		for (int x=22; x<=25; x++)
		{
			World[x][17] = '^';
		}
		for (int x=21; x<=25; x++)
		{
			World[x][16] = '^';
		}
		for (int x=22; x<=24; x++)
		{
			World[x][15] = '^';
		}
		for (int x=28; x<=35; x++)
		{
			World[x][17] = '^';
		}
		for (int x=29; x<=34; x++)
		{
			World[x][16] = '^';
		}
		for (int x=30; x<=33; x++)
		{
			World[x][15] = '^';
		}
		for (int x=31; x<=32; x++)
		{
			World[x][14] = '^';
		}

		// plants (aka terraforming experimentation site)
		for (int x=3; x<=5; x++)
		{
			World[x][2] = '*';
		}
		World[4][3] = '*';
		World[2][3] = '*';
		for (int x=2; x<=3; x++)
		{
			World[x][4] = '*';
		}
		World[2][5] = '*';

		// hiding places
		World[26][6] = '#';
		World[26][7] = '%';
		World[21][17] = '#';
		World[20][17] = '%';
		World[7][14] = '#';
		World[7][13] = '%';
		World[6][14] = '%';

		// passageways
		World[6][2] = '%';
		World[3][3] = '%';
		for (int x=5; x<=6; x++)
		{
			World[x][3] = '%';
		}
		for (int x=4; x<=6; x++)
		{
			World[x][4] = '%';
		}
		for (int x=3; x<=6; x++)
		{
			World[x][5] = '%';
		}
		for (int x=2; x<=6; x++)
		{
			World[x][6] = '%';
		}

		// Sietch Tabr
		for (int y=9; y<=18; y++)
		{
			World[39][y] = '^';
		}
		for (int y=10; y<=13; y++)
		{
			World[38][y] = '^';
		}
		for (int y=10; y<=12; y++)
		{
			World[37][y] =  '^';
		}
		for (int y=11; y<=12; y++)
		{
			World[36][y] = '^';
		}
		for (int x=38; x<=39; x++)
		{
			World[x][19] = '&';
		}
		for (int x=37; x<=39; x++)
		{
			World[x][18] = '&';
		}
		for (int x=36; x<=38; x++)
		{
			World[x][17] = '&';
		}

		World[Xpos][Ypos] = Avatar;
	}

	void MoveRight()
	{
		if (World[Xpos+1][Ypos] == ' ' || World[Xpos+1][Ypos] == '#' || World[Xpos+1][Ypos] == '%' || World[Xpos+1][Ypos] == '&')
		{
		   	World[Xpos][Ypos] = ' ';
		   	Xpos = Xpos + Speed;
		   	World[Xpos][Ypos] = Avatar;
		   	HP++;
		}
	}
	void MoveUpRight()
	{
		if (World[Xpos+1][Ypos-1] == ' ' || World[Xpos+1][Ypos-1] == '#' || World[Xpos+1][Ypos-1] == '%' || World[Xpos+1][Ypos-1] == '&')
		{
			if(World[Xpos+1][Ypos] == '!')
				HP += 20;
		   World[Xpos][Ypos] = ' ';
		   Xpos = Xpos + Speed;
		   Ypos = Ypos - Speed;
		   World[Xpos][Ypos] = Avatar;
		   HP++;
		}
	}
	void MoveDownRight()
	{
		if (World[Xpos+1][Ypos+1] == ' ' || World[Xpos+1][Ypos+1] == '#' || World[Xpos+1][Ypos+1] == '%' || World[Xpos+1][Ypos+1] == '&')
		{
		   World[Xpos][Ypos] = ' ';
		   Xpos = Xpos + Speed;
		   Ypos = Ypos + Speed;
		   World[Xpos][Ypos] = Avatar;
		   HP++;
		}
	}
	void MoveLeft()
	{
		if (World[Xpos-1][Ypos] == ' ' || World[Xpos-1][Ypos] == '#' || World[Xpos-1][Ypos] == '%' || World[Xpos-1][Ypos] == '&')
		{
		   World[Xpos][Ypos] = ' ';
		   Xpos = Xpos - Speed;
		   World[Xpos][Ypos] = Avatar;
		   HP++;
		}
	}
	void MoveUpLeft()
	{
		if (World[Xpos-1][Ypos-1] == ' ' || World[Xpos-1][Ypos-1] == '#' || World[Xpos-1][Ypos-1] == '%' || World[Xpos-1][Ypos-1] == '&')
		{
		   World[Xpos][Ypos] = ' ';
		   Xpos = Xpos - Speed;
		   Ypos = Ypos - Speed;
		   World[Xpos][Ypos] = Avatar;
		   HP++;
		}
	}
	void MoveDownLeft()
	{
		if (World[Xpos-1][Ypos+1] == ' ' || World[Xpos-1][Ypos+1] == '#' || World[Xpos-1][Ypos+1] == '%' || World[Xpos-1][Ypos+1] == '&')
		{
		   World[Xpos][Ypos] = ' ';
		   Xpos = Xpos - Speed;
		   Ypos = Ypos + Speed;
		   World[Xpos][Ypos] = Avatar;
		   HP++;
		}
	}
	void MoveUp()
	{
		if (World[Xpos][Ypos-1] == ' ' || World[Xpos][Ypos-1] == '#' || World[Xpos][Ypos-1] == '%' || World[Xpos][Ypos-1] == '&')
		{
		   World[Xpos][Ypos] = ' ';
		   Ypos = Ypos - Speed;
		   World[Xpos][Ypos] = Avatar;
		   HP++;
		}
	}
	void MoveDown()
	{
		if (World[Xpos][Ypos+1] == ' ' || World[Xpos][Ypos+1] == '#' || World[Xpos][Ypos+1] == '%' || World[Xpos][Ypos+1] == '&')
		{
		   World[Xpos][Ypos] = ' ';
		   Ypos = Ypos + Speed;
		   World[Xpos][Ypos] = Avatar;
		   HP++;
		}
	}
}

 class Item extends GameObject   // subclass
{
	String Name;
	int Value;

	Item(String NewName, int NewXpos, int NewYpos)
	{
		Name = NewName; Xpos = NewXpos; Ypos = NewYpos;

		if (Name.equals("thumper"))
		{
			Avatar = '+'; Value = 3; // +Defense
		}
		if (Name.equals("maker hooks"))
		{
			Avatar = '?'; Value = 1; // +Speed
		}
		if (Name.equals("water"))
		{
			Avatar = '~'; Value = 10; // +HP
		}
		if (Name.equals("crysknife"))
		{
			Avatar = '!'; Value = 3; // +Attack
		}
		if (Name.equals("spice"))
		{
			Avatar = '$'; Value = 2; // +HP(Value + 3), +Attack(Value), +Defense(Value)
		}
		if (Name.equals("shield belt"))
		{
			Avatar = '='; Value = 2; // -Defense
		}
		if (Name.equals("atomics"))
		{
			Avatar = '@'; Value = 2; // -Attack
		}

		World[Xpos][Ypos] = Avatar;
	}
}

// object: to get from terraforming experimentation site(top-left) to Sietch Tabr(bottom-right of gameboard)
// player can move & interact w/enemies & items from all directions, including diagonally
// items can be picked up and used; itmes can increase/decrease player's stats, speed
// 3 hiding places for player
// technicolor
// play again feature
// clear screen feature
// text intro
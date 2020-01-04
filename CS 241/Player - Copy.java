import java.util.Scanner;
public class Player extends Character{
public boolean cheatmode;
        public Player(String name, String des){
                super(name, des, 0);
        }


        public void play(Scanner com, XMLParser x){
		
        System.out.println("Enter command: ");
        boolean run = true;
        String line;
                line = com.nextLine();
                String token[] = line.split(":");
                String token1 = token[0];//item
		if(cheatmode && token[0].equals("look")){
					if(token.length > 1){
						Room rr = this.getCurrentroom();
						String token2 = token[1];
						token[1].trim();
						if(cheatmode && token[1].equals("all")){
							bst.getBST(printInOrder());							
						} else if(token[1].equals(rr)){
							bst.getBST(search(rr));
						}
					}
				} 
                Item item1 = null;		
                Room r = this.getCurrentroom();
                if(token.length > 1){
                String token2 = token[1];//command
                token[1].trim();
                item1 = r.getItem(token[0]);//
                }
                if(item1 != null){
                    if(token[1].equals("possess") || token[1].equals("Possess") || token[1].equals("shake") || token[1].equals("Shake") || token[1].equals("throw") || token[1].equals("Throw")){
                        if(token[1].equals("possess") || token[1].equals("Possess")){
                                for(Item.ItemAction a : item1.getItemActions()){
                                        if(a == Item.ItemAction.POSSESS)
                                        r.haunt(Item.ItemAction.POSSESS, item1);
                                }
                        }
                        if(token[1].equals("shake") || token[1].equals("Shake")){
                        for(Item.ItemAction a : item1.getItemActions()){
                                        if(a == Item.ItemAction.SHAKE)
                                        r.haunt(Item.ItemAction.SHAKE, item1);
                                }
                        }
                        if(token[1].equals("throw") || token[1].equals("Throw")){
                        for(Item.ItemAction a : item1.getItemActions()){
                                        if(a == Item.ItemAction.THROW && !item1.brk){
                                        r.haunt(Item.ItemAction.THROW, item1);
                                        item1.brk = true;
                                        }
                                        if(a == Item.ItemAction.THROW && item1.brk){
                                        System.out.println(token[0] +  " is broken and cannot be thrown anymore");
                                        }
                                }
                        }
                    }
                     else{
                        System.out.println("\n" + "Invalid option, try again");
                        }
                }
                else{
            switch(line){
				case "cheatmode":
				cheatmode = true;
				break;

				case "nocheatmode":
				cheatmode = false;
				break;

                                case "help":
                                case "Help":
                                case "h":
				case "wtf do i do":
                                        System.out.println("                                 Here's what you can do");
                                        System.out.println("You're the angry spirit of the Wacky House and you must scare people out of your resting place \n");
                                        System.out.println("  |help, h:                   Learn the commands                                           |");
                                        System.out.println("  |look, l:                   Learn what's in the room you are in                          |");
                                        System.out.println("  |north, n:                  Go to the room to the north, if you can                      |");
                                        System.out.println("  |south, s:                  Go to the room to the south, if you can                      |");
                                        System.out.println("  |east, e:                   Go to the room to the east, if you can                       |");
                                        System.out.println("  |west, w:                   Go to the room to the west, if you can                       |");
                                        System.out.println("  |[Itemname]:shake           Actions you can do to some items to scare people in the room |");
                                        System.out.println("  |[Itemname]:throw           Actions you can do to some items to scare people in the room |");
                                        System.out.println("  |[Itemname]:possess         Actions you can do to some items to scare people in the room |");
                                        System.out.println("  |exit, quit:                Leave the game and get out of my life                        |");
                                        System.out.println("\n");
                    			break;

                		case "look":
                                case "Look":
                                case "l":
                    			System.out.println(current.toString() + "\n");
                    			break;

                                case "north":
                                case "North":
                                case "n":
                                        this.roomCheck("north");
                                        break;

                                case "south":
                                case "South":
                                case "s":
                                        this.roomCheck("south");
                                        break;

                                case "east":
                                case "East":
                                case "e":
                                        this.roomCheck("east");
                                        break;

                                case "west":
                                case "West":
                                case "w":
                                        this.roomCheck("west");
                                        break;

                               /* case "shake":
                                case "Shake":
                                        break;

                                case "possess":
                                case "Possess":
                                        break;

                                case "throw":
                                case "Throw":
                                        break;
				*/
                		case "exit":
                                case "Exit":
                                case "quit":
                                case "Quit":
				case "Begone":
                                case "q":
                  			 System.out.println("\n" + "Farewell player, have a nice day.");
                   			 x.stop();
                   			 break;
     			        case "oh god make it stop":
                                        System.out.println("\n" + "Fine just leave already!");
					x.stop();
                                        break;
				case "Add Cam":
				if(cheatmode == true){
					Main.addtim(9001);
					System.out.println("\n" + "WE NEED! MORE! TIME!");
					break;
				} else if(cheatmode == false){
					System.out.println("Invalid command ;)");
					break;
					}

              		  default:
                   		 System.out.println("\n" + "Your command is not valid my guy");
                   		 break;
     }
}
}
}


import java.util.Random;
public abstract class Npc extends Character{//i chose abstract so that child and adult could be different
	private static int win = 0;
	private int sp = 0;
          public Npc(String name, String des, int spook){
             super(name, des, spook);
        }
	public static int getWin(){
		return win;
		}
                //npc reaction to being scared
                public void react(Item.ItemAction ac){
                        Random rand = new Random();
                        Room cur = this.getCurrentroom();
                        int l;
                        if(ac == Item.ItemAction.POSSESS){
                        sp = rand.nextInt(15) + 5;
			spook = sp + spook;
                        }
                        if(ac == Item.ItemAction.SHAKE){
                        sp = rand.nextInt(25) + 10;
			spook = sp + spook;
                        }
                        if(ac == Item.ItemAction.THROW){
                        sp = rand.nextInt(40) + 20;
			spook = sp + spook;
                        }
                        if(spook <= 49){
                        System.out.println( this.name + " isn't that scared, spook " + spook);
						System.out.println("Time left: " + Main.getTime());
                        }
                        if(spook >= 50 && spook <= 99){
                        //make rand num and set to each room and move them
						while(true){
                        l = rand.nextInt(4) + 1;
							if(l == 1){
								if(this.go("north")){
									System.out.println(this.name + " went to the north room " + spook);
									System.out.println("Time left: " + Main.getTime());
									break;
								}
							}
							if(l == 2){
								if(this.go("south")){
									System.out.println(this.name + " went to the south room " + spook);
									System.out.println("Time left: " + Main.getTime());
									break;
								}
							}
							if(l == 3){
								if(this.go("west")){
									System.out.println(this.name + " went to the west room " + spook);
									System.out.println("Time left: " + Main.getTime());
									break;
								}
							}
							if(l == 4){
								if(this.go("east")){
									System.out.println(this.name + " went to the north room " + spook);
									System.out.println("Time left: " + Main.getTime());
									break;
								}
							}
							}
						}
                        if(spook >= 100){
                        System.out.println(this.name + " left the house, spook " + spook);
			Main.addtim(30);
			win++;
                        current.remove(this);
						System.out.println("Time left: " + Main.getTime());
                        }

                }
}


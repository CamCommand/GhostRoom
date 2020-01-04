public abstract class Character{//I chose abstarct so that npc and player could be different
protected Room current;
protected String name;
protected String des;
protected int spook;
public Character(String name, String des, int spook){
        this.name = name;
        this.des = des;
        this.spook = spook;
}
//character itself will not be implemented, player moves around and npc will take from character
//super
//reaction method from the things in the room
public void moveTo(Room x){//moving character
                        current.remove(this);
			x.addAdult(this);
                }
				
public boolean go(String ror){
	switch(ror){
			case "north":
                        case "North":
                        case "n":
                        if(current.getdieRoom(ror) != null){
                                this.moveTo(current.getdieRoom(ror));
                                return true;
                        }
						
                        case "south":
                        case "South":
                        case "s":
                        if(current.getdieRoom(ror) != null){
                                this.moveTo(current.getdieRoom(ror));
                                return true;
                        }
                        case "east":
                        case "East":
                        case "e":
                                if(current.getdieRoom(ror) != null){
                                this.moveTo(current.getdieRoom(ror));
                                return true;
                        }

                        case "west":
                        case "West":
                        case "w":
                        if(current.getdieRoom(ror) != null){
                                this.moveTo(current.getdieRoom(ror));
                                return true;
                        }
                        default:
                        System.out.println("That is not a valid direction, try again");
                        return false;
	}
		
}
				
public boolean roomCheck(String ro){//user input
                switch(ro){

                        case "north":
                        case "North":
                        case "n":
                        if(current.getdieRoom(ro) != null){
                                this.moveTo(current.getdieRoom(ro));
                                System.out.println("\n" + name + " " + "moved to the northern room");
                                return true;
                        }
                        else{
                                System.out.println("\n" + "There is no northern room");
                                return false;
                        }
                        //break;

                        case "south":
                        case "South":
                        case "s":
                        if(current.getdieRoom(ro) != null){
                                this.moveTo(current.getdieRoom(ro));
                                System.out.println("\n" + name + " " + "moved to the southern room");
                                return true;
                        }
                        else{
                                System.out.println("\n" + "There is no southern room");
                                return false;
                        }
                        //break;

                        case "east":
                        case "East":
                        case "e":
                                if(current.getdieRoom(ro) != null){
                                this.moveTo(current.getdieRoom(ro));
                                System.out.println(name + " " + "moved to the eastern room");
                                return true;
                        }
                        else{
                                System.out.println("\n" + "There is no eastern room");
                                return false;
                        }
                        //break;

                        case "west":
                        case "West":
                        case "w":
                        if(current.getdieRoom(ro) != null){
                                this.moveTo(current.getdieRoom(ro));
                                System.out.println("\n" + name + " " + "moved to the western room");
                                return true;
                        }
                        else{
                                System.out.println("\n" + "There is no western room");
                                return false;
                        }
                        //break;

                        default:
                        System.out.println("\n" + "That is not a valid direction, try again");
                        return false;
}
}

public void setRoom(Room r){//reference
                this.current = r ;
        }
public int getValue(){
        return spook;
}
public Room getCurrentroom(){
        return current;
}
   public String toString(){//get name and description
                return "\n" + this.name + " " + this.des + "\n";
        }
}
//hierarchy
//                                      --> child
//character --> npc --> adult
//                      --> player





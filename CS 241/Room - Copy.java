import java.util.ArrayList;
import java.util.LinkedList;
public class Room implements Comparable<Room>{
        private Character[] cha = new Character[5];
        private String name, des;
        private Room roomn;//room references in directions
        private Room rooms;
        private Room roome;
        private Room roomw;
	//private Node head, tail;
	private int count;	

        ArrayList<Item> items = new ArrayList<Item>();

	public int compareTo(Room rq){
		return name.compareTo(rq.getName());
	}

        public void haunt(Item.ItemAction ac, Item item1){
                //roomCheck()
                if(ac == Item.ItemAction.POSSESS){
                        System.out.println("Someone got scared from the " + item1);
                        for(Character c : cha){
                                if(c instanceof Npc){
                                        ((Npc)c).react(Item.ItemAction.POSSESS);
                                        }
                        }
                }
                if(ac == Item.ItemAction.SHAKE){
                        System.out.println("Someone got scared from the " + item1);
                        for(Character c : cha){
                                if(c instanceof Npc){
                                        ((Npc)c).react(Item.ItemAction.SHAKE);
                                        }
                        }
                }

                if(ac == Item.ItemAction.THROW){
                        System.out.println("Someone got scared from the " + item1);
                        for(Character c : cha){
                                if(c instanceof Npc){
                                        ((Npc)c).react(Item.ItemAction.THROW);
                                        }
                        }
                }
                if(ac != Item.ItemAction.SHAKE && ac != Item.ItemAction.POSSESS && ac != Item.ItemAction.THROW){
                System.out.println("The " + item1 + " can't do that");
                }
}


        public Item getItem(String name){
                for(int i = 0; i < items.size(); i++){
                        if(items.get(i).getName().equals(name)){
                                return items.get(i);
                        }
                }
                return null;
        }

        public Room getdieRoom(String rz){//what should be a getter for the room directions
                if(rz.equals("north")){
                return roomn;
                }
                if(rz.equals("south")){
                return rooms;
                }
                if(rz.equals("west")){
                return roomw;    }
                if(rz.equals("east")){
                return roome;
                }
                return null;
        }

        public String getName(){
        return this.name;
        }

                public void remove(Character y){
                         for (int i = 0; i < cha.length; i++){ // go through the array
                        if(cha[i] == y){ //check if there is a character
                                cha[i] = null;
                                break;
                        }
                }
        }
        public void setNxtroom(String die, Room room){//setting the rooms to die
                if(die.equals("south")){
                this.rooms = room;
                }
                else if(die.equals("north")){
                this.roomn = room;
                }
                else if(die.equals("west")){
                this.roomw = room;
                }
                else if(die.equals("east")){
                this.roome = room;
                }
        }
                public void addItem(Item i){//hw description add array of Items to the Room
                        items.add(i);
                }

        public Room(String name, String des){
                this.name = name;
                this.des = des;
        }

        public String toString(){// if character is full
                String total = "";
                for(Item jabbo : items){//items check
                        if(jabbo != null){
                        total += jabbo.toString();
                        }
                }
                for(int i = 0; i < cha.length; i++){
                        if(cha[i] == null){

                        }else
                        total = total + cha[i].toString();
                }
                return "\n" + name + " " + des + "\n" + total;
        }

        public void addAdult(Character a){ //adding Character
                for (int i = 0; i < cha.length; i++){ // go through the array
                        if(cha[i] == null){ //check if there is room
                                cha[i] = a;
                                cha[i].setRoom(this);
                                break;
						}
				}
		}
}

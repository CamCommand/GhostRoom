public class Item{
        private String name, des;
        public boolean brk = false;
        private ItemAction[] actionArray;
        public Item(String name, String des){
                this.name = name;
                this.des = des;
                actionArray = new ItemAction[3];//array of item actions we cannot have two of the same action
        }
        public enum ItemAction{POSSESS, SHAKE, THROW}//three actions items can have in an enum so i can reference their values
        private ItemAction itemaction;

        public Item(ItemAction itemaction){
                this.itemaction = itemaction;
        }

        public void addItemAction(ItemAction action){//add item method
                for(int i = 0; i < actionArray.length; i++){
                        if(actionArray[i] != null){//check if it's already there
                                if(actionArray[i] == action){
                                        break;
                                }
                        } else{
                                actionArray[i] = action;
                                break;
                        }

                }
        }
        public void printAction(){//to check if there is room for the same action
        for(int i = 0; i < actionArray.length; i++){
        if(actionArray[i] != null){
                System.out.println(actionArray[i]);
                        }
                }
        }

        public String getName(){
        return this.name;
        }
   public String toString(){//get name and description
        String total = "";
        for(ItemAction guido : actionArray){//items check
                if(guido != null){
                total += " " + guido.name();
                }
                }
                return "\n" + this.name + " " + this.des + ((brk)?" Broken: ":"")  + total + "\n";//if broken is true that add broken
        }
                public ItemAction[] getItemActions(){
                        return actionArray;
                }
}



import java.util.Scanner;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
public class Main{
private static Timer timer;
private static AtomicInteger timeLeft;
	
	public static void initTimer(int secs) {
		timeLeft = new AtomicInteger(secs);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				int tl = timeLeft.decrementAndGet();
				if (tl == 0) {
					System.out.println("You're out of time, GAME OVER");
					System.exit(0);
						}
				if(Npc.getWin() == 5){
					System.out.println("You win the Game, cOgRaTuLaTiOnS");
					System.exit(0);
					}
					}
			};
	timer = new Timer();
	timer.schedule(task, 0, 1000);
		}
	
	public static int getTime(){
		return timeLeft.get();
	}
	public static int addtim(int i){
	return timeLeft.addAndGet(i);
	}
	
	public static String outta(){
	return "Time left: " + Main.getTime();
	}
	
        public static void main(String[] args){
		Main.initTimer(60);
		Scanner com = new Scanner(System.in);
		System.out.println("What's the name of the file: (xmldoc.xml) ");
		String filename = com.next();
		XMLParser danplease = new XMLParser();
		danplease.parse(filename);
		}
	public static void game(HashMap<Room,HashMap<String, String>> cleveland){//;)
		while (true){
  			}
		}
	}
/*this.player(com);
        Scanner camsdeath = new Scanner(System.in);
        System.out.println("Tell me the name of the room sweetheart ;) ");
        String roomname = camsdeath.next();
        boolean founduz = false;
        for(Room rom : cleveland.keySet()){
//System.out.println(rom.getName());
                if(rom.getName().equals(roomname)){
                System.out.println(rom.toString() + "\n");
                founduz = true;
                break;
                }
        }
        if(!founduz){
        System.out.println("Yo that room be quacking there.(quacking: to be defined as not real)");
    */  

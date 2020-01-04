import org.xml.sax.Attributes;
import java.util.Scanner;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.HashMap;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.util.ArrayList;

public class XMLParser extends DefaultHandler {

	String stringBuffer;
	BST bst = new BST();
	boolean run2 = true;
	String name;
	String des;
	Room currentroom;
	Item item;
	Adult adult;
	Child child;
	Player player;
	private HashMap<Room,HashMap<String, String>> hash = new HashMap<Room,HashMap<String, String>>() ;//One hashmap has the room itself and the inside hash keeps the direction of rooms

	public BST getBST(){
		return bst;
	}

    @Override
    public void startDocument() throws SAXException {
	//System.out.println("Start Document");
    }

    @Override
    public void startElement(String namespaceURI,
                             String localName,
                             String qName, 
                             Attributes atts) throws SAXException {
				
				//System.out.println("Start Element " + qName);
				
				if (qName.equals("room")){
					currentroom = new Room(atts.getValue("name"), atts.getValue("description"));
					HashMap<String, String> hashother = new HashMap<String, String>();//adjacent rooms
					hash.put(currentroom, hashother);//the hash has the room then the direction taking you to the next room<kitchen,<"south", "den"
					 if (atts.getValue("south") != null){
						 hashother.put("south", atts.getValue("south"));//hashother put has the key as in south and value of what is to the south or getValue
					 }
					 if (atts.getValue("north") != null){
						 hashother.put("north", atts.getValue("north"));
					 }
					 if (atts.getValue("east") != null){
						 hashother.put("east", atts.getValue("east"));
					 }
					 if (atts.getValue("west") != null){
						 hashother.put("west", atts.getValue("west"));
					 }
				}
				else if (qName.equals("item")){
						item = new Item(atts.getValue("name"), atts.getValue("description"));
						//string list
						String[] actions = atts.getValue("actions").split(",");
						for(String x: actions){
							item.addItemAction(Item.ItemAction.valueOf(x.toUpperCase()));//returns the element of enum
						}
						currentroom.addItem(item);
					}
					
				else if (qName.equals("adult")){
					adult = new Adult(atts.getValue("name"), atts.getValue("description"), 0);
					currentroom.addAdult(adult);
				}
				else if (qName.equals("child")){
					child = new Child(atts.getValue("name"), atts.getValue("description"), 0);
					currentroom.addAdult(child);
				}
				else if (qName.equals("player")){
					player = new Player(atts.getValue("name"), atts.getValue("description"));
					currentroom.addAdult(player);
				}
				
    }//

    @Override
    public void endElement(String namespaceURI,
                           String localName,
                           String qName) throws SAXException {
	//System.out.println("End Element " + qName);//!!!!!!!!!pain is my reward for being evil
	
    }
    @Override
    public void endDocument() throws SAXException {
	  //System.out.println("End Document");
	  for (HashMap.Entry<Room, HashMap<String, String>> entry : hash.entrySet()) {//: means in
    		Room key = entry.getKey();//room
    		HashMap<String, String> value = entry.getValue();////4//ignore
    		for(HashMap.Entry<String, String> kyle : value.entrySet()){//kyle a good boy and he know where the rooms are
			String die = kyle.getKey();//get direction 
			String nam = kyle.getValue();    //get
			for(Room roooom : hash.keySet()){
				if(nam.equals(roooom.getName())){
					key.setNxtroom(die, roooom);
					bst.insert(roooom);//getmethod
					break;//end this hell
				}
			}
					
    		}
   
	}	

	while(run2){
		player.play(new Scanner (System.in), this); 
		System.out.println(Main.outta());	
	}
    }
	//xml--> parsing :) is good--> works yes--> rooms items all the things yes up them v
	//main --> asking user--> testing
    @Override//maybe not need//nopes
    public void characters(char ch[], int start, int length)
        throws SAXException {

    }
	public void stop(){
	run2 = false;
	}
	
    public void parse(String filename){
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            InputStream xmlInput  = new FileInputStream(filename);
            SAXParser saxParser = spf.newSAXParser();
            XMLParser lxp = new XMLParser();
            saxParser.parse(xmlInput, lxp);
            
        }
        catch(SAXException|ParserConfigurationException|IOException e){
            e.printStackTrace();
        }
    }
}

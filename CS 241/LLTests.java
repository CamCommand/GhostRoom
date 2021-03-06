public class LLTests {
    public static void main(String[] args){
	LinkedList<Integer> ll = new LinkedList<>();
	ll.prepend(5);
	ll.prepend(4);
	ll.prepend(3);
	ll.prepend(2);
	ll.prepend(1);

	// Expected output: 1 2 3 4 5
	System.out.println(ll);
	// Testing existance/retrieval on head, tail, and middle.
	System.out.println("Exists 5 " + ll.exists(5) + " " + ll.get(4));
	System.out.println("Exists 3 " + ll.exists(3) + " " + ll.get(2));
	System.out.println("Exists 1 " + ll.exists(1) + " " + ll.get(0));

	// Inserting new head.
	System.out.println("Inserting 6 at 0");
	ll.insert(6, 0);
	System.out.println(ll);

	// Insdering in middle.
	System.out.println("Inserting 40 at 3");
	ll.insert(40, 3);
	System.out.println(ll);

	// Inserting at tail.
	System.out.println("Inserting 0 at 7");
	ll.insert(0, 7);
	System.out.println(ll);

	// Removing head.
	System.out.println("Removing 6");
	ll.remove(6);
	System.out.println(ll);

	// Removing muddle. 
	System.out.println("Removing 3");
	ll.remove(3);
	System.out.println(ll);

	// Removing tail.
	System.out.println("Removing 0");
	ll.remove(0);
	System.out.println(ll);

    }
}

public class LinkedList<T> implements Iterable<T> {
 
    private class Node<T> {
        T data;
        Node<T> next;
 
        public Node(T data){
            this.data = data;
        }
 
        public Node(T data, Node<T> next){
            this(data);
            this.next = next;
        }
 
        public String toString(){
            return "" + data;
        }
		public Node getNode(){
			if(index == 0){
			return this;	
		} else {
			return next.getNode(index - 1);
		}
    }
		public void insert(T data, int index){
		if(index == 0){
				Node temp = new Node(data);
				this.prev = temp;
				temp.next = this;
				temp.prev = this.prev;
		} else{
			this.next.insert(T, index - 1);
		}
		}
		
		public boolean remove(T data){
			if(this.data.equals(data)){
				this.prev.next = this.next;
				return true;
			}
			if(next != null){
				return next.remove(data);
			} else {
				return false;
			}
		}
		
		public boolean exists(T data){
			if(data.equals(this.data)){
				return true;
			}
			if(next != null){
				return this.next.exists(data);
			}
			return false;
		}
    }
    public class LLIterator<U> implements Iterator<U> {
        LinkedList<U> ll;
        LinkedList<U>.Node<U> curr;
 
        public LLIterator(LinkedList<U> ll){
            this.ll = ll;
            curr = null;
        }
 
        public boolean hasNext(){
            if (curr == ll.tail && ll.tail != null) return false;
            return true;
        }
 
        public U next(){
            if (curr == null)
                curr = ll.head;
            else curr = curr.next;
            return curr.data;
        }
    }
 
    private Node<T> head, tail;
    private int count;
 
    public LinkedList(){
        count = 0;
    }
 
    public void prepend (T i){
        if (count == 0){
            head = tail = new Node<T>(i);
        }
        else {
            head = new Node<T>(i, head);
        }
        count++;
    }
 
    public void append(T i){
        if (count == 0){
            head = tail = new Node<T>(i);
        }
        else {
            tail = tail.next = new Node<T>(i);
        }
        count++;
    }

	
 public T get(int index){
	 if(index < 0 || index > count){
		 throw IndexOutOfBoundsException;
	 } 
	
	 return head.getNode(index).data;
 }
 public boolean remove(T data){
    return head.remove(data);
 }
 
 public boolean exists(T data){
	return head.exists(data);
 }
 
 public void insert(T data, int index){
	 Node node = new Node();
     node.data = data;
     node.nextNode = null;
     
	 if(index < 0 || index > count){
		 throw IndexOutOfBoundsException;
	 } else{
		head.insert(T, index);
	 }	   
 }
    public int size(){
        return count;
    }
 
    public boolean isEmpty(){
        return head == null;
    }
 
    public String toString() {
        String retVal = "Linked list with " + count + " elements\nNodes:";
 
        for (Node<T> temp = head; temp != null; temp = temp.next)
            retVal += temp + " ";
        
        return retVal;
    }
 
    public Iterator<T> iterator(){
        return new LLIterator<T>(this);
    }
}
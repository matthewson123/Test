import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ListStack extends LinkedList {


    public ListStack() {    // <== constructor, different from ListStackComp.java
		super();
    }

	public boolean empty() {
	   return head == null;
	}

	public Object push(Object item) {
		addToTail(item);
		return head.getData();
	}

	public Object pop() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = head.getData();
		head = head.getNext();
		length--;
		return item;
	}

	public Object peek() {
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return head.getData();
	}

	public int search(Object item) {
		
		for (int i = length; i > 0; i--) {
			if (item.equals(get(i)) == true) {
				return length - i + 1;
			}
		}
		return -1;
	}
		
}
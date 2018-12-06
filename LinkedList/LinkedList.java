class ListNode {
	Object data;
	ListNode next;
	ListNode previous;
	ListNode(Object o) { data = o; next = null; }
	ListNode(Object o, ListNode nextNode, ListNode previousNode ) 
		{ data = o; next = nextNode; previous = previousNode; }
	Object getData() { return data; }
	ListNode getNext() { return next; }
	ListNode getPrevious() { return previous; }
} // class ListNode

class EmptyListException extends RuntimeException {
	public EmptyListException () { super ("List is empty"); }
} // class EmptyListException

class LinkedList {
	private ListNode head;
	private ListNode tail;
	public LinkedList() { head = tail = null; }
	public boolean isEmpty() { return head == null; }
	public void addToHead(Object item) {
		if (isEmpty()){
			head = tail = new ListNode(item);
		}else {
			head = head.previous = new ListNode(item, head, null);
		}
		
	}
	public void addToTail(Object item) {
		if (isEmpty()){
			head = tail = new ListNode(item);
		}else{
			tail = tail.next = new ListNode(item, null, tail);
		}
	}
	public Object removeFromHead() throws EmptyListException {
		Object item = null;
		if (isEmpty())
		throw new EmptyListException();
		item = head.data;
		if (head == tail)
		head = tail = null;
		else
		{
		head = head.next;
		head.previous = null;
		}
		return item;
		
	}
	public Object removeFromTail() throws EmptyListException {
		Object item = null;
		if (isEmpty())
		throw new EmptyListException();
		item = tail.data;
		if (head == tail)
		head = tail = null;
		else
		{
		tail = tail.previous;
		tail.next = null;
		}
		return item;
		}
	public String toString () {
		String s = "[ ";
		ListNode current = head;
		while (current != null) {
			s += current.data + " ";
			current = current.next;
		}
		return s + "]";
	}
} // class LinkedList

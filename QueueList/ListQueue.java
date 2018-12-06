import java.util.LinkedList;

class ListNode {
Object data;
ListNode next;
ListNode(Object o) { data=o; next=null; }
ListNode(Object o, ListNode nextNode){data = o; next = nextNode;}
public Object getData() {return data;}
public ListNode getNext() { return next; }
}

class EmptyQueueException extends RuntimeException{
    public EmptyQueueException (){
        super("Queue is empty");
    }
}

public class ListQueue extends LinkedList{
    private ListNode head;
    private ListNode tail;
    public ListQueue() { head = tail = null; } 
    public boolean empty() { return head == null; }
    public void enqueue(Object item){
    if (empty()){
        head = tail = new ListNode(item);
    }else{
        tail = tail.next = new ListNode(item);
    }
    }
    public Object dequeue() throws EmptyQueueException {
    Object item = null;
    if (empty())throw new EmptyQueueException();
    item = head.data;
    if (head == tail)
    head = tail = null;
    else
    head = head.next;
    return item;
    }

    public String toString(){   
        String s = new String("Head[ ");
        ListNode current = head;
        while (current != null){
            s = s.concat(current.data.toString() + " ");
            current = current.next;
        }
        s = s.concat("]Tail");
        return s;
    }
}

public class LeetCode_OddEvenLinkedList {
	static class Node {
		int data ;
		Node next;
	}
	static Node newNode(int key) {
		Node node = new Node();
		node.data = key;
		node.next = null;
		return node;
	}
	private static Node rearrangeEvenOdd(Node head) {
		// Corner case  
	    if (head == null)  
	        return null;  
	  
	    // Initialize first nodes of even and  
	    // odd lists  
	    Node odd = head;  
	    Node even = head.next;  
	  
	    // Remember the first node of even list so  
	    // that we can connect the even list at the  
	    // end of odd list.  
	    Node evenFirst = even;  
	  
	    while (1 == 1)  
	    {  
	        // If there are no more nodes,   
	        // then connect first node of even   
	        // list to the last node of odd list  
	        if (odd == null || even == null || 
	                        (even.next) == null)  
	        {  
	            odd.next = evenFirst;  
	            break;  
	        }  
	  
	        // Connecting odd nodes  
	        odd.next = even.next;  
	        odd = even.next;  
	  
	        // If there are NO more even nodes   
	        // after current odd.  
	        if (odd.next == null)  
	        {  
	            even.next = null;  
	            odd.next = evenFirst;  
	            break;  
	        }  
	  
	        // Connecting even nodes  
	        even.next = odd.next;  
	        even = odd.next;  
	    }  
	    return head;  
	}
	static void printlist(Node node)  
	{  
	    while (node != null)  
	    {  
	        System.out.print(node.data + "->");  
	        node = node.next;  
	    }  
	    System.out.println("NULL") ;  
	}  
	public static void main(String[] args) {
		Node head = newNode(1);  
	    head.next = newNode(2);  
	    head.next.next = newNode(3);  
	    head.next.next.next = newNode(4);  
	    head.next.next.next.next = newNode(5);  
	  
	    
	    System.out.println("Given Linked List");  
	    printlist(head);  
	  
	    head = rearrangeEvenOdd(head);  
	  
	    System.out.println("Modified Linked List");  
	    printlist(head);
	}
	
}

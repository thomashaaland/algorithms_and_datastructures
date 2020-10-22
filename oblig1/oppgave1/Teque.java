import java.util.Scanner;

// This works, but is slow! Reason for slowness is the get method which is
// O(n). Maybe implement a binary AVL tree with indices and value?
// push_back i -= 1, 
// push_front j += 1
// middle = (i + j)/2
// Speed can be kept O(1) with direct links to start, end, middle nodes
// and get can be lowered to O(log(n)) worst-case

class Treque {
    Node start;
    Node end;
    Node middle;
    int n;
    
    private class Node {
	Node next;
	Node prev;
	int value;

	Node(int value) {
	    this.value = value;
	}
    }

    public Treque() {
	start = null;
	end = null;
	middle = null;
	n = 0;
    }

    private void push_empty_que(Node newNode) {
	n += 1;
	start = newNode;
	middle = newNode;
	end = newNode;
    }    
	
    public void push_back(int i) {
	Node newNode = new Node(i);
	if (n == 0) {
	    push_empty_que(newNode);
	}
	else {
	    newNode.next = end;
	    end.prev = newNode;
	    end = newNode;
	    n += 1;
	    if (n % 2 == 0) {
		middle = middle.prev;
	    }
	}
    }

    public void push_front(int i) {
	Node newNode = new Node(i);
	if (n == 0) {
	    push_empty_que(newNode);
	}
	else {
	    newNode.prev = start;
	    start.next = newNode;
	    start = newNode;
	    n += 1;
	    if (n % 2 == 1) {
		middle = middle.next;
	    }
	}
    }

    public void push_middle(int i) {
	Node newNode = new Node(i);
	if (n == 0) {
	    push_empty_que(newNode);
	}
	else if (n == 1) {
	    push_back(i);
	}
	else {
	    n += 1;
	    if (n % 2 == 0) {
		newNode.next = middle;
		newNode.prev = middle.prev;
		
		middle.prev.next = newNode;
		middle.prev = newNode;
		middle = newNode;
	    }
	    else {
		newNode.prev = middle;
		newNode.next = middle.next;

		middle.next.prev = newNode;
		middle.next = newNode;
		middle = newNode;
	    }
	}
    }

    public int get(int i) {
	return traverse(i, start).value;
    }

    private Node traverse(int i, Node current) {
	if (i == 0) {
	    return current;
	}
	else {
	    return traverse(i - 1, current.prev);
	}
    }
}

class Teque {
    public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	while (sc.hasNextInt()) {
	    Treque que = new Treque();
	    int n = Integer.parseInt(sc.nextLine());
	    for (int i = 0; i < n; i++) {
		String[] a = sc.nextLine().split(" ");
		int k = Integer.parseInt(a[1]);
		if (a[0].equals("push_back")) {
		    que.push_back(k);
		}
		else if (a[0].equals("push_front")) {
		    que.push_front(k);
		}
		else if (a[0].equals("push_middle")) {
		    que.push_middle(k);
		}
		else {
		    System.out.println(que.get(k));
		}
		
	    }
	}
    }
}

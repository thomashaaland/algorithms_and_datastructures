import java.util.HashMap;
import java.util.Set;
import java.util.PriorityQueue;

class HuffmanCode {

    private class Node {
	Character s;
	int f;
	Node left;
	Node right;

	Node(Character s, int f, Node left, Node right) {
	    this.s = s;
	    this.f = f;
	    this.left = left;
	    this.right = right;
	}
    }

    Node root;
    
    public HuffmanCode(String s) {
	// Get freqs
	HashMap<Character, Integer> freqs;
	PriorityQueue<Node> pQ;


	freqs = new HashMap<>();
	for (Character c : s.toCharArray()) {
	    if (freqs.containsKey(c))
		freqs.put(c, freqs.get(c) + 1);
	    else
		freqs.put(c, 1);
	}
	
	// Make the priorityQueue
	pQ = new PriorityQueue<>( (a, b) -> a.f - b.f );

	for (HashMap.Entry<Character, Integer> entry : freqs.entrySet()) {
	    pQ.offer(new Node(entry.getKey(), entry.getValue(), null, null));
	}
	
	root = constructTree(pQ);
	
    }
    
    private Node constructTree(PriorityQueue<Node> pQ) {
	while (pQ.size() > 1) {
	    Node v1 = pQ.poll();
	    Node v2 = pQ.poll();
	    int f = v1.f + v2.f;
	    pQ.offer(new Node(null, f, v1, v2));
	}
	return pQ.poll();
    }
}

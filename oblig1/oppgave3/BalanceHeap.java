import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
  Klasse som bruker heap for aa skrive ut gitte tall slik
  at dersom satt inn i et bineart soeke tre vil treet bli
  balansert
*/

class HeapBalancer {
    int midN;

    // Constructor kaller balance metoden direkte
    public HeapBalancer(PriorityQueue<Integer> inQ) {
	balance(inQ);
    }

    // Balance metoden utforer balanseringen
    public void balance(PriorityQueue<Integer> inQ) {
	if (inQ.size() > 0) {
	    PriorityQueue<Integer> lowerQue = new PriorityQueue<>();
	    midN = inQ.size() / 2;
	    while (midN-- > 0)
		lowerQue.offer(inQ.poll());
	    System.out.println(inQ.poll());
	    balance(inQ);
	    balance(lowerQue);
	}
    }
}

class BalanceHeap {
    public static void main(String[] args) throws IOException {
	PriorityQueue<Integer> q = new PriorityQueue<>();
	BufferedReader in =
	    new BufferedReader(new InputStreamReader(System.in));

	for (String line = in.readLine(); line != null; line = in.readLine()) {
	    q.offer(Integer.parseInt(line));
	}

	HeapBalancer balancer = new HeapBalancer(q);
    }
}

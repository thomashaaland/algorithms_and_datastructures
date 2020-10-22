import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Balancer {
    int[] arr;
    int[] barr;

    Balancer(int[] arr) {
	this.arr = arr;
    }

    public void balance() {
	balancer(0, arr.length - 1);
    }

    private void balancer(int min, int max) {
	int mid = (min + max) / 2;
	if (min <= max) {	    
	    System.out.println(mid);
	    // get uppermid
	    balancer(mid + 1, max);
	    // get lowermid
	    balancer(min, mid - 1);
	}
    }

    @Override
    public String toString() {
	return "String";
    }
}

class BalanceArray {
    public static void main(String[] args) throws IOException {

	BufferedReader in =
	    new BufferedReader(new InputStreamReader(System.in));
	int[] arr = in.lines().mapToInt(i -> Integer.parseInt(i)).toArray();
	
	Balancer balance = new Balancer(arr);
	balance.balance();	
    }
}

class Stack {
    int[] stack;
    int t;
    int n;

    public Stack(int n) {
	this.n = n;
	stack = new int[n];
	t = -1;
    }

    public void push(int o) {
	if (t > n - 2) System.out.println("Stack full");
	else {
	    t++;
	    stack[t] = o;
	}
    }

    public int pop() {
	if (t < 0) return -1;
	else {
	    int temp = stack[t];
	    t--;
	    return temp;
	}
    }	    
}

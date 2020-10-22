class Que {
    int que[];
    int n;
    int f;
    int r;

    public Que(int n) {
	this.n = n;
	que = new int[n];
	f = 0;
	r = 0;
    }

    public void enque(int i) {
        if (r == n) {
	    System.out.println("Error");
	}
	else {
	    que[r] = i;
	    r++;
	}
    }

    public int deque() {
	if (f == r + 1)
	    return -1;
	else {
	    int temp = que[f];
	    f++;
	    return temp;
	}
    }
	    
}

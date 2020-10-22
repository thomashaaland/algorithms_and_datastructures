class RecursiveMax {
    private int[] array;
    private int length;

    public RecursiveMax(int[] array) {
	this.array = array;
	this.length = array.length;
    }

    private int max(int a, int b) {
	if (a > b)
	    return a;
	else
	    return b;
    }

    private int findMax(int[] array, int n) {
	if (n == 0)
	    return array[0];
	else
	    return max(findMax(array, n - 1), array[n]);
    }
    
    public int getMax() {
	return findMax(array, length);
    }
}

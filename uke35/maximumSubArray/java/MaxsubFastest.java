class MaxsubFastest {
    int array[];
    int n;

    public MaxsubFastest(int[] array) {
	this.array = array;
	n = array.length;
    }

    private int max(int a, int b) {
	if (a > b)
	    return a;
	else
	    return b;
    }

    public int getSubArrayValue() {
	int mArray[] = new int[n];
	mArray[0] = 0;
	for (int t = 1; t < n; t++)
	    mArray[t] = max(0, mArray[t - 1] + array[t]);
	int m = 0;
	for (int t = 1; t < n; t++)
	    m = max(m, mArray[t]);
	return m;
    }
}

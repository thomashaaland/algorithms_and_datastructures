class MaxsubFaster {
    int array[];
    int n;

    public MaxsubFaster(int array[]) {
	this.array = array;
	n = array.length;
    }

    public int getSubArrayValue() {
	int[] sArray = new int[n];
	int sTemp = 0;
	for (int i = 0; i < n; i++) {
	    sTemp += array[i];
	    sArray[i] = sTemp;
	}
	int m = 0;
	int s;
	for (int j = 1; j < n; j++) {
	    for (int k = j; k < n; k++) {
		s = sArray[k] - sArray[j-1];
		if (s > m)
		    m = s;
	    }
	}
	return m;
    }
}

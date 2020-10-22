class SelectionSort {
    int[] sortedArr;
    double runTime;
    int n;

    public SelectionSort(int[] arr) {
	sortedArr = arr.clone();
	n = arr.length;
	long startTime = System.nanoTime();
	sort();
	long endTime = System.nanoTime();
	runTime = ((double) (endTime - startTime)) / 1000000000;
    }
    
    private void swap(int i, int j) {
	int temp = sortedArr[i];
	sortedArr[i] = sortedArr[j];
	sortedArr[j] = temp;
    }
    
    private void sort() {
	int smallest, smallestI;
	for (int i = 0; i < n - 1; i++) {
	    smallest = sortedArr[i];
	    smallestI = i;
	    for (int j = i + 1; j < n; j++) {
		if (smallest > sortedArr[j]) {
		    smallest = sortedArr[j];
		    smallestI = j;
		}
	    }
	    swap(i, smallestI);
	}
    }
    
    public int[] getArr() {
	return sortedArr;
    }

    public double getRunTime() {
	return runTime;
    }
}

class BubbleSort {
    int[] sortedArr;
    double runTime;
    int n;

    public BubbleSort(int[] arr) {
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
	int swaps;
	for (int i = 0; i < n - 1; i++) {
	    swaps = 0;
	    for (int j = 0; j < n - i - 1; j++) {
		if (sortedArr[j] > sortedArr[j + 1]) {
		    swap(j, j + 1);
		    swaps++;
		}
	    }
	    if (swaps == 0) break;
	}
    }
    
    public int[] getArr() {
	return sortedArr;
    }

    public double getRunTime() {
	return runTime;
    }
}

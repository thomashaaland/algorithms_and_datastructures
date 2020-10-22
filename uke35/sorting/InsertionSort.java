class InsertionSort {
    int[] sortedArr;
    double runTime;
    int n;

    public InsertionSort(int[] arr) {
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
	int j;
	for (int i = 1; i < n - 1; i++) {
	    j = i;
	    while (j > 0 && sortedArr[j-1] > sortedArr[j]) {
		swap(j-1, j);
		j--;
	    }
	}
    }
    
    public int[] getArr() {
	return sortedArr;
    }

    public double getRunTime() {
	return runTime;
    }
}

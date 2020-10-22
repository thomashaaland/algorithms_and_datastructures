class HeapSort {
    int[] sortedArr;
    double runTime;
    int n;

    public HeapSort(int[] arr) {
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

    private void bubbleDown(int[] arr, int i, int n) {
	int largest = i;
	int left = 2 * i + 1;
	int right = 2 * i + 2;
	int temp;
	
	if (left < n && arr[largest] < arr[left]) {
	    temp = largest;
	    largest = left;
	    left = temp;
	}

	if (right < n && arr[largest] < arr[right]) {
	    temp = largest;
	    largest = right;
	    right = temp;
	}

	if (i != largest) {
	    swap(i, largest);
	    bubbleDown(arr, largest, n);
	}
    }

    private void buildMaxHeap() {
	for (int i = n / 2; i >= 0; i--) {
	    bubbleDown(sortedArr, i, n);
	}
    }
    
    private void sort() {
	buildMaxHeap();
	for (int i = n - 1; i >= 0; i--) {
	    swap(0, i);
	    bubbleDown(sortedArr, 0, i);
	}
    }
    
    public int[] getArr() {
	return sortedArr;
    }

    public double getRunTime() {
	return runTime;
    }
}

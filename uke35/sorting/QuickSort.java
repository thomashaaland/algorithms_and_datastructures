class QuickSort {
    int[] sortedArr;
    double runTime;
    int n;

    public QuickSort(int[] arr) {
	sortedArr = arr.clone();
	n = arr.length;
	long startTime = System.nanoTime();
	sort();
	long endTime = System.nanoTime();
	runTime = ((double) (endTime - startTime)) / 1000000000;
    }

    private int choosePivot(int[] arr, int low, int high) {
	int mid = (low + high) / 2;
	if (arr[low] < arr[mid]) {
	    if (arr[mid] < arr[high])
		return  mid;
	    else
		return high;
	}
	else
	    if (arr[low] < arr[high])
		return low;
	    else
		return high;
    }

    private void swap(int[] arr, int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }

    private int partition(int[] arr, int low, int high) {
	int p = choosePivot(arr, low, high);
	swap(arr, p, high);
	int pivot = arr[high];
	int left = low;
	int right = high - 1;

	while (left < right) {
	    while (left < right && arr[left] <= pivot) {
		left++;
	    }
	    while (right > left && arr[right] >= pivot) {
		right--;
	    }
	    if (left < right) {
		swap(arr, left, right);
	    }
	}
	swap(arr, high, left);
	return left;
    }

    private int[] quickSort(int[] arr, int low, int high) {
	if (low >= high) {
	    return arr;
	}
	int p = partition(arr, low, high);
	quickSort(arr, low, p - 1);
	quickSort(arr, p + 1, high);
	return arr;
    }
    
    private void sort() {
	quickSort(sortedArr, 0, n - 1);
    }

    public int[] getArr() {
	return sortedArr;
    }

    public double getRunTime() {
	return runTime;
    }
    
    
}

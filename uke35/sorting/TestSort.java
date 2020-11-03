import java.util.Random;


class TestSort {
    public static void main(String[] args) {
	Random rd = new Random();
	int n = 20000; // How many random numbers
	int[] unsorted = new int[n];

	for (int i = 0; i < n; i++) {
	    unsorted[i] = rd.nextInt(n);
	}

	
	SelectionSort selectionSort = new SelectionSort(unsorted);
	BubbleSort bubbleSort = new BubbleSort(unsorted);
	InsertionSort insertionSort = new InsertionSort(unsorted);
	HeapSort heapSort = new HeapSort(unsorted);
	MergeSort mergeSort = new MergeSort(unsorted);
	QuickSort quickSort = new QuickSort(unsorted);
	
	// int[] hs = quickSort.getArr();
	// for (int i = 0; i < n; i++) {
	//     System.out.print(hs[i] + " ");
	// }
	
	System.out.println("BubbleSort runtime:    " + bubbleSort.getRunTime());
	System.out.println("SelectionSort runtume: " + selectionSort.getRunTime());
	System.out.println("InsertionSort runtume: " + insertionSort.getRunTime());
	System.out.println("HeapSort runtume:      " + heapSort.getRunTime());
	System.out.println("MergeSort runtume:     " + mergeSort.getRunTime());
	System.out.println("QuickSort runtume:     " + quickSort.getRunTime());
    }
}

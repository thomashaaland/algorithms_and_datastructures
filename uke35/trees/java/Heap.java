class Heap {
    int n;
    int[] arr;
    int lastElement;
    
    public Heap() {
	n = 1000;
	arr = new int[n];
	lastElement = -1;
    }
    
    public Heap(int size) {
	n = size;
	arr = new int[n];
	lastElement = -1;
    }

    public void insert(int i) {
	lastElement++;
	arr[lastElement] = i;
	bubbleUp(lastElement);
    }

    public int peek() {
	if (isEmpty()) {
	    return -1;
	}
	return arr[0];
    }

    public int poll() {
	if (isEmpty()) {
	    return -1;
	}
	int retVal = arr[0];
	arr[0] = arr[lastElement];
	lastElement--;
	bubbleDown(0);
	return retVal;
    }

    private boolean isEmpty() {
	return lastElement < 0;
    }

    private void bubbleUp(int i) {
	int parent = (i - 1) / 2;
	if ((0 < i) && (arr[parent] > arr[i])) {
	    swap(parent, i);
	    bubbleUp(parent);
	}
    }

    private void bubbleDown(int i) {
	int leftChild = 2*i + 1;
	int rightChild = 2*i + 2;
	if (rightChild <= lastElement) {
	    if (arr[leftChild] <= arr[rightChild]) {
		if (arr[leftChild] < arr[i]) {
		    swap(leftChild, i);
		    bubbleDown(leftChild);
		}
	    }
	    else {
		if (arr[rightChild] < arr[i]) {
		    swap(rightChild, i);
		    bubbleDown(rightChild);
		}
	    }
	}
	else if (leftChild <= lastElement) {
	    if (arr[leftChild] < arr[i]) {
		swap(leftChild, i);
	    }
	}
    }
    
    private void swap(int i, int j) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }
    
}

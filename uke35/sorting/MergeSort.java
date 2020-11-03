class MergeSort {
    int[] sortedArr;
    double runTime;
    int n;

    public MergeSort(int[] arr) {
	sortedArr = arr.clone();
	n = arr.length;
	long startTime = System.nanoTime();
	sort();
	long endTime = System.nanoTime();
	runTime = ((double) (endTime - startTime)) / 1000000000;
    }

    private int[] lHalf(int[] arr) {
	int n = arr.length;
	int[] lH = new int[n / 2];
	for (int i = 0; i < n / 2; i++) {
	    lH[i] = arr[i];
	}
	return lH;
    }

    private int[] uHalf(int[] arr) {
	int n = arr.length;
	int[] uH = new int[n - n / 2];
	for (int i = 0; i < (n - n / 2); i++) {
	    uH[i] = arr[n / 2 + i];
	}
	return uH;
    }
	

    private int[] merge(int[] a1, int[] a2, int[] a) {
	int i = 0;
	int j = 0;

	while (i < a1.length && j < a2.length) {
	    if (a1[i] < a2[j]) {
		a[i + j] = a1[i];
		i++;
	    }
	    else {
		a[i + j] = a2[j];
		j++;
	    }
	}
	while (i < a1.length) {
	    a[i + j] = a1[i];
	    i++;
	}
	while (j < a2.length) {
	    a[i + j] = a2[j];
	    j++;
	}

	return a;
    }

    private int[] mergeSort(int[] a) {
	if (a.length <= 1) return a;
	int i = a.length / 2;
	int[] a1 = mergeSort(lHalf(a));
	int[] a2 = mergeSort(uHalf(a));
	return merge(a1, a2, a);
    }

    private void sort() {
	sortedArr = mergeSort(sortedArr);
    }
    
    public int[] getArr() {
	return sortedArr;
    }

    public double getRunTime() {
	return runTime;
    }
    
}
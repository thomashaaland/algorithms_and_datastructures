import java.util.Arrays;

class MaxsubSlow {
    int array[];
    int n;

    public MaxsubSlow(int[] array) {
	this.array = array;
	this.n = array.length + 1;
    }

    public int getSubArrayValue() {
	int m = 0;
	for (int j = 0; j < n; j++) {
	    for (int k = j; k < n; k++) {
		int s = 0;
		for (int i = j; i < k; i++) {
		    s = s + array[i];
		}
		if (s > m)
		    m = s;
	    }
	}
	return m;
    }
    
}

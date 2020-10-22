class ArrayMax {
    private int[] array;
    private int length;

    public ArrayMax(int[] array) {
	this.array = array;
	this.length = array.length;
    }

    private int findMax(){
	int currentMax = array[0];
	int currentValue = currentMax;
	for (int i = 1; i < this.length; i++) {
	    currentValue = array[i];
	    if (currentMax < currentValue)
		currentMax = currentValue;
	}
	return currentMax; 
    }

    public int getMax() {
	return findMax();
    }

    
}

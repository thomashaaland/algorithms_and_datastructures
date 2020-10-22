class FindMax {
    public static void main(String[] args) {
	int[] array = {4, 5, 1, 3, 6, 0, 9, 7, 4, 5, 8};
	int maxWithLoop = new ArrayMax(array).getMax();

	int maxWithRecurse = new RecursiveMax(array).getMax();
	
	System.out.println(maxWithLoop);
	System.out.println(maxWithRecurse);
    }
}

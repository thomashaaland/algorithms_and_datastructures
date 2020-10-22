class MaxSub {
    public static void main(String[] args) {
	int testArray[] = {-2, -4, 3, -1, 5, 6, -7, -2, 4, -3, 2, 3, 4, 5, 6, 7, 2, 3, 1, -12, 12, -12};

	long start = System.currentTimeMillis();
	int slow = new MaxsubSlow(testArray).getSubArrayValue();
	long finish = System.currentTimeMillis();
	long timeElapsed = finish - start;
	System.out.println(timeElapsed);

	
	start = System.currentTimeMillis();
	int faster = new MaxsubFaster(testArray).getSubArrayValue();
	finish = System.currentTimeMillis();
	timeElapsed = finish - start;
	System.out.println(timeElapsed);
	
	start = System.currentTimeMillis();
	int fastest = new MaxsubFastest(testArray).getSubArrayValue();
	finish = System.currentTimeMillis();
	timeElapsed = finish - start;
	System.out.println(timeElapsed);
	
	System.out.println(slow);
	System.out.println(faster);
	System.out.println(fastest);
    }
}

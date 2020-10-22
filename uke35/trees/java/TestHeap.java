class TestHeap {
    public static void main(String[] args) {
	Heap h = new Heap();
	h.insert(4);
	System.out.println(h.peek());
	System.out.println(h.poll());
	System.out.println(h.poll());
	h.insert(3);
	h.insert(44);
	h.insert(0);
	h.insert(12);
	h.insert(2);

	System.out.println(h.poll());
	System.out.println(h.poll());
	System.out.println(h.poll());
	System.out.println(h.poll());
	System.out.println(h.poll());
    }
}

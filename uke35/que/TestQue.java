class TestQue {
    public static void main(String[] args) {
	Que que = new Que(2);
	que.enque(1);
	que.enque(2);
	System.out.println(que.deque());
	System.out.println(que.deque());
    }
}
	    

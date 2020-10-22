class testStack {

    public static void main(String[] args) {
	Stack stack = new Stack(2);
	stack.pop();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	System.out.println(stack.pop());
	System.out.println(stack.pop());
	stack.pop();
    }
    
}

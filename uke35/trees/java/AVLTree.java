class AVLTree <T extends Comparable<T> > extends BinarySearchTree <T> {
    public AVLTree() {
	super();
    }

    // inserts recursively. works the same way as insert
    @Override
    protected Node insertRecursive(Node current, T key) {
	if (current == null)
	    current = new Node(key);
	else if (key.compareTo(current.key) < 0)
	    current.left = insertRecursive(current.left, key);
	else if (key.compareTo(current.key) > 0)
	    current.right = insertRecursive(current.right, key);
	current.height = height(current);
	return balance(current);
    }

    @Override
    protected Node remove(Node node, T key) {
	if (node == null)
	    return null;
	if (key.compareTo(node.key) < 0)
	    node.left = remove(node.left, key);
	else if (key.compareTo(node.key) > 0)
	    node.right = remove(node.right, key);
	else if (node.left == null)
	    node = node.right;
	else if (node.right == null)
	    node = node.left;
	else {
	    Node tNode = findMin(node.right);
	    node.key = tNode.key;
	    node.right = remove(node.right, tNode.key);
	}

	if (node != null)
	    node.height = height(node);
	else
	    return null;
	return balance(node);
    }

    protected Node rightRotate(Node node) {
	Node z = node;
	Node y = z.left;
	Node T2 = y.right;
		
	z.left = T2;
	y.right = z;

	z.height = height(z);
	y.height = height(y);
	return y;
    }

    protected Node leftRotate(Node node) {
	Node z = node;
	Node y = z.right;
	Node T1 = y.left;

	z.right = T1;
	y.left = z;
	
	z.height = 1 + Math.max(height(z.left), height(z.right));
	y.height = 1 + Math.max(height(y.left), height(y.right));
	return y;
    }

    protected int height(Node node) {
	return (node == null) ? -1 :
	    1 + Math.max(height(node.left), height(node.right));
    }
    
    protected int balanceFactor(Node node) {
	int balance = height(node.left) - height(node.right);
	return (node == null) ? 0 : (height(node.left) - height(node.right));
    }

    protected Node balance(Node node) {
	if (balanceFactor(node) < -1) {
	    if (balanceFactor(node.right) > 0)
		node.right = rightRotate(node.right);
	    Node y = leftRotate(node);
	    return y;
	}
	if (balanceFactor(node) > 1) {
	    if (balanceFactor(node.left) < 0)
		node.left = leftRotate(node.left);
	    Node y = rightRotate(node);
	    return y;
	}
	return node;
    }
    
}

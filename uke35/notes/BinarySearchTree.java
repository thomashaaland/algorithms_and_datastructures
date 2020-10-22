public class BinarySearchTree {
    private class Node {
	Node left, right;
	int value;

	public Node(int value) {
	    this.value = value;
	}
    }

    Node root;

    public void insert(int value) {
	if (root == null) {
	    root = new Node(value);
	} else {
	    insertRecursive(root, value);
	}
    }

    public void insertRecursive(Node current, int value) {
	if (value >= current.value) {
	    if (current.right == null) {
		current.right = new Node(value);
	    } else {
		insertRecursive(current.right, value);
	    }
	} else if (value < current.value) {
	    if (current.left == null) {
		current.left = new Node(value);
	    } else {
		insertRecursive(current.left, value);
	    }
	}
    }

    public Node find(int value) {
	if (root == null) {
	    return null;
	}

	return findRecursive(root, value);
    }

    public Node findRecursive(Node current, int value) {
	if (current.value == value) {
	    return current;
	}
	
	else if (current.value > value) {
	    return findRecursive(current.left, value);
	}
	else if (current.value < value) {
	    return findRecursive(current.right, value);
	}
    }
    
    public static void main(String[] args) {
	BinarySearchTree tree = new BinarySearchTree();
	
	tree.insert(30);
	tree.insert(35);
    }
}

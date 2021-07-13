package trees;

public class BSTree implements IBSTree {

	BSTNode root;
	public void getPreorder() {
		root.getPreorder();
	}
	public void getInorder() {
		root.getInorder();
	}
	public void getPostorder() {
		root.getPostorder();
	}
	public int getSize() {
		return root.getSize();
	}
	public int getHeight() {
		return root.getHeight();
	}
	public void insert(Integer key, String element) {
		BSTNode newNode = new BSTNode(key, element);
		if (root == null)
			root = newNode;
		else
			insert(newNode, root);
	}
	public void insert(BSTNode newNode, BSTNode node) {
		Integer key = newNode.key;
		if (key.compareTo(node.key) == 0) {
			System.out.println(key + " already exists. Duplicates are not allowed!!!.");
			return;
		}
		if (key.compareTo(node.key) < 0) {
			if (node.left == null) {
				node.left = newNode;
				newNode.parent = node;
			} else
				insert(newNode, node.left);
		} else {
			if (node.right == null) {
				node.right = newNode;
				newNode.parent = node;
			} else
				insert(newNode, node.right);
		}
	}
	public void remove(Integer key) {
		if (root == null) {
			System.out.println("Cannot remove: The tree is empty");
			return;
		}
		if (key.equals(root.key)) {
			if (root.left == null && root.right == null)
				root = null;
			else if (root.left == null || root.left == null) {
				if (root.left == null)
					root = root.right;
				if (root.right == null)
					root = root.left;
				root.parent = null;
			} else {
				remove(key, root);
			}
		} else
			remove(key, root);
	}
	public boolean remove(Integer key, BSTNode node) {
		if (node == null) {
			System.out.println("Cannot remove: The key doesn't exist");
			return false;
		}
		if (key.compareTo(node.key) < 0)
			return remove(key, node.left);

		if (key.compareTo(node.key) > 0)
			return remove(key, node.right);
		//Here, it means that key.compareTo(node.Key)==0
		//That is, we already have found it: node is the node to remove.

		//First case: the node is a leaf.
		if (node.left == null && node.right == null) {
			BSTNode parent = node.parent;
			//we must break the references between the node and its parent. First, we must detect if the
			//node is the left or right child of its parent.
			if (parent.left == node)
				parent.left = null;//node has to be the left child of its parent
			else
				parent.right = null; //node is the rightChild
			node.parent = null; //is is not necessary, because Java has automatic garbage collection
			return true;
		}
		//Second case is one the node only has a child: left or right
		if (node.left == null || node.right == null) {
			//its only child is its right child
			BSTNode grandChild = null;
			if (node.left == null)
				grandChild = node.right;
			else
				grandChild = node.left;

			BSTNode grandParent = node.parent;
			if (grandParent.left == node)
				grandParent.left = grandChild;
			else
				grandParent.right = grandChild;
			//the grand child must point its grand parent.
			grandChild.parent = grandParent;
			return true;
		}
		//Third case: node has two childs.
		//We can replace its value by the maximum value in its left child or
		//by the minimum value in its right child
		BSTNode sucesorNode = findMin(node.right);
		node.elem = sucesorNode.elem;
		node.key = sucesorNode.key;
		remove(sucesorNode.key, node.right);
		return true;
		//Finally, we must remove the sucesorNode
	}
	public BSTNode findMin(BSTNode node) {
		return null;
	}
	public BSTNode findRecMin(BSTNode node) {
		return null;
	}
	public BSTNode findMax(BSTNode node) {
		return null;
	}
	public BSTNode findRecMax(BSTNode node) {
		return null;
	}
	public String find(Integer key) {
		return find(root, key);
		//Iterative/recursive implementation
		/*BSTNode searchNode=root;
		while(searchNode!=null){
			int keyVisit=searchNode.key;
			if(key==keyVisit){
				//found it!!!
				return searchNode.elem;
			}
			else if(key<keyVisit){
				searchNode=searchNode.left;
			}
			else{
				searchNode=searchNode.right;
			}
		}
		 System.out.println(key+" does not exist");
		 return null;*/
	}
	public String find(BSTNode node, Integer key) {
		if (node == null)
			return null;
		else if (key.compareTo(node.key) < 0)
			return find(node.left, key);
		else if (key.compareTo(node.key) > 0)
			return find(node.right, key);
		else
			return node.elem;
	}
	public String findIt(Integer key) {
		BSTNode searchNode = root;
		while (searchNode != null) {
			int keyVisit = searchNode.key;
			if (key == keyVisit)
				return searchNode.elem;
			else if (key < keyVisit)
				searchNode = searchNode.left;
			else if (key > keyVisit)
				searchNode = searchNode.right;
		}
		System.out.println(key + " does not exist");
		return null;
	}
}
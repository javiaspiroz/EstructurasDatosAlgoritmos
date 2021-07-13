package trees;

public class BSTNode implements IBSTNode {	
	Integer key;
	String elem;
	BSTNode parent;
	BSTNode left;
	BSTNode right;
	public BSTNode(Integer k, String e) {
		key = k;
		elem = e;
	}
	public boolean isInternal() {
		return (left != null || right != null);
	}
	public boolean isExternal() {
		return (left == null && right == null);
	}
	public BSTNode getRoot() {
		if (parent == null)
			return this;
		else
			return parent.getRoot();
	}
	public boolean isRoot() {
		return parent == null;
	}
	public int getSize() {
		return getSize(this);
	}
	public int getSize(BSTNode node) {
		if (node==null){
			return 0;
		}
		else{
			return 1+getSize(node.left)+getSize(node.right);
		}
	}
	public int getHeight() {
		return getHeight(this);
	}
	public int getHeight(BSTNode node) {
		if (node==null){
			return -1;
		}
		else{
			return 1+Math.max(getHeight(node.left), getHeight(node.right));
		}
	}
	public int getDepth() {
		return getDepth(this);
	}
	public int getDepth(BSTNode node) {
		return -1;
	}
	public void getPreorder() {
		getPreorder(this);
	}
	public void getInorder() {
		getInorder(this);
	}
	public void getPostorder() {
		getPostorder(this);
	}	
	public void getLevelorder() {
		getPostorder(this);
	}
	public void getPreorder(BSTNode node) {
		
	}
	public void getInorder(BSTNode node) {
		if(node==null) return;
		getInorder(node.left);
		System.out.println("("+node.key+","+node.elem+")");
		getInorder(node.right);
	}
	public void getPostorder(BSTNode node) {
		
	}
	public void getLevelOrder(BSTNode node) {
		
	}
	public void getLevelOrder(BSTNode node, int level) {

	}
}
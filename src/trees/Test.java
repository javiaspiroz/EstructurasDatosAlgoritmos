package trees;

public class Test {

	public static void main(String[] args) {
		BSTree bstree = new BSTree();
		bstree.insert(19, "19");
		bstree.insert(12, "12");
		bstree.insert(16, "16");
		bstree.insert(23, "23");
		bstree.insert(20, "20");
		bstree.insert(34, "34");
		bstree.getInorder();
		bstree.remove(19);
		bstree.getInorder();
		bstree.remove(16);
		bstree.getInorder();
	}
}
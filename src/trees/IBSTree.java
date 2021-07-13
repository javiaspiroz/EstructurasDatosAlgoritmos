package trees;

public interface IBSTree {
	public Object find(Integer key);
	public void insert(Integer key, String elem);
	public void remove(Integer key);
}
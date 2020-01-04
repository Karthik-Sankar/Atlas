package test;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
}
class BinarySearchTree{
	public TreeNode insert(TreeNode curr, int data)
	{
		if(curr==null)
		{
			System.out.println("Inserting in root");
			curr = new TreeNode();
			curr.data = data;
		}
		else if(data < curr.data)
		{
			System.out.println("Inserting in left");
			curr.left = insert(curr.left, data);
		}
		else if(data > curr.data)
		{
			System.out.println("Inserting in right");
			curr.right = insert(curr.right, data);
		}
		return curr;
	}
	public void inorder(TreeNode root)
	{
		TreeNode temp = root;
		if(root!=null)
		{
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
}
public class TreeTest {
	public static void main(String[] args) {
		TreeNode root;
		BinarySearchTree bst = new BinarySearchTree();
		root = bst.insert(null, 15);
		bst.insert(root, 15);
		bst.insert(root, 25);
		bst.insert(root, 10);
		bst.insert(root, 45);
		bst.inorder(root);
	}
}

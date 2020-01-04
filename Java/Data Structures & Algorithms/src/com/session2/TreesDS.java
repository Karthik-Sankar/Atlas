package com.session2;
class TreeNode<T>{
	T data;
	TreeNode<T> left;
	TreeNode<T> right;
}

class Tree<T extends Comparable<T>>{

	int sum = 0;
	TreeNode<T> insert(TreeNode<T> node, T data)
	{
		if(node == null)
		{
			node = new TreeNode<T>();
			node.data = data;
		}
		else if(data.compareTo(node.data)<0)
		{
			node.left = insert(node.left,data);
		}
		else if(data.compareTo(node.data)>0)
		{
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	void inorder(TreeNode<T> root)
	{
		if(root!=null)
		{
			inorder(root.left);
			System.out.print(root.data+"\t");
			inorder(root.right);
		}
	}
	
	int inordersum(TreeNode<T> root, int depth, int freq[])
	{
		if(root!=null)
		{
//			System.out.println(root.data+"\t"+ depth);
			sum += depth*40;
			inordersum(root.left, depth+1, freq);
			inordersum(root.right, depth+1, freq);
		}
		return sum;
	}
	
	void sums()
	{
		sum = 0;
	}
	void preorder(TreeNode<T> root)
	{
		if(root!=null)
		{
			System.out.print(root.data+"\t");
			preorder(root.left);
			preorder(root.right);
		}
	}
	void postorder(TreeNode<T> root)
	{
		if(root!=null)
		{
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+"\t");
		}
	}
	
	TreeNode<T> find(TreeNode<T> root, T data)
	{
		if(data.compareTo(root.data) == 0)
		{
			return root;
		}
		else if(data.compareTo(root.data) < 0)
		{
			return find(root.left, data);
		}
		else if(data.compareTo(root.data) > 0)
		{
			return find(root.right, data);
		}
		return null;
	}
	
	TreeNode<T> findParent(TreeNode<T> root, TreeNode<T> parent,T data)
	{
		if(data.compareTo(root.data) == 0)
		{
			return parent;
		}
		else if(data.compareTo(root.data) < 0)
		{
			return findParent(root.left,root, data);
		}
		else if(data.compareTo(root.data) > 0)
		{
			return findParent(root.right,root, data);
		}
		return null;
	}
	
	T mindata(TreeNode<T> node)
	{
		T min = node.data;
		while(node.left!=null)
		{
			min = node.left.data;
			node = node.left;
		}
		return min;
	}
	T maxdata(TreeNode<T> node)
	{
		T max = node.data;
		while(node.right!=null)
		{
			max = node.right.data;
			node = node.right;
		}
		return max;
	}
	void delete(TreeNode<T> parent, TreeNode<T> node)
	{
		if(node.left==null && node.right==null)
		{
			if(parent.left==null)
			parent.right = null;
			if(parent.right==null)
			parent.left = null;
		}
		else if(node.left==null && node.right !=null)
		{
			node = node.right;
		}
		else if(node.right==null && node.left !=null)
		{
			node = node.left;
		}
		else if(node.left!=null && node.right!=null)
		{
			node = node.right;
		}
			
	}
}
public class TreesDS {

	public static void main(String[] args) {
//		Tree<Integer> t = new Tree<Integer>();
//		TreeNode<Integer> root = new TreeNode<Integer>();
//		root = t.insert(null, 14);
//		t.insert(root, 23);
//		t.insert(root, 7);
//		t.insert(root, 10);
//		t.insert(root, 33);
//		t.insert(root, 56);
//		t.insert(root, 80);
//		t.insert(root, 66);
//		t.insert(root, 70);
//		t.insert(root, 44);
//		t.insert(root, 50);
//		t.insert(root, 34);
//		System.out.println("Inorder traversal");
//		t.inorder(root);
//		System.out.println();
//		System.out.println("PreOrder traversal");
//		t.preorder(root);
//		System.out.println();
//		System.out.println("PostOrder traversal");
//		t.postorder(root);
//		TreeNode<Integer> x = t.find(root, 10);
//		System.out.println();
//		if(x!=null)
//			System.out.println(x.data+" found in tree");
//		else
//			System.out.println("Data Not Found");
//		
//		System.out.println("Min in tree : "+t.mindata(root));
//		System.out.println("Max in tree : "+t.maxdata(root));
//		
//		System.out.println("Deleting leaf node");
//		t.delete(t.findParent(root, root, 50), t.find(root, 50));
//		t.inorder(root);
//		//System.out.println("");
//		//System.out.println(t.find(root, 66));
//		System.out.println();
//		t.delete(t.findParent(root, root, 44), t.find(root, 44));
//		t.inorder(root);
		Tree<Integer> t2 = new Tree<Integer>();
		TreeNode<Integer> root2 = new TreeNode<Integer>();
		root2 = t2.insert(null, 1);
		int freq[] = {25,10,20}; 
		t2.insert(root2, 0);
		t2.insert(root2, 2);
		System.out.println(t2.inordersum(root2, 1, freq));
	}
	
}

//R'LR - Pre
//LRR'- Post
//LR'R - In

package com.session2;

//Moving Singleton out as a separate file
/*class Node<T>{
	public T data;
	public Node<T> link;
}*/

class List<T>{
	private static int size;
	Node<T> root;

	Node<T> getLast()
	{
		Node<T> head = root;
		while(head.link!=null)
		{
			head = head.link;
		}
		return head;
	}
	
	Node<T> getPrevLast()
	{
		Node<T> prev = null;
		if(root!=null) 
		{
			Node<T> head = root;
			while(head.link!=null)
			{
				prev = head;
				head = head.link;
			}
		}
		return prev;
	}
	
	Node<T> getPositional(int p)
	{
		Node<T> pos = root;
		for(int i=0; i<p; i++)
		{
			if(pos != null)
				pos = pos.link;
			else
				pos = null;
		}
		return pos;
	}
	
	void add(T data)
	{
		Node<T> temp = new Node<T>();
		temp.data = data;
		temp.link = null;
		if(root==null)
		{
			root = temp;
		}
		else
		{
			Node<T> curr = getLast();
			curr.link = temp;
			curr = null;
		}
		temp = null;
		size++;
	}
	
	void addInFront(T data)
	{
		Node<T> temp = new Node<T>();
		temp.data = data;
		temp.link = null;
		if(root==null)
		{
			root = temp;
		}
		else
		{
			temp.link = root;
			root = temp;
		}
		temp = null;
		size++;
	}
	
	void addinMiddle(T data, int pos)
	{
		Node<T> temp = new Node<T>();
		temp.data = data;
		temp.link = null;
		if(root==null)
		{
			root = temp;
		}
		else
		{
			Node<T> curr = getPositional(pos);
			if(curr!=null)
			{
				Node<T> tail = curr.link;
				curr.link = temp;
				temp.link = tail;
				tail = null;
			}
			else
			{
				System.out.println("Positional Argument Error!\n");
			}
			curr = null;
		}
		temp = null;
		size++;
	}
	
	void showList()
	{
		Node<T> temp = root;
		System.out.print("root > ");
		while(temp!=null)
		{
			System.out.print(temp.data+" > ");
			temp = temp.link;
		}
		System.out.println("null");
		System.out.println();
		temp = null;
		System.out.println("Size of the linked list : "+getSize());
		//System.out.println("Free Memory : "+Runtime.getRuntime().freeMemory()/1024+" Kb");
		System.out.println();
	}
	
	void delete()
	{
		Node<T> last = getPrevLast();
		if(last!=null)
		{
		last.link = null;
		size--;
		}
		else
		System.out.println("No element to delete...\n");
		
	}

	void deleteInFront()
	{
		if(root!=null)
		{
		root = root.link;
		size--;
		}
		else
		System.out.println("No element to delete...\n");
	}

	int getSize()
	{
		return size;
	}
}
public class LinkedList {

	public static void main(String[] args) {
		List<Object> l = new List<Object>();
		l.showList();
		l.delete();
		l.add(10);
		l.showList();
		l.add(20);
		l.showList();
		l.add(30);
		l.showList();
		l.add(40);
		l.showList();
		System.out.println("Adding data in the begining...");
		l.addInFront(50);
		l.showList();
		System.out.println("Adding in between...");
		l.addinMiddle(60, 2);
		l.showList();
		System.out.println("Deleting Last Element...");
		l.delete();
		l.showList();
		System.out.println("Deleting First Element...");
		l.deleteInFront();
		l.showList();
		//l.add("Karthik");
		//l.showList();
	}

}



/*
 * Output
 * 
 * root > null
 * 
 * Size of the linked list : 0
 * 
 * No element to delete...
 * 
 * root > 10 > null
 * 
 * Size of the linked list : 1
 * 
 * root > 10 > 20 > null
 * 
 * Size of the linked list : 2
 * 
 * root > 10 > 20 > 30 > null
 * 
 * Size of the linked list : 3
 * 
 * root > 10 > 20 > 30 > 40 > null
 * 
 * Size of the linked list : 4
 * 
 * Adding data in the begining... root > 50 > 10 > 20 > 30 > 40 > null
 * 
 * Size of the linked list : 5
 * 
 * Adding in between... root > 50 > 10 > 20 > 60 > 30 > 40 > null
 * 
 * Size of the linked list : 6
 * 
 * Deleting Last Element... root > 50 > 10 > 20 > 60 > 30 > null
 * 
 * Size of the linked list : 5
 * 
 * Deleting First Element... root > 10 > 20 > 60 > 30 > null
 * 
 * Size of the linked list : 4
 */

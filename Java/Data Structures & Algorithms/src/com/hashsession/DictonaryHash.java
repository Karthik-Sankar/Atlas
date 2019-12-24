package com.hashsession;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.session2.Node;

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
	
	List<T> add(T data)
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
		return this;
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
class OpenHash{
	Object[] a;
	static int size;
	int capacity;
	public OpenHash(int capacity) {
		this.capacity = capacity;
		size = 0;
		a = new Object[capacity];
	}
	public int hashcode(int key)
	{
		return key%capacity;
	}
	public void insert(int data)
	{
		int index = hashcode(data);
		if(a[index]==null)
		{
			List<Integer> list = new List<Integer>();
			a[index] = list.add(data);
			System.out.println("Data : "+data+" added in index : "+index);
			size++;
		}
		else
		{
			List<Integer> temp = (List<Integer>)a[index];
			temp.add(data);
			System.out.println("Data : "+data+" added in index : "+index);
			size++;
		}
	}
	public Object get(int data)
	{
		int index = hashcode(data);
		System.out.println(index);
		List<Integer> temp = (List<Integer>)a[index];
		if(temp!=null)
		{
			Node<Integer> t = temp.root;
			System.out.println("Data : "+t.data+" added in index : "+index);
			System.out.println("Data : "+t.link.data+" added in index : "+index);
		}
		else
			System.out.println("Data : "+temp+" added in index : "+index);	
		return a[index];
	}
}

public class DictonaryHash {
public static void main(String[] args) {
	OpenHash hashmap = new OpenHash(13);
	for (int i=0; i<=16; i++)
		hashmap.insert(i*i*7);
	hashmap.get(112);
	
	Set<String> set = new HashSet<String>();
	set.add("Mike");
	set.add("Leo");
	set.add("Sia");
	set.add("Mia");
	set.add("Sia");
	System.out.println(set);
	System.out.println(set.contains("Sia"));
	Iterator<String> itr = set.iterator();
	while(itr.hasNext())
	{
		System.out.println(itr.next());
	}
	
	System.out.println("Tree set");
	
	Set<String> set2 = new TreeSet<String>();
	set2.add("Mike");
	set2.add("Leo");
	set2.add("Sia");
	set2.add("Mia");
	set2.add("Sia");
	System.out.println(set2);
	System.out.println(set2.contains("Sia"));
	Iterator<String> itr2 = set2.iterator();
	while(itr2.hasNext())
	{
		System.out.println(itr2.next());
	}
	System.out.println();
	HashMap<Integer, String> set3 = new HashMap<Integer, String>();
	set3.put(101,"Mike");
	System.out.println(set3.get(101));
	set3.put(101, "Leo");
	System.out.println(set3.get(101));
	//System.out.println((int)(Math.random()*100)/10);
	}
}

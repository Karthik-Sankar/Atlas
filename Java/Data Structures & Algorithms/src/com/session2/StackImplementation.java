package com.session2;

//Moving Singleton out as a separate file
/*class Node<T>{
	public T data;
	public Node<T> link;
}*/

class Stacks<T>{
	Node<T> top;
	static int size;
	public Stacks() {
		this.top = null;
	}
	public Stacks(T data) {
		Node<T> temp = new Node<T>();
		temp.data = data;
		temp.link = null;
		this.top= temp;
		temp = null;
		size++;
	}
	public void push(T data)
	{
		Node<T> temp = new Node<T>();
		temp.data = data;
		temp.link = null;
		if(top==null)
		{
			top=temp;
		}
		else
		{
			temp.link = top;
			top = temp;
		}
		size++;
		temp = null;
	}
	public void pop()
	{
		if(top != null)
		{
			top = top.link;
			size--;
		}
		else
			System.out.println("Stack is empty!");
	}
	public void clear()
	{
		top=null;
	}
	public T peek()
	{
		return top.data;
	}
	public void showStack()
	{
		Node<T> temp = top;
		while(temp!=null)
		{
			System.out.println("|----|");
			System.out.println("| "+temp.data+" |");
			System.out.println("|----|");
			temp = temp.link;
		}
	}
}
public class StackImplementation {

	public static void printEmpty()
	{
		System.out.println();
	}
	public static void main(String[] args) {
		System.out.println("Creating stack with 10");
		Stacks<Integer> s = new Stacks<Integer>(10);
		printEmpty();
		s.showStack();
		System.out.println("\nPush 20");
		printEmpty();
		s.push(20);
		s.showStack();
		System.out.println("\nPush 30");
		printEmpty();
		s.push(30);
		s.showStack();
		System.out.println("\nPop");
		printEmpty();
		s.pop();
		s.showStack();
		System.out.println("\nPop");
		printEmpty();
		s.pop();
		s.showStack();
		System.out.println("\nPop");
		printEmpty();
		s.pop();
		s.showStack();
		System.out.println("\nPop");
		printEmpty();
		s.pop();
		s.showStack();
		System.out.println("\nPush 40");
		printEmpty();
		s.push(40);
		s.showStack();
		System.out.println("\nPush 50");
		printEmpty();
		s.push(50);
		s.showStack();
		System.out.println("\nPeek : "+s.peek());
	}

}



//Output 

//Creating stack with 10

//|----|
//| 10 |
//|----|

//Push 20

//|----|
//| 20 |
//|----|
//|----|
//| 10 |
//|----|

//Push 30

//|----|
//| 30 |
//|----|
//|----|
//| 20 |
//|----|
//|----|
//| 10 |
//|----|

//Pop

//|----|
//| 20 |
//|----|
//|----|
//| 10 |
//|----|

//Pop

//|----|
//| 10 |
//|----|

//Pop


//Pop

//Stack is empty!

//Push 40

//|----|
//| 40 |
//|----|

//Push 50

//|----|
//| 50 |
//|----|
//|----|
//| 40 |
//|----|

//Peek : 50

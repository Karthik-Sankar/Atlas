package com.session2;

class Queues <T>{
	Node<T> head;
	Node<T> tail;
	static int size;
	public Queues()
	{
		head = null;
		tail = null;
	}
	public Queues(T data)
	{
		Node<T> temp = new Node<T>();
		temp.data = data;
		temp.link = null;
		head = temp;
		tail = temp;
		temp = null;
	}
	
	public void enqueue(T data)
	{
		Node<T> temp = new Node<T>();
		temp.data = data;
		temp.link = null;
		
		if(head==null && tail==null) 
		{
			head = temp;
			tail = temp;
			size++;
			temp = null;
		}
		else
		{
			tail.link = temp;
			tail = tail.link;
			temp = null;
			size++;
		}
		temp = null;
	}
	
	public void dequeue()
	{
		if(head!=null && tail!=null)
		{
			head = head.link;
			size--;
		}
		else
		{
			System.out.println("Empty Queue");
		}
	}
	
	public void showQueue()
	{
		Node<T> temp = head;
		System.out.println("Current queue state : ");
		System.out.println("-------------------------------------");
		while(temp!=null)
		{
			System.out.print(temp.data+" >> ");
			temp = temp.link;
		}
		System.out.print("NULL\n");
		System.out.println("-------------------------------------");
		System.out.println("Size of the queue : "+size);
		System.out.println();
	}
}

public class QueueImplementation {

	public static void main(String[] args) {
		Queues<Integer> q = new Queues<Integer>();
		System.out.println("Operation : Enqueue 10\n");
		q.enqueue(10);
		q.showQueue();
		System.out.println("\nOperation : Enqueue 20\n");
		q.enqueue(20);
		q.showQueue();
		System.out.println("\nOperation : Enqueue 30\n");
		q.enqueue(30);
		q.showQueue();
		System.out.println("\nOperation : Enqueue 40\n");
		q.enqueue(40);
		q.showQueue();
		System.out.println("\nOperation : Enqueue 50\n");
		q.enqueue(50);
		q.showQueue();
		System.out.println("\nOperation : Dequeue\n");
		q.dequeue();
		q.showQueue();
		System.out.println("\nOperation : Enqueue 10\n");
		q.enqueue(10);
		q.showQueue();
		System.out.println("\nOperation : Dequeue\n");
		q.dequeue();
		q.showQueue();
	}

}

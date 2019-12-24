package com.session2;

class DNode<T>{
	public T data;
	public DNode<T> next;
	public DNode<T> previous;
	
	public DNode(T data, DNode<T> next, DNode<T> previous)
	{
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	public String toString() {
		return "|" + previous + "|" + data + "|" + next + "]";
	}
}

public class DoublyLinkedListDS {
	
}

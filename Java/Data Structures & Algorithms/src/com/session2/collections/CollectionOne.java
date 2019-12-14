package com.session2.collections;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CollectionOne {

	public static void main(String[] args) {
		/*
		 * List<Integer> l = new LinkedList<Integer>(); l.add(1); l.add(2); l.add(3);
		 * l.add(4); System.out.println(l); LinkedList<Integer> l2 = new
		 * LinkedList<Integer>(); l2.add(2); l2.add(1); l2.add(5); l2.add(3); l2.add(4);
		 * System.out.println(l2); System.out.println(l2.containsAll(new
		 * LinkedList<Integer>(l))); Collections.sort(l2); System.out.println(l2);
		 * Iterator<Integer> itr= l.iterator();
		 */
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s);
		s.remove(1);
		System.out.println(s);
	}

}

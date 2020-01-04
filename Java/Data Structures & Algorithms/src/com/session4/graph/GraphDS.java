package com.session4.graph;

import java.util.*;

class Graphs{
	int v;
	List<Integer>[] adjList;
	Graphs(int v)
	{
		this.v = v;
		adjList = new LinkedList[v];
		for(int i=0;i<v; i++)
		{
			adjList[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int v1, int v2)
	{
		adjList[v1].add(v2);
		adjList[v2].add(v1);
	}
	public void printAdjList()
	{
		for(int i=0; i<v; i++)
		{
			System.out.println("Vertex : "+i+" has edges : "+adjList[i]);
		}
	}
}

public class GraphDS {
	
	public static void main(String[] args) {
		Graphs graph = new Graphs(7);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(3, 4);
		graph.addEdge(2, 4);
		graph.addEdge(5, 6);
		graph.addEdge(4, 5);
		graph.printAdjList();
	}

}

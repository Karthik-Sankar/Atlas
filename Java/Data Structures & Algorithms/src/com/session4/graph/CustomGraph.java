package com.session4.graph;

import java.util.*;

class Edges{
	int v1;
	int v2;
	int w;
	public Edges(int v1, int v2, int w)
	{
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}
	@Override
	public String toString() {
		return "Edges [v1=" + v1 + ", v2=" + v2 + ", w=" + w + "]";
	}
	
}	

class MGraph{
	HashMap<Integer, LinkedList<Edges>> graph = new HashMap<Integer, LinkedList<Edges>>();
	int vCount=0;
	int eCount=0;
	private void addVertex(int vertex)
	{
		graph.put(vertex, new LinkedList<Edges>());
		vCount++;
	}
	public void addEdge(int vertex1, int vertex2, int weight) 
	{
		if(!graph.containsKey(vertex1))
			addVertex(vertex1);
		if(!graph.containsKey(vertex2))
			addVertex(vertex2);
		graph.get(vertex1).add(new Edges(vertex1, vertex2, weight));
		graph.get(vertex2).add(new Edges(vertex2, vertex1, weight));
		eCount+=2;
	}
	public void showAdjList()
	{
		for(Integer vertex : graph.keySet())
		{
			System.out.println("Vertex : "+ vertex + " Egdes : "+ graph.get(vertex));
		}
	}
	
	private Edges minEdge(int vertex)
	{
		LinkedList<Edges> edges = graph.get(vertex);
		edges.sort(new Comparator<Edges>() {
			@Override
			public int compare(Edges e1, Edges e2) {
				if(e1.w > e2.w) return 1;
				else if(e1.w < e2.w) return -1;
				else return 0;
			}
		});
		return edges.get(0);
	}
	
	public void vMinPairs()
	{
		for(int i = 0; i < vCount; i++)
		{
			System.out.println("Vertex : "+i);
			System.out.println("Edges : "+minEdge(i));
		}
	}
}

public class CustomGraph {

	public static void main(String[] args) {
		MGraph graph4 = new MGraph();
		graph4.addEdge(0, 1, 4);
		graph4.addEdge(1, 2, 2);
		graph4.addEdge(0, 2, 4);
		graph4.addEdge(0, 3, 6);
		graph4.addEdge(3, 2, 8);
		graph4.addEdge(0, 4, 6);
		graph4.addEdge(4, 3, 9);
		graph4.showAdjList();
		graph4.vMinPairs();
	}

}





//overlapping sub-problems
//optimal substructure property
package com.session4.graph;
import java.util.*;

class GenericGraphs<T>{
	protected int vertices=0;
	protected int edges=0;
	boolean[] visited = new boolean[vertices];
	HashMap<T, LinkedList<T>> graph;
	public GenericGraphs() {
		graph = new HashMap<T, LinkedList<T>>();
	}
	
	private void addVertex(T vertex)
	{
		graph.put(vertex, new LinkedList<T>());
		vertices++;
	}
	
	public void addEdge(T vertex1, T vertex2)
	{
		if(!graph.containsKey(vertex1))
			addVertex(vertex1);
		if(!graph.containsKey(vertex2))
			addVertex(vertex2);
		graph.get(vertex1).add(vertex2);
		graph.get(vertex2).add(vertex1);
		edges++;
	}
	public int vertices()
	{
		return vertices;
	}
	public int edges()
	{
		return edges;
	}
	public void printAdjList() {
		for(T key: graph.keySet())
		{
			System.out.println("Vertex : "+key+" has Edges : "+graph.get(key));
		}
	}
	public void BFS(T index)
	{
		System.out.println("BFS Algorithm");
		System.out.println("+++++++++++++");
		visited = new boolean[vertices];
		List<T> queue = new ArrayList<T>();
		queue.add(index);
		visited[(int)index] = true;
		while(!queue.isEmpty())
		{
			System.out.print(queue.get(0)+" ");
			T tidx = queue.remove(0);
			List<T> tlist = graph.get(tidx);
			Iterator<T> itr = tlist.iterator();
			while(itr.hasNext())
			{
				T tv = itr.next();
				if(visited[(int)tv]==false && !queue.contains(tv))
				{
					queue.add(tv);
					visited[(int)tv]=true;
				}
			}
		}
		System.out.println();
		System.out.println("+++++++++++++");
	}
	
	public void clearBools()
	{
		visited = new boolean[vertices];
	}
	
	public void DFS(T index)
	{
		System.out.print(index+" ");
		visited[(int)index]=true;
		for(T data:graph.get(index))
		{
			if(!visited[(int)data])
				DFS(data);
		}
	}
}


class DirectedGraph<T> extends GenericGraphs<T>{
	private void addVertex(T vertex)
	{
		graph.put(vertex, new LinkedList<T>());
		vertices++;
	}
	
	public void addEdge(T vertex1, T vertex2)
	{
		if(!graph.containsKey(vertex1))
			addVertex(vertex1);
		if(!graph.containsKey(vertex2))
			addVertex(vertex2);
		graph.get(vertex1).add(vertex2);
		edges++;
	}
}


class WeightedGraphs<T> extends GenericGraphs<T>{
	HashMap<T, HashMap<T, Integer>> graph;
	public WeightedGraphs() {
		graph = new HashMap<T, HashMap<T,Integer>>();
	}
	private void addVertex(T vertex)
	{
		graph.put(vertex, new HashMap<T, Integer>());
		vertices++;
	}
	
	public void addEdge(T vertex1, T vertex2, int weight)
	{
		if(!graph.containsKey(vertex1))
			addVertex(vertex1);
		if(!graph.containsKey(vertex2))
			addVertex(vertex2);
		graph.get(vertex1).put(vertex2,weight);
		graph.get(vertex2).put(vertex1,weight);
		edges++;
	}
	public void printAdjList() {
		for(T key: graph.keySet())
		{
			System.out.println("Vertex : "+key+" has Edges : "+graph.get(key));
		}
	}
	public HashMap<ArrayList<T>, Integer> getEdges()
	{
		HashMap<ArrayList<T>, Integer> edges = new HashMap<ArrayList<T>, Integer>();
		for(T key: graph.keySet())
		{
			
			for(T skey: graph.get(key).keySet())
			{
				ArrayList<T> temp = new ArrayList<T>();
				temp.add(key);
				temp.add(skey);
				edges.put(temp,graph.get(key).get(skey));
			}
			
		}
		return edges;
	}
	
	public List<Map.Entry<ArrayList<T>, Integer>> getSortedEdges()
	{
		HashMap<ArrayList<T>, Integer> edges = getEdges();
		List<Map.Entry<ArrayList<T>, Integer>> list = new LinkedList<Map.Entry<ArrayList<T>, Integer>>(edges.entrySet()); 
		Collections.sort(list, new Comparator<Map.Entry<ArrayList<T>,Integer>>() {
			public int compare(Map.Entry<ArrayList<T>,Integer> o1, Map.Entry<ArrayList<T>,Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		return list;
	}
	
	public void kruskal()
	{
		List<Map.Entry<ArrayList<T>, Integer>> e = getSortedEdges();
		Iterator<Map.Entry<ArrayList<T>, Integer>> itr = e.iterator();
		TreeSet<Integer> wset = new TreeSet<Integer>();
		while(itr.hasNext())
		{
			wset.add(itr.next().getValue());
		}
		System.out.println(wset);
		System.out.println(e.get(wset.pollFirst()));
		System.out.println(e.get(wset.pollFirst()));
		System.out.println(e.get(wset.pollFirst()));
		System.out.println(e.get(wset.pollFirst()));
		System.out.println(e.get(wset.pollFirst()));
	}

}

class Customer{
	int id;
	String name;
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}

public class GenGraph {

	public static void main(String[] args) {
		Customer c1 = new Customer(101, "Karthik");
		Customer c2 = new Customer(102, "Sankar");
		Customer c3 = new Customer(103, "Sarves");
		Customer c4 = new Customer(104, "Sam");
		GenericGraphs<Customer> graph = new GenericGraphs<Customer>();
		graph.addEdge(c1, c2);
		graph.addEdge(c1, c3);
		graph.addEdge(c1, c4);
		graph.addEdge(c2, c3);
		graph.addEdge(c2, c4);
		graph.addEdge(c3, c4);
//		graph.printAdjList();
//		System.out.println("Vertex Count: "+graph.vertices());
//		System.out.println("Edges Count: "+graph.edges());
//		System.out.println();
		GenericGraphs<Integer> graph2 = new GenericGraphs<Integer>();
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(1, 2);
		graph2.addEdge(1, 3);
		graph2.addEdge(3, 4);
		graph2.addEdge(2, 4);
		graph2.addEdge(5, 6);
		graph2.addEdge(4, 5);
//		graph2.printAdjList();
//		System.out.println("Vertex Count: "+graph2.vertices());
//		System.out.println("Edges Count: "+graph2.edges());
//		System.out.println();
		GenericGraphs<Customer> graph3 = new DirectedGraph<Customer>();
		graph3.addEdge(c1, c2);
		graph3.addEdge(c1, c3);
		graph3.addEdge(c1, c4);
		graph3.addEdge(c3, c4);
//		graph3.printAdjList();
//		System.out.println("Vertex Count: "+graph3.vertices());
//		System.out.println("Edges Count: "+graph3.edges());
//		System.out.println();
//		System.out.println("Weighted Graphs");
		WeightedGraphs<Integer> graph4 = new WeightedGraphs<Integer>();
		graph4.addEdge(0, 1, 4);
		graph4.addEdge(1, 2, 2);
		graph4.addEdge(0, 2, 4);
		graph4.addEdge(0, 3, 6);
		graph4.addEdge(3, 2, 8);
		graph4.addEdge(0, 4, 6);
		graph4.addEdge(4, 3, 9);
		graph4.printAdjList();
//		System.out.println();
//		System.out.println("+++++++++++++");
//		graph2.BFS(0);
//		graph2.clearBools();
//		System.out.println();
//		System.out.println("+++++++++++++");
//		System.out.println("DFS Algorithm");
//		System.out.println("+++++++++++++");
//		graph2.DFS(0);
//		System.out.println();
//		System.out.println("+++++++++++++");
		graph4.kruskal();
	}

}

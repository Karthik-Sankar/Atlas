package com.session4.graph;

public class KnapSackAlgorithm {

	
	public static int knapsackbrute(int[] w, int[] p, int c, int idx)
	{
		if(c<=0 || idx >= p.length)
			return 0;
		int profit1 = 0;
		if(w[idx]<=c)
		profit1 = p[idx]+knapsackbrute(w, p, c-w[idx], idx+1);
		int profit2 = knapsackbrute(w, p, c, idx+1);
		return profit1 > profit2 ? profit1 : profit2;
		
	}
	public static void main(String[] args) {
		String items[] = {"A", "B", "C", "D"};
		int profits[] = {1,6,10,16};
		int weights[] = {1,2,3,5};
		int c = 7;
		System.out.println(knapsackbrute(weights, profits, c, 0));
	}

}

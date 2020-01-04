package com.session4.graph;

import java.util.HashMap;

public class FibonacciDP {
	static HashMap<Integer, Integer> cache;
	public static int fibonacciBrute(int n)
	{
		System.out.println("times");
		if(n==0) return 0;
		else if(n==1) return 1;
		else return fibonacciBrute(n-1)+fibonacciBrute(n-2);
	}
	public static void initializeCache()
	{
		cache = new HashMap<Integer, Integer>();
	}
	private static int fibmemo(int n)
	{
		System.out.println("times");
		if(n==0) return 0;
		else if(n==1) return 1;
		else if(cache.get(n)!=null) return cache.get(n);
		else 
		{
			cache.put(n, fibmemo(n-1)+fibmemo(n-2));
			return cache.get(n);
		}
	}
	
	public static int fibonaccibup(int n)
	{
		System.out.println("times");
		int cache[] = new int[n+1];
		cache[0] = 0;
		cache[1] = 1;
		for(int i=2 ; i <=n; i++)
		{
			cache[i] = cache[i-1]+cache[i-2];
		}
		return cache[n];
	}
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		System.out.println("Brute");
		System.out.println(fibonacciBrute(5));
		System.out.println("Took "+(s-System.currentTimeMillis())+" ms");
		//System.out.println(fibonacciBrute(6));
		long s2 = System.currentTimeMillis();
		System.out.println("DP");
		initializeCache();
		System.out.println(fibmemo(5));
		System.out.println("Took "+(s2-System.currentTimeMillis())+" ms");
		long s3 = System.currentTimeMillis();
		System.out.println("DP - BUP");
		initializeCache();
		System.out.println(fibonaccibup(5));
		System.out.println("Took "+(s3-System.currentTimeMillis())+" ms");
	}

}
//0 1 1 2 3 5 8 13 21 34 55
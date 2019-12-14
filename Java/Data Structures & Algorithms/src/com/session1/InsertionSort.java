package com.session1;

public class InsertionSort {
	public static int[] insertionSort(int[] a)
	{
		for(int j=1; j<a.length; j++)
		{
			int key = a[j];
			System.out.println("Key value : "+key);
			int i = j-1;
			while(i>=0 && a[i]>key)
			{
				System.out.println("a[i+1] : "+a[i+1]+", a[i] : "+a[i]);
				a[i+1]=a[i];
				i--;
				System.out.println("i value : "+i);
			}
			a[i+1]=key;
		}
		return a;
	}
	public static void main(String[] args) {
		int[] a = {8,6,7,3,5,4,2,1};
		int[] b = insertionSort(a);
		//System.out.println(a.length + " == " + b.length);
		for(int x: b)
		{
			System.out.println(x);
		}
	}

}

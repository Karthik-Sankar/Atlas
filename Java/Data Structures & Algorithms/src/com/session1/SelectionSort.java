package com.session1;

public class SelectionSort {
	static int getMin(int[] a, int s, int d)
	{
		int pos = s;
		for(int i = s; i<d; i++)
		{
			if(a[s]>a[i])
			{
				pos = i;
			}
		}
		return pos;
	}
	static void swap(int[] a, int s, int d)
	{
		int temp;
		temp = a[s];
		a[s] = a[d];
		a[d] = temp;
	}
	static int[] selectionsort(int[] arr)
	{
		int a[] = arr;
		for(int i=0;i<a.length;i++)
		{
			int minpos = getMin(a, i, a.length);
			swap(a,i,minpos);
		}
		return a;
	}
	public static void main(String[] args) {
	
		int arr[] = {6,4,8,7,2,1};
		int narr[] = selectionsort(arr);
		//System.out.println(getMin(arr, 0, arr.length));
		for(int a:narr) { System.out.println(a); }
	}
}

package com.session1;

public class Searching {

	public static int linearSearch(int a[], int key)
	{
		for(int i=0;i<a.length;i++)
			if(a[i]==key)
				return i;
		return -1;
	}
	
	public static int binarySearch(int a[], int s, int d, int key) {
		int mid = (s+d)/2;
		if(a[mid]==key)
		{
			return mid;
		}
		else if(a[mid] > key)
		{
			return binarySearch(a, s, mid-1, key);
		}
		else if(a[mid] < key)
		{
			return binarySearch(a, mid+1, d, key);
		}
		else
			return -1;
	}
	public static void main(String[] args) {
		int arr[] = {4,6,7,3,2,1,5};
		System.out.println(linearSearch(arr, 2));
		int arr2[] = {1,2,3,4,5};
		System.out.println(binarySearch(arr2, 0, arr2.length, 4));
	}

}

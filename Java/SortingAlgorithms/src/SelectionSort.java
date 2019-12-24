public class SelectionSort {
	public void swap(int[]a, int i, int j)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public void selectionSort(int[] a)
	{
		for(int i=0;i<a.length-1;i++)
		{
			int min = i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[min]>a[j])
				{
					min = j;
				}
			}
			swap(a,i,min);
		}
	}
	public void bubbleSort(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length-i-1;j++)
			{
				if(a[j]>a[j+1])
					swap(a,j,j+1);
			}
		}
	}
	public void insertionsort(int[] a)
	{
		for(int i=1;i<a.length;i++)
		{
			int val = a[i];
			int hole = i;
			while(hole > 0 && val < a[hole-1])
			{
				a[hole] = a[hole-1];
				a[hole-1] = val;
				hole-=1;
			}
		}
	}
	
	public void merge(int[] l, int[] r, int a[])
	{
		int i=0,j=0,k=0;
		while(l.length > 0 && r.length > 0)
		{
			if(l[i]<r[j])
			{
				a[k] = l[i];
				i++;
			}
			else if(l[i]>r[j])
			{
				a[k] = r[j];
				j++;
			}
			k++;
		}
		while(i<l.length)
		{
			a[k] = l[i];
			k++;
			i++;
		}
		while(j<r.length)
		{
			a[k] = r[j];
			k++;
			j++;
		}
	}
	
	public void mergesort(int[] a, int l, int r)
	{
		int mid = (l+r)/2;
		int[] larr = new int[mid+1];
		int[] rarr = new int[mid+1];
		for(int i=l;i<mid;i++)
		{
			larr[i] = a[i];
		}
		for(int i=mid+1;i<r;i++)
		{
			rarr[i] = a[i];
		}
		mergesort(larr, l, mid);
		mergesort(rarr, mid+1, r);
		merge(larr, rarr, a);
	}
	
	public static void main(String[] args) {
		int[] a = {5,3,4,1,2,8,7,6,10,9};
		SelectionSort s= new SelectionSort();
		s.selectionSort(a);
		for(int i:a)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		int[] a2 = {5,3,4,1,2,8,7,6,10,9};
		s.bubbleSort(a2);
		for(int i:a2)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		int[] a3 = {5,3,4,1,2,8,7,6,10,9};
		s.insertionsort(a3);
		for(int i:a3)
		{
			System.out.print(i+" ");
		}
		int[] a4 = {5,3,4,1,2,8,7,6,10,9};
		s.mergesort(a4, 0, a4.length-1);
		for(int i:a4)
		{
			System.out.print(i+" ");
		}
		
	}
}

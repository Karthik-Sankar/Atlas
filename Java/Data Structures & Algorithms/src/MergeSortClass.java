
public class MergeSortClass {

	public void merge(int[] a, int s, int m, int d)
	{
		System.out.println("First : "+s+" Middle :"+m+" Last :"+d);
	}
	public void mergesort(int[] a, int s, int d)
	{
		if(s<d)
		{
			System.out.println(">>Dividing");
			for(int i=s; i<=d; i++)
			{
				System.out.print(a[i]+" ");
			}
			System.out.println();
			int middle = (s+d)/2;
			mergesort(a, s, middle);
			mergesort(a, middle+1, d);
			merge(a,s,middle,d);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,2,1,4};
		System.out.println("Arr in : "+arr);
		for(int i: arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		MergeSortClass m = new MergeSortClass();
		m.mergesort(arr, 0, arr.length-1);
		
	}

}


public class ArrReadWriteUpdate {

	public static void main(String[] args) {
		int a[] = new int[] {1,2,3,4,5};
		System.out.println("a[3] : "+a[3]);
		
		//Enhanced For Loop
		for(int i:a)
		{
			System.out.print(i+" ");
		}
		MultiDimensional m = new MultiDimensional();
		m.display();
	
	//GARBAGE COLLECTOR (GC) - REMOVES DATA FROM HEAP AREA
	//GC will keep on looking for data which is not used and then removes it.
	//GC Algo : Mark & Sweep
	//System.gc(); //Execute GC
	}

}

class MultiDimensional
{
	int[][] a = {{1,2,3,4,5},{6,7,8,9,10}};
	
	public void display()
	{
		System.out.println("ARR # "+a+ "Length ARR : "+a.length);
		System.out.println("ARR 0 "+a[0]+ "Length ARR : "+a[0].length);
		System.out.println("ARR 0 "+a[1]+ "Length ARR : "+a[1].length);
	}
}

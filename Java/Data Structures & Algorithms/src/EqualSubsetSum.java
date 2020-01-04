
public class EqualSubsetSum {

	public boolean canPartiton(int[] a) 
	{	int sum=0; 
		for(int i : a)
			sum+=i;
		if(sum%2 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String[] args) {
		
	}

}

package com.hashsession;

class Solution {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if(K >= A.length && K == 0)
            return A;
        else
        {
            int[] b = new int[A.length];
            int v = 0;
            for(int  i=K-1; i<A.length;i++)
            b[v++] = A[i];
            for(int i = 0; i<K-1; i++)
            b[v++] = A[i];
            //System.out.println(v);
            return b;
        }
    }
    void printarr(int[] a)
    {
    	for(int i : a)
    	{
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }
}

public class Codility {
	public static void main(String[] args) {
		Solution c = new Solution();
		int[] a = {3, 8, 9, 7, 6};
		int[] b = {5, -1000};
 		a = c.solution(a, 4);
		c.printarr(a);
		b = c.solution(b, 1);
		c.printarr(b);
	}
}

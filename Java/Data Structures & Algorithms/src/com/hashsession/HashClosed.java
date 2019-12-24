package com.hashsession;

class HashList{
	int size;
	Integer[] a = new Integer[30];
	int hash(int data)
	{
		return data%30;
	}
	void put(int hash, int data)
	{
		//System.out.println(hash);
		System.out.println(size);
		if(size >= 29) {
			
			System.out.println("Cant add more!");
			return;
		}
		if(a[hash]==null)
		{
			a[hash]=data;
			size++;
		}
		else
			put((hash+1%30), data);
	}
	void print()
	{
		for(Integer i:a)
		{
			//System.out.print(i+" ");
		}
		//System.out.println();
	}
}


public class HashClosed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashList h = new HashList();
		h.put(h.hash(31), 31);
		h.print();
		h.put(h.hash(32), 32);
		h.print();
		h.put(h.hash(33), 33);
		h.print();
		h.put(h.hash(41), 41);
		h.print();
		h.put(h.hash(51), 51);
		h.print();
		h.put(h.hash(54), 54);
		h.print();
		h.put(h.hash(65), 65);
		h.print();
		h.put(h.hash(31), 31);
		h.print();
		h.put(h.hash(32), 32);
		h.print();
		h.put(h.hash(33), 33);
		h.print();
		h.put(h.hash(41), 41);
		h.print();
		h.put(h.hash(51), 51);
		h.print();
		h.put(h.hash(54), 54);
		h.print();
		h.put(h.hash(65), 65);
		h.print();
		h.put(h.hash(31), 31);
		h.print();
		h.put(h.hash(32), 32);
		h.print();
		h.put(h.hash(33), 33);
		h.print();
		h.put(h.hash(41), 41);
		h.print();
		h.put(h.hash(51), 51);
		h.print();
		h.put(h.hash(54), 54);
		h.print();
		h.put(h.hash(65), 65);
		h.print();
		h.put(h.hash(31), 31);
		h.print();
		h.put(h.hash(32), 32);
		h.print();
		h.put(h.hash(33), 33);
		h.print();
		h.put(h.hash(41), 41);
		h.print();
		h.put(h.hash(51), 51);
		h.print();
		h.put(h.hash(54), 54);
		h.print();
		h.put(h.hash(65), 65);
		h.print();
		h.put(h.hash(32), 32);
		h.print();
		h.put(h.hash(33), 33);
		h.print();
		h.put(h.hash(41), 41);
		h.print();
		h.put(h.hash(51), 51);
		h.print();
		h.put(h.hash(54), 54);
		h.print();
		h.put(h.hash(65), 65);
		h.print();
		h.put(h.hash(60), 60);
		h.print();
	}

}

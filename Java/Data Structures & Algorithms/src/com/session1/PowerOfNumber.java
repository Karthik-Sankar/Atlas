package com.session1;

public class PowerOfNumber {
	//Brute force
	//Computation function or algorithm
	static int powerof(int x,int n)
	{
		while(n>1) {
			x *=x;
			n--;
		}
		return x;
	}
	public static void main(String[] args) {
		System.out.println(powerof(16,2));
	}

}

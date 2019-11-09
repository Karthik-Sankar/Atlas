#include<stdio.h>
int count=0;
int swap(int a,int b)
{
 int temp;
 temp = a;
 a=b;
 b = temp;
 printf(" a = %d \t b = %d\n",a,b);
 return 0;

}

int main()
{
 int sum;
 int i=10, j=15;
 swap(i,j);
 printf(" i = %d,\t j = %d\n",i,j);
} 

#include<stdio.h>

int* swap(int *a,int *b)
{
 int temp;
 temp = *a;
 *a=*b;
 *b = temp;
 printf(" a = %d \t b = %d\n",*a,*b);
 return &temp;

}

int main()
{
 int *ptr; 
 int sum;
 int i=10, j=15;
 ptr = swap(&i,&j);
 printf(" i = %d,\n",*ptr);

 printf(" i = %d,\n",*(ptr+1));
 printf(" i = %d,\n",*(ptr+2));
} 

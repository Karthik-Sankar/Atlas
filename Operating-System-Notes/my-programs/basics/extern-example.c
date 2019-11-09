#include<stdio.h>
#include"same.c"
int count;
int main()
{
 count++;
 printf("Count = %d\n",count);
 swap(10,15);
 printf("Count = %d\n",count);
}


#include<stdlib.h>
#include<stdio.h>
int main()
{
 int * ptr= (int*)malloc(sizeof(int));
 *ptr = 10;
 printf("*ptr = %d\n",*ptr);
}

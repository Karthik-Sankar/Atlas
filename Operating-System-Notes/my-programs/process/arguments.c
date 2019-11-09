#include<stdio.h>
int main(int argc, char *argv[])
{
 int i;
 printf("The list of command line arguments are:\n");
 for(i=0;i<argc;i++)
 {
   printf("Argument[%d] = %s\n",i,argv[i]);
 }
}

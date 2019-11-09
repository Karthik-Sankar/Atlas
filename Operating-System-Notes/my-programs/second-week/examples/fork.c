#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>

int main()
{
  int pid;
  printf("Hello");
  if((pid = fork())==0)
  {   //  _exit(0);
  printf("World");
       _exit(0);
  }
  printf("World");
}


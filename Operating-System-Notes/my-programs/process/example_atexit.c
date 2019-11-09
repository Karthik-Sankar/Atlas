#include<stdio.h>
//#include<stdlib.h>
void exit_handler1()
{
  printf("Exit handler 1 function being executed\n");
}

void exit_handler2()
{
 printf("exit handler 2 function being executed\n");
}

int main()
{
 atexit(exit_handler1);
 atexit(exit_handler2);
 printf("Main program about to return\n");
 _exit(-1);
// exit(0);
}

#include<stdio.h>
#include<stdlib.h>
void exithandler1()
{
	printf("Exit handler 1\n");
}
void exithandler2()
{
	printf("Exit handler 2\n");
}
int main()
{
	atexit(exithandler1);
	atexit(exithandler2);
	//graceful exit-flushes all the stream
	exit(0);
	//doesnt flushes streams - for child process
	//_exit(-1);s
}

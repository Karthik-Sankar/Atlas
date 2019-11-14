#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<errno.h>
void exithandler1()
{
	printf("Exit handler 1");
}
void exithandler2()
{
	printf("Exit handler 2");
}
int main()
{
	pid_t cid;
	atexit(exithandler1);
	atexit(exithandler2);
	if((cid=fork())>0)
	{
		printf("Parent process!\n");

	}
	else if(cid==0)
	{
		printf("In child process!\n");
		fflush(stdout);
		execlp("ls","al",(void*)0);
		fflush(stdout);
		
	}
	exit(1);
	perror("Error ");
}
#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
int main()
{
	pid_t child;
	int fd[2];
	if(pipe(fd)<0)
	{
		printf("Pipe creation failed!\n");
	}
	if((child=fork())>0)
	{
		printf("parent process closing stdin!\n");
		close(fd[0]);
		write(fd[1],"Test Message",45);
	}
	else if(child==0)
	{
		printf("child process closing stdout!\n");
		char* str = (char*)malloc(sizeof(45));
		close(fd[1]);
		read(fd[0],str,45);
		write(1,str,45);
		printf("\n");
		printf("parent message = %s\n",str);
	}
		
}

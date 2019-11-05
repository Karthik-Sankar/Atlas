#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
//#include<sys/wait.h> - 3. Adding this causes an error! - Why? & How to choose proper headers? 
#include<string.h>
#include<stdlib.h>
#define pf printf
#define sf scanf
int main()
{
	pid_t cid;
	int fd[2];
	//creating file descriptors
	if(pipe(fd) < 0)
	{
		pf("error in creating pipe!\n");
	}
	pf("fd[0]:%d\nfd[1]:%d\n",fd[0],fd[1]);
	if((cid = fork()) > 0)
	{
		pf("Parent Process!\n");
		close(fd[0]);//closing read end of the pipe for parent
		char *c = (char*)malloc(sizeof(char*));
		c = "This is a piped IPC from parent!";
		write(fd[1],c,strlen(c));
		//2. Why parent process not waiting for child process to complete ?
		if(waitpid(cid)){
			pf("Waiting for Child Process!\n");
			fflush(stdout);
		}
		//END
		pf("Parent Process Completed!\n");
		fflush(stdout);
	}
	else if(cid == 0)
	{
		pf("Child Process!\n");
		close(fd[1]);
		char *m = (char *)malloc(sizeof(char *));
		// 1. Does this line actually poses a limitation?
		int lc = read(fd[0], m, 200);
		//End
		write(1, m, lc);
		pf("\n");
		pf("Child Process Completed!\n");
		fflush(stdout);
	}
}
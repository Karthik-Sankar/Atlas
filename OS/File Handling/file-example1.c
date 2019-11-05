#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
#include<errno.h>
#define sf scanf
#define pf printf

void exithandler()
{
	perror("");
}

int main()
{
	int fd = open("file-sample.txt", O_APPEND|O_RDWR|O_CREAT, 0666);
	pid_t cid;
	pf("File Descriptor in FD: %d\n", fd);
	if(fd < 0)
	{
		pf("File Creation Error\n");
		atexit(exithandler);
		exit(1);
	}
	else
	{	
		char *c = (char *)malloc(sizeof(char *));
		sf("%s", c);
		c[strlen(c)+1] = "\0";
		pf("Write Exited with Code %d\n",write(fd, c, strlen(c)));
		//perror("Error : ");
		if((cid = fork())>0){
			pf("In parent process!\n");
			wait();
		}
		else if(cid==0){
			pf("In child process!\n");
			int erc = execl("/bin/cat", "file-sample.txt",0);
			//system("cat file-sample.txt");
			//pf("%d", erc);
			//_exit(0);
		}
	}
} 	
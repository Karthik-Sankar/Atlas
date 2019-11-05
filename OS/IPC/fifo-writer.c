#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
#define pf printf
#define sf scanf
int main()
{
	int fd;
	char *fp = (char*)malloc(sizeof(char));
	fp = "/home/karthiksankar/Desktop/Atlas/OS/IPC/fifo-pipe";
	if(mkfifo(fp, 0666)<0)
	{
		pf("File Creation Failed!");
	}

	while(1)
	{
		fd = open(fp,O_WRONLY);
		char *c = (char*)malloc(sizeof(char));
		sf("%s", c);
		write(fd,c,strlen(c));
		close(fd);
	}
}
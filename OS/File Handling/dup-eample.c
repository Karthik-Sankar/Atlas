#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>
int main(int argc, char* argv[])
{
	int fd;
	fd=dup(1);
	for(int i = 1; i<argc; i++)
	{
		int fdr = open(argv[i],O_RDWR,0222);
		char* data=(char*)malloc(500);
		read(fdr,data,500);
		write(1,data,strlen(data));
	}
	if(argc<=1)
	{
	char val;
	char* data = (char*)malloc(500);
	int i =0; 
	while((val=getchar())!=EOF)
	{
		data[i]=val;
		i++;
		putchar(val);
	}
	close(1);
	write(fd,data,strlen(data));
	}
	//fd=dup2(1,5);
}
#include<string.h>
#include<stdlib.h>
#include<sys/stat.h>
#include<fcntl.h>
#include<sys/types.h>
#include<unistd.h>
#include<stdio.h>
#include<sys/mman.h>


int main(int argc,char *argv)
{
int fd;
void *pmap;
int sd,sd1;
char buf[100],buf2[100];

fd=open("testfile.txt",O_RDWR);
if(fd==-1)
{
	perror("open");
	exit(1);
}
pmap=mmap(0,1000,PROT_READ|PROT_WRITE,MAP_SHARED,fd,0);
if(pmap==MAP_FAILED)
{
	perror("mmap");
	close(fd);
	exit(1);
}
sd=read(fd,buf,50);
printf("the file contents before change:%s\n",buf);
strncpy(pmap,"That",4);
sd1=read(fd,buf2,50);
close(fd);
buf2[sd1]='\0';
printf("the file contents after change:%s\n",buf2);
return 0;
}

#include<stdio.h>
#include<dirent.h>
#include<sys/types.h>
#include<fcntl.h>
#include<stdlib.h>
#include <sys/stat.h>
#include <unistd.h>
int main(int argc, char* argv[])
{
	DIR* dr;
	dr=opendir(".");
	struct dirent* st;
	while((st=readdir(dr))!=NULL)
	{
		struct stat fs;
		stat(st->d_name, &fs);
		printf("%o %d %s\n",fs.st_mode,fs.st_nlink,st->d_name);
		//printf("%d\n",st->d_ino);
	}
}
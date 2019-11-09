#include<stdio.h>
#include<fcntl.h>
#include<dirent.h>
#include<sys/types.h>
#include<stdlib.h>

int main(int argc,char *argv[])
{

DIR *dr;
dr=opendir(".");
struct dirent *st;

if(dr == NULL)
{
printf("error");
exit(1);
}

while( (st=readdir(dr)) !=NULL)
{

  printf(">> %s\n",st->d_name);

}

closedir(dr);
return 0;
}

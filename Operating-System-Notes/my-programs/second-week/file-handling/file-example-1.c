#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<fcntl.h>

int main()
{
 int fd;
 char str[100]; 
 fd = open("test.txt",O_APPEND|O_RDWR|O_CREAT,0666);
 if(fd<0)
 {
   printf(" Open failed\n");
   exit(1);
 }
 else
 {
  printf("Open was successful with fd = %d\n",fd);
  while(read(fd,str,100)>0)
  {
    printf("The file contains : %s \n",str);
  }
  close(fd);
 }
}

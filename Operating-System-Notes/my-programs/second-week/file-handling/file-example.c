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
 fd = open("test.txt",O_RDWR|O_CREAT,0666);
 if(fd<0)
 {
   printf(" Open failed\n");
   exit(1);
 }
 else
 {
  lseek(fd,0,SEEK_END);
  printf("Open was successful with fd = %d\n",fd);
  write(fd,"truncate works by default?", 10);  //strlen("truncate works by default?"));
  lseek(fd,500,SEEK_CUR);
  write(fd,"truncate works by default?", 10);  //strlen("truncate works by default?"));
  close(fd); 
 }
} 

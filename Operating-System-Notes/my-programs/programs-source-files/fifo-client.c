#include<stdio.h>
#include<stdlib.h>
#include<sys/stat.h>
#include<unistd.h>
#include<fcntl.h>
int main()
{
 int fd;
 int i,j,k;
 char str[100];

/* if((i=mkfifo("./fifo1",O_RDWR))<0)
 {
   printf("mkfifo error\n");
   exit(1);
 }
*/
 fd = open("./fifo2",O_RDONLY);
 if(fd<0)
 {
  printf("Open failed\n");
  exit(1);
 }
 while(1)
 {
    j = read(fd,str,100);
    printf("Client sent : ");
    write(1,str,j);
 } 
 close(fd);
} 

#include<stdio.h>
#include<stdlib.h>
#include<sys/stat.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>
int main()
{
 int fd;
 int i,j,k;
 char str[100];

/* if((i=mkfifo("./fifo1",777))<0)
 {
   printf("mkfifo error\n");
   exit(1);
 }
*/
 fd = open("./fifo1",O_WRONLY);
 if(fd<0)
 {
  printf("Open failed\n");
  exit(1);
 }
 while(1)
 {
    printf("Type to be sent to server :\n");
    scanf("%s",str); 
    j = write(fd,str,strlen(str));
 } 
 close(fd);
} 

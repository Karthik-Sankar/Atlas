#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<string.h>

int main()
{
 int fd[2];
 pid_t pid; 
 int length;
 char str[100];
// printf("The size of the pipe buffer is %ld\n",PIPE_BUF); 
 if(pipe(fd)<0)
 {
   printf("Error creating pipe\n");
   exit(1);
 }
 if((pid = fork())<0)
 {
   printf("error forking\n");
   exit(1);
 }
 if(pid==0)
 {
    printf("Child Process closing read descriptor\n");
    close(fd[0]);
    while(1)
    {
      printf("Enter a string to be sent to parent process\n");
      scanf("%s",str);
      length = write(fd[1],str,strlen(str));
      if(length<strlen(str))
      {
        printf("Write Error\n");
        exit(1);
      }
    }
 }
 else if(pid>0)
 {
    printf("Parent Process closing write descriptor\n");
    close(fd[1]);
    while(1)
    {
      length = read(fd[0],str,100);
      printf("The string sent by child process is \n");
      write(1,str,length);   //printf("%s\n",str);
    }
 }
}

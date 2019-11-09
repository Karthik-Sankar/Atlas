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
    fflush(stdout);
    close(fd[0]);
    while(1)
    {
      sleep(1); 
      fflush(stdout);
      printf("Enter a string to be sent to parent process\n");
      fflush(stdout);
      fflush(stdin);
      scanf("%s",str);
      length = write(fd[1],str,strlen(str));
      if(length<strlen(str))
      {
        fflush(stdout);
        printf("Write Error\n");
        exit(1);
      }
    }
 }
 else if(pid>0)
 {
    fflush(stdout);
    printf("Parent Process closing write descriptor\n");
    fflush(stdout);
    close(fd[1]);
    while(1)
    {
      length = read(fd[0],str,100);
      printf("The string sent by child process is \n");
      fflush(stdout);
      write(1,str,length);   
      str[length]='\0'; 
      printf("%s\n",str);
    }
 }
}

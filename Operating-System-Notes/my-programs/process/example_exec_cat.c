#include<stdio.h>
#include<sys/wait.h>
#include<errno.h>
#include<unistd.h>
#include<stdlib.h>
int main( int argc, char **argv)
{
 int pid,status;
 char *args[] = {"/bin/cat","test.txt",NULL}; 
 if((pid=fork())<0)
 {
   printf("fork failed\n");
   exit(1);
 }
 else if(pid == 0)
 {
   printf("Fork successful, callling exec\n");
   execvp(args[0],args);   //"/home/drothningsvik/ACOS/my-programs/process/test.txt",NULL);
//     execl(arg0,arg1,arg3);     //"/bin/cat","test.txt",(char*)0);
 }
 else
 {
    while(waitpid(pid, &status,0)<0)
    {
      if(errno !=EINTR)
      {
        printf("error but not interrupt\n");
        exit(1);
      }
    }
 }
}



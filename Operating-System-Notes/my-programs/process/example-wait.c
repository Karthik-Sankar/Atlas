#include<stdio.h>
#include<unistd.h>

int main()
{
 pid_t pid,ppid,cid;

 if((cid=fork())>0)
 {
//    while(1)
    { 
     wait(); 
     printf("PARENT : This is parent process with process id %d\n",getpid());
     printf("PARENT : The created child process is with process id %d\n",cid);
    }
 }
 else if(cid==0)
 {
//   while(1)
   {
    printf("CHILD : the child process id is %d\n",getpid());  
    printf("CHILD : The parent process id is %d\n",getppid());
   }
 }
}


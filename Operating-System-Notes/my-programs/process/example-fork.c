#include<stdio.h>
#include<unistd.h> 
int main()
{
 pid_t pid,cid;
 if((cid = fork())> 0)
 {
  printf("Parent process id is %d\n",getpid());  
  printf(" Child process created with pid %d\n",cid);
 }
 else if(cid==0) 
 {
   printf("In child process\n");
   printf("the child process id is %d\n",getpid());
 }
}


#include<stdio.h>
#include<unistd.h> 
int main()
{
 pid_t pid,cid;
// char argv[5][5];
// strcpy(argv[0],"-al");
// strcpy(argv[1],""); 
 if((cid = fork())> 0)
 {
  wait(); 
  printf("Parent process id is %d\n",getpid());  
  printf(" Child process created with pid %d\n",cid);
 }
 else if(cid==0) 
 {
   printf("In child process\n");
   printf("the child process id is %d\n",getpid());
   printf("The child process : getppid = %d\n",getppid()); 
   execl("/bin/cat","a.txt",(char *)0); 
 }
}


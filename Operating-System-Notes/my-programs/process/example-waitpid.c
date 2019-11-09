#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<signal.h>
#include<sys/wait.h>
#include<errno.h>
static void sig_chld_handler(int signo)
{
  int pid;
  int status;
  printf("SIGCHLD received\n");
  if(signal(SIGCHLD,sig_chld_handler)==SIG_ERR)
       perror("signal error");
  if((pid=wait(&status))<0)
         perror("Wait error");
  printf("pid = %d\n",pid);
}

int main()
{
 pid_t cid1,cid2;
 int return_cid1, return_cid2;
 int err;
 int wait_ret1,wait_ret2; 
 if(signal(SIGCHLD,sig_chld_handler)==SIG_ERR)
      perror("signal error");
 printf("SIGCHLD registered\n");
 if((cid1 = fork())>0)
 {
//  fflush(stdout); 
  printf("PARENT : Created Child process %d\n",cid1);
  if((cid2 = fork())>0)
  {
    sleep(10);
  fflush(stdout); 
    printf("PARENT : Created Child process %d\n",cid2);
    if((wait_ret2=waitpid(cid2,&return_cid2,0))==cid2)
      printf("PARENT : Waited for child process with %d to complete with a return status %d\n",cid2,return_cid2);
    else
    {  
     printf("Waitpid for cid1 error %d\n",wait_ret2);
     err = errno; 
//     printf("%s\n",explain_errno_waitpid(err,cid2,&return_cid2));
     fflush(stdout); 
    } 
    
//    if((wait_ret1=waitpid(cid1,&return_cid1,0))==cid1)
//      printf("PARENT : Waited for child process with %d to complete with a return status %d\n",cid1,return_cid1);
//    else
//    {  
//     printf("Waitpid for cid1 error %d\n",wait_ret1);
//     err = errno; 
//     printf("%s\n",explain_errno_waitpid(err,cid1,&return_cid1));
//     fflush(stdout); 
//    } 
  }
  else if(cid2==0)
  {
    
   printf("SECOND CHILD PROCESS with pid %d\n",getpid());
   printf("SECOND CHILD PROCESS of parent process with pid %d\n",getppid());
//    sleep(5);
    printf("child 2 completed returning\n");
    fflush(stdout);
    exit(-2); 
  }
 }
 else if(cid1==0)
 {
  printf("FIRST CHILD PROCESS with pid %d\n",getpid());
  printf("FIRST CHILD PROCESS of parent process with pid %d\n",getppid());
//    sleep(5);
    printf("child 1 completed returning\n");
    fflush(stdout);
    exit(-1); 
 }
} 

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<signal.h>

void sig_usr(int signo)
{
  printf("Triggered QUIT Signal\n");
}

int main()
{
 int i=0,stat; 
 sigset_t newmask, oldmask,pendmask; 
 
 if(signal(SIGQUIT, sig_usr)==SIG_ERR)
 {
   printf("SIgnal error\n");
   exit(1); 
 }
 raise(SIGQUIT); 
 sigemptyset(&newmask);
 sigaddset(&newmask, SIGQUIT);
 
 if(sigprocmask(SIG_BLOCK, &newmask, &oldmask) < 0)
 {
   printf("Sig block error\n");
   exit(1);
 }
 sleep(5);
 raise(SIGQUIT);
 
 if(sigpending(&pendmask)<0)
 {
   printf("sigpending error\n");
   exit(1);
 }
 sleep(2);
 if(sigismember(&pendmask, SIGQUIT))
    printf("SIGQUIT is pending\n");
 raise(SIGQUIT);
} 


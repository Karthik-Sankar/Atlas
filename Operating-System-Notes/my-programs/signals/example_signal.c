#include<stdio.h>
#include<stdlib.h>
#include<signal.h>

void sig_usr(int signo)
{
 if(signo == SIGUSR1)
     printf("received SIGUSR1\n");
 else if(signo == SIGUSR2)
     printf("received SIGUSR2\n");
 else
     printf("received signal %d\n",signo);
}

int main()
{
 if(signal(SIGUSR1,sig_usr)==SIG_ERR)
 {
   printf("cant catch SIGUSR1\n");
   exit(1);
 }
 if(signal(SIGUSR2,sig_usr)==SIG_ERR)
 {
   printf("cant catch SIGUSR2\n");
   exit(1);
 }

 if(signal(SIGTERM,sig_usr)==SIG_ERR)
 {
   printf("cant catch SIGTERM\n");
   exit(1);
 }
 while(1)
     pause();
}

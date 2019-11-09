#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<signal.h>

void sig_usr(int signo)
{
  printf("Triggered Alarm Signal\n");
}

int main()
{
 int i=0,stat; 
 if(signal(SIGALRM, sig_usr)==SIG_ERR)
 {
   printf("SIgnal error\n");
 }
 while(i++<2)
 {
       sleep(2);
       stat = alarm(4);
       printf("The status value is %d\n",stat);
 }
 pause(); 
}

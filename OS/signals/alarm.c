#include<signal.h>
#include<stdio.h>
void sig_us(int signo)
{
	printf("Triggered Alarm %d\n", signo);
}
int main()
{
	int i=0, stat;
	if(signal(SIGALRM, sig_us)==SIG_ERR){
		printf("Signal Error");
	}
	while(i++<2){
		sleep(2);
		stat = alarm(4);
		printf("The stat value is %d\n", stat);
	}
	pause();
}
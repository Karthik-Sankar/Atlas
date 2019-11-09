#include<stdio.h>
#include<signal.h>
void sig_cntl(int signum)
{
	//signal(SIGINT, sig_cntl);
	printf("CNTRL_C PRESSED");
	fflush(stdout);
}
void sig_cntl2(int signum)
{
	//signal(SIGSTOP, sig_cntl);
	printf("CNTRL_D PRESSED");
	fflush(stdout);
}
int main()
{
	signal(SIGINT, sig_cntl);
	signal(SIGTERM, sig_cntl2);
	while(1)
	{

	}
}
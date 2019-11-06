#include<stdio.h>
#include<signal.h>
void sig_cntl(int signum)
{
	signal(SIGINT, sig_cntl);
	printf("You cannot terminate this process!");
	fflush(stdout);
}
int main()
{
	signal(SIGINT, sig_cntl);
	while(1)
	{

	}
}